package com.fh.taolijie.domain;

import java.util.Date;

public class FinishRequestModel extends Pageable {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column finish_request.id
     *
     * @mbggenerated
     */
    private Integer id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column finish_request.quest_id
     *
     * @mbggenerated
     */
    private Integer questId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column finish_request.member_id
     *
     * @mbggenerated
     */
    private Integer memberId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column finish_request.username
     *
     * @mbggenerated
     */
    private String username;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column finish_request.created_time
     *
     * @mbggenerated
     */
    private Date createdTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column finish_request.audit_time
     *
     * @mbggenerated
     */
    private Date auditTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column finish_request.description
     *
     * @mbggenerated
     */
    private String description;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column finish_request.image_ids
     *
     * @mbggenerated
     */
    private String imageIds;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column finish_request.status
     *
     * @mbggenerated
     */
    private String status;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column finish_request.memo
     *
     * @mbggenerated
     */
    private String memo;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column finish_request.name
     *
     * @mbggenerated
     */
    private String name;

    public FinishRequestModel() {}

    public FinishRequestModel(int pn, int ps) {
        super(pn, ps);
    }

    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column finish_request.id
     *
     * @param id the value for finish_request.id
     *
     * @mbggenerated
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column finish_request.quest_id
     *
     * @return the value of finish_request.quest_id
     *
     * @mbggenerated
     */
    public Integer getQuestId() {
        return questId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column finish_request.quest_id
     *
     * @param questId the value for finish_request.quest_id
     *
     * @mbggenerated
     */
    public void setQuestId(Integer questId) {
        this.questId = questId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column finish_request.member_id
     *
     * @return the value of finish_request.member_id
     *
     * @mbggenerated
     */
    public Integer getMemberId() {
        return memberId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column finish_request.member_id
     *
     * @param memberId the value for finish_request.member_id
     *
     * @mbggenerated
     */
    public void setMemberId(Integer memberId) {
        this.memberId = memberId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column finish_request.username
     *
     * @return the value of finish_request.username
     *
     * @mbggenerated
     */
    public String getUsername() {
        return username;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column finish_request.username
     *
     * @param username the value for finish_request.username
     *
     * @mbggenerated
     */
    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column finish_request.created_time
     *
     * @return the value of finish_request.created_time
     *
     * @mbggenerated
     */
    public Date getCreatedTime() {
        return createdTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column finish_request.created_time
     *
     * @param createdTime the value for finish_request.created_time
     *
     * @mbggenerated
     */
    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column finish_request.audit_time
     *
     * @return the value of finish_request.audit_time
     *
     * @mbggenerated
     */
    public Date getAuditTime() {
        return auditTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column finish_request.audit_time
     *
     * @param auditTime the value for finish_request.audit_time
     *
     * @mbggenerated
     */
    public void setAuditTime(Date auditTime) {
        this.auditTime = auditTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column finish_request.description
     *
     * @return the value of finish_request.description
     *
     * @mbggenerated
     */
    public String getDescription() {
        return description;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column finish_request.description
     *
     * @param description the value for finish_request.description
     *
     * @mbggenerated
     */
    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column finish_request.image_ids
     *
     * @return the value of finish_request.image_ids
     *
     * @mbggenerated
     */
    public String getImageIds() {
        return imageIds;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column finish_request.image_ids
     *
     * @param imageIds the value for finish_request.image_ids
     *
     * @mbggenerated
     */
    public void setImageIds(String imageIds) {
        this.imageIds = imageIds == null ? null : imageIds.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column finish_request.status
     *
     * @return the value of finish_request.status
     *
     * @mbggenerated
     */
    public String getStatus() {
        return status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column finish_request.status
     *
     * @param status the value for finish_request.status
     *
     * @mbggenerated
     */
    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column finish_request.memo
     *
     * @return the value of finish_request.memo
     *
     * @mbggenerated
     */
    public String getMemo() {
        return memo;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column finish_request.memo
     *
     * @param memo the value for finish_request.memo
     *
     * @mbggenerated
     */
    public void setMemo(String memo) {
        this.memo = memo == null ? null : memo.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column finish_request.name
     *
     * @return the value of finish_request.name
     *
     * @mbggenerated
     */
    public String getName() {
        return name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column finish_request.name
     *
     * @param name the value for finish_request.name
     *
     * @mbggenerated
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }
}