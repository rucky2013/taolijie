package com.fh.taolijie.dao.mapper;

import com.fh.taolijie.domain.CashAccModel;
import com.fh.taolijie.domain.CashAccModelExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CashAccModelMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cash_acc
     *
     * @mbggenerated
     */
    int countByExample(CashAccModelExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cash_acc
     *
     * @mbggenerated
     */
    int deleteByExample(CashAccModelExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cash_acc
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cash_acc
     *
     * @mbggenerated
     */
    int insert(CashAccModel record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cash_acc
     *
     * @mbggenerated
     */
    int insertSelective(CashAccModel record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cash_acc
     *
     * @mbggenerated
     */
    List<CashAccModel> selectByExample(CashAccModelExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cash_acc
     *
     * @mbggenerated
     */
    CashAccModel selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cash_acc
     *
     * @mbggenerated
     */
    int updateByExampleSelective(@Param("record") CashAccModel record, @Param("example") CashAccModelExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cash_acc
     *
     * @mbggenerated
     */
    int updateByExample(@Param("record") CashAccModel record, @Param("example") CashAccModelExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cash_acc
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(CashAccModel record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cash_acc
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(CashAccModel record);
}