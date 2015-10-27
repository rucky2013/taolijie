package com.fh.taolijie.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.Date;

public class CouponModel extends Pageable {
    private Integer id;

    private String code;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createdTime;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date acquireTime;

    private Integer empId;

    private Integer memId;

    private String questTitle;

    private Integer questId;

    private String compName;

    private String title;

    private String description;


    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date expiredTime;

    private String logoPath;

    private Integer status;

    @JsonIgnore
    private Integer amt;

    public CouponModel(int pn, int ps) {
        super(pn, ps);
    }

    public CouponModel() {}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getAmt() {
        return amt;
    }

    public void setAmt(Integer amt) {
        this.amt = amt;
    }

    public String getCode() {
        return code;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column coupon.code
     *
     * @param code the value for coupon.code
     *
     * @mbggenerated
     */
    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }

    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column coupon.acquire_time
     *
     * @return the value of coupon.acquire_time
     *
     * @mbggenerated
     */
    public Date getAcquireTime() {
        return acquireTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column coupon.acquire_time
     *
     * @param acquireTime the value for coupon.acquire_time
     *
     * @mbggenerated
     */
    public void setAcquireTime(Date acquireTime) {
        this.acquireTime = acquireTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column coupon.emp_id
     *
     * @return the value of coupon.emp_id
     *
     * @mbggenerated
     */
    public Integer getEmpId() {
        return empId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column coupon.emp_id
     *
     * @param empId the value for coupon.emp_id
     *
     * @mbggenerated
     */
    public void setEmpId(Integer empId) {
        this.empId = empId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column coupon.mem_id
     *
     * @return the value of coupon.mem_id
     *
     * @mbggenerated
     */
    public Integer getMemId() {
        return memId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column coupon.mem_id
     *
     * @param memId the value for coupon.mem_id
     *
     * @mbggenerated
     */
    public void setMemId(Integer memId) {
        this.memId = memId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column coupon.quest_title
     *
     * @return the value of coupon.quest_title
     *
     * @mbggenerated
     */
    public String getQuestTitle() {
        return questTitle;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column coupon.quest_title
     *
     * @param questTitle the value for coupon.quest_title
     *
     * @mbggenerated
     */
    public void setQuestTitle(String questTitle) {
        this.questTitle = questTitle == null ? null : questTitle.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column coupon.quest_id
     *
     * @return the value of coupon.quest_id
     *
     * @mbggenerated
     */
    public Integer getQuestId() {
        return questId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column coupon.quest_id
     *
     * @param questId the value for coupon.quest_id
     *
     * @mbggenerated
     */
    public void setQuestId(Integer questId) {
        this.questId = questId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column coupon.comp_name
     *
     * @return the value of coupon.comp_name
     *
     * @mbggenerated
     */
    public String getCompName() {
        return compName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column coupon.comp_name
     *
     * @param compName the value for coupon.comp_name
     *
     * @mbggenerated
     */
    public void setCompName(String compName) {
        this.compName = compName == null ? null : compName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column coupon.title
     *
     * @return the value of coupon.title
     *
     * @mbggenerated
     */
    public String getTitle() {
        return title;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column coupon.title
     *
     * @param title the value for coupon.title
     *
     * @mbggenerated
     */
    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column coupon.description
     *
     * @return the value of coupon.description
     *
     * @mbggenerated
     */
    public String getDescription() {
        return description;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column coupon.description
     *
     * @param description the value for coupon.description
     *
     * @mbggenerated
     */
    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column coupon.expired_time
     *
     * @return the value of coupon.expired_time
     *
     * @mbggenerated
     */
    public Date getExpiredTime() {
        return expiredTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column coupon.expired_time
     *
     * @param expiredTime the value for coupon.expired_time
     *
     * @mbggenerated
     */
    public void setExpiredTime(Date expiredTime) {
        this.expiredTime = expiredTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column coupon.logo_path
     *
     * @return the value of coupon.logo_path
     *
     * @mbggenerated
     */
    public String getLogoPath() {
        return logoPath;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column coupon.logo_path
     *
     * @param logoPath the value for coupon.logo_path
     *
     * @mbggenerated
     */
    public void setLogoPath(String logoPath) {
        this.logoPath = logoPath == null ? null : logoPath.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column coupon.status
     *
     * @return the value of coupon.status
     *
     * @mbggenerated
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column coupon.status
     *
     * @param status the value for coupon.status
     *
     * @mbggenerated
     */
    public void setStatus(Integer status) {
        this.status = status;
    }
}