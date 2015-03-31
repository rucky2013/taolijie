package com.fh.taolijie.service.impl;

import com.fh.taolijie.controller.dto.JobPostDto;
import com.fh.taolijie.domain.JobPostCategoryEntity;
import com.fh.taolijie.domain.JobPostEntity;
import com.fh.taolijie.domain.MemberEntity;
import com.fh.taolijie.domain.ResumeEntity;
import com.fh.taolijie.service.JobPostService;
import com.fh.taolijie.service.ReviewService;
import com.fh.taolijie.service.repository.JobPostCategoryRepo;
import com.fh.taolijie.service.repository.JobPostRepo;
import com.fh.taolijie.service.repository.ResumeRepo;
import com.fh.taolijie.service.repository.SchoolRepo;
import com.fh.taolijie.utils.CollectionUtils;
import com.fh.taolijie.utils.Constants;
import com.fh.taolijie.utils.StringUtils;
import com.fh.taolijie.utils.json.JsonWrapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.Parameter;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.*;

/**
 * Created by wanghongfei on 15-3-7.
 */
@Repository
public class DefaultJobPostService extends DefaultPageService implements JobPostService {
    private static Logger logger = LoggerFactory.getLogger(DefaultJobPostService.class);

    @Autowired
    private ReviewService reviewService;

    @Autowired
    private JobPostRepo postRepo;

    @Autowired
    private ResumeRepo resumeRepo;

    @Autowired
    private SchoolRepo schoolRepo;

    @Autowired
    private JobPostCategoryRepo jobCateRepo;

    @PersistenceContext
    EntityManager em;

    @Override
    @Transactional(readOnly = true)
    public List<JobPostDto> getAllJobPostList(int firstResult, int capacity) {
        int cap = CollectionUtils.determineCapacity(capacity);

        Page<JobPostEntity> entityList = postRepo.findAllOrderByPostTime(new PageRequest(firstResult, cap));

/*        return CollectionUtils.transformCollection(entityList, JobPostDto.class, (entity) -> {
            JobPostDto dto =  CollectionUtils.entity2Dto(entity, JobPostDto.class, null);
            dto.setCategoryId(entity.getCategory().getId());
            dto.setCategoryName(entity.getCategory().getName());
            dto.setMemberId(entity.getMember().getId());

            return dto;
        });*/


        return CollectionUtils.transformCollection(entityList, JobPostDto.class, (entity) -> {
            return CollectionUtils.entity2Dto(entity, JobPostDto.class, (postDto) -> {
                postDto.setCategoryName(entity.getCategory().getName());
                postDto.setCategoryId(entity.getCategory().getId());
                postDto.setMemberId(entity.getMember().getId());
            });
        });

    }

    @Override
    @Transactional(readOnly = true)
    public List<JobPostDto> getJobPostListByMember(Integer memId, int firstResult, int capacity) {
        MemberEntity mem = em.getReference(MemberEntity.class, memId);

        int cap = CollectionUtils.determineCapacity(capacity);

        Page<JobPostEntity> entityList = postRepo.findByMember(mem, new PageRequest(firstResult, cap));
/*        List<JobPostEntity> postList = em.createNamedQuery("jobPostEntity.findByMember", JobPostEntity.class)
                .setParameter("member", mem)
                .setFirstResult(firstResult)
                .setMaxResults(cap)
                .getResultList();*/

        return CollectionUtils.transformCollection(entityList, JobPostDto.class, (entity) -> {
            return CollectionUtils.entity2Dto(entity, JobPostDto.class, (postDto) -> {
                postDto.setCategoryName(entity.getCategory().getName());
                postDto.setCategoryId(entity.getCategory().getId());
                postDto.setMemberId(entity.getMember().getId());
            });
        });
    }

    @Override
    @Transactional(readOnly = true)
    public List<JobPostDto> getJobPostListByCategory(Integer cateId, int firstResult, int capacity) {
        int cap = capacity;
        if (cap <= 0) {
            cap = Constants.PAGE_CAPACITY;
        }

        JobPostCategoryEntity cate = em.getReference(JobPostCategoryEntity.class, cateId);
        List<JobPostEntity> postList = em.createNamedQuery("jobPostEntity.findByCategory", JobPostEntity.class)
                .setParameter("category", cate)
                .setFirstResult(firstResult)
                .setMaxResults(cap)
                .getResultList();

        return CollectionUtils.transformCollection(postList, JobPostDto.class, (entity) -> {
            return CollectionUtils.entity2Dto(entity, JobPostDto.class, (postDto) -> {
                postDto.setCategoryName(entity.getCategory().getName());
                postDto.setCategoryId(entity.getCategory().getId());
                postDto.setMemberId(entity.getMember().getId());
            });
        });
    }

