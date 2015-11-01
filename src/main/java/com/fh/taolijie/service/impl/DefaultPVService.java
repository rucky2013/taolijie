package com.fh.taolijie.service.impl;

import com.fh.taolijie.constant.RedisKey;
import com.fh.taolijie.dao.mapper.PVModelMapper;
import com.fh.taolijie.domain.PVModel;
import com.fh.taolijie.service.PVService;
import com.fh.taolijie.utils.Constants;
import com.fh.taolijie.utils.JedisUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import java.util.Calendar;
import java.util.Date;
import java.util.Map;
import java.util.TreeMap;

/**
 * Created by whf on 11/1/15.
 */
@Service
public class DefaultPVService implements PVService {

    @Autowired
    private JedisPool jedisPool;

    @Autowired
    private PVModelMapper pvMapper;

    @Override
    public String getJobPV(Integer jobId) {
        return queryPV(jobId, RedisKey.HASH_PV_JOB);
    }

    @Override
    public String getShPV(Integer shId) {
        return queryPV(shId, RedisKey.HASH_PV_SH);
    }

    @Override
    public void incrAllPV() {
        Calendar calendar = Calendar.getInstance();
        int hour = calendar.get(Calendar.HOUR_OF_DAY) + 1;

        Jedis jedis = JedisUtils.getClient(jedisPool);
        jedis.hincrBy(RedisKey.HASH_PV_ALL.toString(), String.valueOf(hour), 1);
        JedisUtils.returnJedis(jedisPool, jedis);
    }

    @Override
    @Transactional(readOnly = false, rollbackFor = Throwable.class)
    public int saveAllPV() {
        // 从Redis中查出今日PV数据
        Jedis jedis = null;

        try {
            jedis = JedisUtils.getClient(jedisPool);
            Map<String, String> map = jedis.hgetAll(RedisKey.HASH_PV_ALL.toString());

            // 排序
            Map<String, String> sortedMap = new TreeMap<>( (k1, k2) -> k1.compareTo(k2));
            sortedMap.putAll(map);

            // 遍历
            StringBuilder sb = new StringBuilder(120);
            for (Map.Entry<String, String> entry : sortedMap.entrySet()) {
                sb.append(entry.getValue());
                sb.append(Constants.DELIMITER);
            }

            // 插入到数据库
            PVModel pvModel = new PVModel();
            pvModel.setCreatedTime(new Date());
            pvModel.setData(sb.toString());
            pvMapper.insertSelective(pvModel);

            // 清空redis中的PV数据
            jedis.del(RedisKey.HASH_PV_ALL.toString());

        } catch (Exception e) {
            throw e;

        } finally {
            // 防止redis连接泄漏
            JedisUtils.returnJedis(jedisPool, jedis);
        }

        return 0;
    }

    private String queryPV(Integer postId, RedisKey key) {
        Jedis jedis = JedisUtils.getClient(jedisPool);
        String pv = jedis.hget(key.toString(), postId.toString());
        if (null == pv) {
            pv = "0";
        }

        JedisUtils.returnJedis(jedisPool, jedis);

        return pv;
    }
}