    @Override
    @Transactional(readOnly = true)
    public List<JobPostDto> getAndFilter(Integer categoryId, String wayToPay, boolean orderByDate, boolean orderByPageVisit, Integer schoolId, int firstResult, int capacity) {
        if (orderByDate && orderByPageVisit) {
            throw new IllegalStateException("boolean参数最多只能有一个为true");
        }

        StringBuilder query = new StringBuilder("SELECT job FROM JobPostEntity job WHERE ");

        Map<String, Object> parmMap = new HashMap<>();

        // 构造过滤条件JPQL语句
        if (null != categoryId) {
            parmMap.put("category", jobCateRepo.getOne(categoryId));
            query.append("job.category = :category ")
                    .append("AND ");
        }

        if (null != wayToPay) {
            parmMap.put("timeToPlay", wayToPay);
            query.append("job.timeToPay = :timeToPay ")
                    .append("AND ");
        }

        if (null != schoolId) {
            parmMap.put("school", schoolRepo.getOne(schoolId));
            query.append("job.school = :school ").append("AND ");
        }

        // 去掉最后的"AND "
        if (false == parmMap.isEmpty()) {
            int len = query.length();
            String ql = query.substring(0, len - 4);
            query = new StringBuilder(ql);
        }
        // 去 WHERE
        if (true == parmMap.isEmpty()) {
            int len = query.length();
            String ql = query.substring(0, len - 6);
            query = new StringBuilder(ql);
        }

        // 设置排序信息

        if (orderByPageVisit) {
            query.append("ORDER BY ");
            query.append("job.pageView DESC ");
        }
        if (orderByDate) { // DESC
            query.append("ORDER BY ");
            query.append("job.postTime DESC ");
        }


        if (logger.isDebugEnabled()) {
            logger.debug("构造JPQL:{}", query.toString());
        }

        // 给参数赋值
        TypedQuery queryObj = em.createQuery(query.toString(), JobPostEntity.class);
        Set<Parameter<?>> parmSet = queryObj.getParameters();
        for ( Parameter parm : parmSet) {
            String parmName = parm.getName();
            Object parmValue = parmMap.get(parmName);

            queryObj.setParameter(parmName, parmValue);
        }

        // 执行查询
        List<JobPostEntity> entityList = queryObj.getResultList();
        return CollectionUtils.transformCollection(entityList, JobPostDto.class, (entity) -> {
            return CollectionUtils.entity2Dto(entity, JobPostDto.class, (dto) -> {
                dto.setMemberId(entity.getMember().getId());
                dto.setCategoryId(entity.getCategory().getId());
                dto.setCategoryName(entity.getCategory().getName());
            });
        });
    }

    @Override
    @Transactional(readOnly = true)
    public JobPostDto findJobPost(Integer postId) {
        JobPostEntity post = em.find(JobPostEntity.class, postId);
        return CollectionUtils.entity2Dto(post, JobPostDto.class, (dto) -> {
            dto.setCategoryName(post.getCategory().getName());
            dto.setCategoryId(post.getCategory().getId());
            dto.setMemberId(post.getMember().getId());
        });
    }

    @Override
    @Transactional(readOnly = false, propagation = Propagation.REQUIRES_NEW)
    public void postResume(Integer postId, Integer resumeId) {
        JobPostEntity post = postRepo.findOne(postId);

        // 记录收到的简历id
        // 在Member中记录这次投递
        String applicationIds = post.getApplicationResumeIds();
        String newIds = StringUtils.addToString(applicationIds, resumeId.toString());
        post.setApplicationResumeIds(newIds);



        // 增加申请者数量
        Integer original = post.getApplicantAmount();
        Integer newValue = original == null ? 1 : original.intValue() + 1;
        post.setApplicantAmount(newValue);

        // 在Member中记录这次投递
        ResumeEntity resumeEntity = resumeRepo.getOne(resumeId);
        MemberEntity mem = resumeEntity.getMember();
        String applicationJson = mem.getAppliedJobIds();

        Date now = new Date();
        JsonWrapper js = new JsonWrapper(applicationJson);
        js.addObjectToArray(Arrays.asList(
                new AbstractMap.SimpleEntry<String, String>(Constants.ApplicationRecord.KEY_ID, postId.toString()),
                new AbstractMap.SimpleEntry<String, String>(Constants.ApplicationRecord.KEY_TIME, Long.toString(now.getTime()))
        ));
        mem.setAppliedJobIds(js.getAjaxMessage(true));

/*        ResumeEntity resumeEntity = resumeRepo.getOne(resumeId);
        MemberEntity mem = resumeEntity.getMember();
        String originalIds = mem.getAppliedJobIds();
        newIds = StringUtils.addToString(originalIds, postId.toString());
        mem.setAppliedJobIds(newIds);*/
    }

    @Override
    @Transactional(readOnly = false, propagation = Propagation.REQUIRES_NEW)
    public void complaint(Integer postId) {
        JobPostEntity post = em.find(JobPostEntity.class, postId);
        Integer original = post.getComplaint();

        // 帖子本身投诉数+1
        Integer newValue = original == null ? 1 : original.intValue() + 1;
        post.setComplaint(newValue);

        // 对应用户投诉数+1
        original = post.getMember().getComplaint();
        newValue = original == null ? 1 : original.intValue() + 1;
        post.getMember().setComplaint(newValue);
    }

    @Override
    @Transactional(readOnly = false, propagation = Propagation.REQUIRES_NEW)
    public boolean updateJobPost(Integer postId, JobPostDto postDto) {
        JobPostEntity post = em.find(JobPostEntity.class, postId);
        CollectionUtils.updateEntity(post, postDto, null);
        //updateJobPost(post, postDto);

        return true;
    }

    @Override
    @Transactional(readOnly = false, propagation = Propagation.REQUIRES_NEW)
    public boolean deleteJobPost(Integer postId) {
        JobPostEntity post = em.find(JobPostEntity.class, postId);

        // 从member实体中删除关联
        CollectionUtils.removeFromCollection(post.getMember().getJobPostCollection(), (jobPost) -> {
            return jobPost.getId().equals(postId);
        });

        // 从分类实体中删除关联
        CollectionUtils.removeFromCollection(post.getCategory().getJobPostCollection(), (jobPost) -> {
            return jobPost.getId().equals(postId);
        });

        // 删除帖子的评论
        CollectionUtils.applyActionOnCollection(post.getReviewCollection(), (review) -> {
            reviewService.deleteReview(review.getId());
        });

        // 最后删除帖子本身
        em.remove(post);


        return true;
    }

    @Override
    @Transactional(readOnly = false, propagation = Propagation.REQUIRES_NEW)
    public void addJobPost(JobPostDto dto) {
        em.persist(makeJobPost(dto));
    }

    private JobPostEntity makeJobPost(JobPostDto dto) {
        JobPostEntity post = new JobPostEntity(dto.getTitle(), dto.getExpiredTime(), dto.getPostTime(),
                dto.getWorkPlace(), dto.getWage(), dto.getTimeToPay(), dto.getJobDescription(),
                dto.getContact(), dto.getContactPhone(), dto.getContactEmail(), dto.getContactQq(),
                dto.getJobDetail(), dto.getIntroduce(), dto.getLikes(), dto.getDislikes(), dto.getEducationLevel(),
                null, null);

        post.setCategory(em.getReference(JobPostCategoryEntity.class, dto.getCategoryId()));
        post.setMember(em.getReference(MemberEntity.class, dto.getMemberId()));

        return post;
    }
    /**
     * 不更新关联信息
     * @param post
     * @param dto
     */
    /*private void updateJobPost(JobPostEntity post, JobPostDto dto) {
        post.setTitle(dto.getTitle());
        post.setExpiredTime(dto.getExpiredTime());
        post.setPostTime(dto.getPostTime());
        post.setWorkPlace(dto.getWorkPlace());
        post.setWage(dto.getWage());
        post.setTimeToPay(dto.getTimeToPay());
        post.setContact(dto.getContact());
        post.setContactPhone(dto.getContactPhone());
        post.setContactQq(dto.getContactQq());
        post.setContactEmail(dto.getContactEmail());
        post.setJobDetail(dto.getJobDetail());
        post.setIntroduce(dto.getIntroduce());
        post.setLikes(dto.getLikes());
        post.setDislikes(dto.getDislikes());
        post.setEducationLevel(dto.getEducationLevel());
    }*/

   /* private JobPostDto makeJobPostDto(JobPostEntity post) {
        JobPostDto dto = new JobPostDto();
        dto.setId(post.getId());
        dto.setTitle(post.getTitle());
        dto.setExpiredTime(dto.getExpiredTime());
        dto.setPostTime(dto.getPostTime());
        dto.setWorkPlace(dto.getWorkPlace());
        dto.setWage(dto.getWage());
        dto.setTimeToPay(dto.getTimeToPay());
        dto.setContact(dto.getContact());
        dto.setContactPhone(dto.getContactPhone());
        dto.setContactQq(dto.getContactQq());
        dto.setContactEmail(dto.getContactEmail());
        dto.setJobDetail(dto.getJobDetail());
        dto.setIntroduce(dto.getIntroduce());
        dto.setLikes(dto.getLikes());
        dto.setDislikes(dto.getDislikes());
        dto.setEducationLevel(dto.getEducationLevel());

        dto.setMemberId(post.getMember().getId());
        dto.setCategoryName(post.getCategory().getName());
        dto.setCategoryId(post.getCategory().getId());


        return dto;
    }*/
}
