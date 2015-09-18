package com.fh.taolijie.domain;

import java.util.Date;

public class QuestAssignModel {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column quest_assign.id
     *
     * @mbggenerated
     */
    private Integer id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column quest_assign.member_id
     *
     * @mbggenerated
     */
    private Integer memberId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column quest_assign.username
     *
     * @mbggenerated
     */
    private String username;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column quest_assign.quest_id
     *
     * @mbggenerated
     */
    private Integer questId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column quest_assign.quest_title
     *
     * @mbggenerated
     */
    private String questTitle;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column quest_assign.assign_time
     *
     * @mbggenerated
     */
    private Date assignTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column quest_assign.status
     *
     * @mbggenerated
     */
    private String status;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column quest_assign.id
     *
     * @return the value of quest_assign.id
     *
     * @mbggenerated
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column quest_assign.id
     *
     * @param id the value for quest_assign.id
     *
     * @mbggenerated
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column quest_assign.member_id
     *
     * @return the value of quest_assign.member_id
     *
     * @mbggenerated
     */
    public Integer getMemberId() {
        return memberId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column quest_assign.member_id
     *
     * @param memberId the value for quest_assign.member_id
     *
     * @mbggenerated
     */
    public void setMemberId(Integer memberId) {
        this.memberId = memberId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column quest_assign.username
     *
     * @return the value of quest_assign.username
     *
     * @mbggenerated
     */
    public String getUsername() {
        return username;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column quest_assign.username
     *
     * @param username the value for quest_assign.username
     *
     * @mbggenerated
     */
    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column quest_assign.quest_id
     *
     * @return the value of quest_assign.quest_id
     *
     * @mbggenerated
     */
    public Integer getQuestId() {
        return questId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column quest_assign.quest_id
     *
     * @param questId the value for quest_assign.quest_id
     *
     * @mbggenerated
     */
    public void setQuestId(Integer questId) {
        this.questId = questId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column quest_assign.quest_title
     *
     * @return the value of quest_assign.quest_title
     *
     * @mbggenerated
     */
    public String getQuestTitle() {
        return questTitle;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column quest_assign.quest_title
     *
     * @param questTitle the value for quest_assign.quest_title
     *
     * @mbggenerated
     */
    public void setQuestTitle(String questTitle) {
        this.questTitle = questTitle == null ? null : questTitle.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column quest_assign.assign_time
     *
     * @return the value of quest_assign.assign_time
     *
     * @mbggenerated
     */
    public Date getAssignTime() {
        return assignTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column quest_assign.assign_time
     *
     * @param assignTime the value for quest_assign.assign_time
     *
     * @mbggenerated
     */
    public void setAssignTime(Date assignTime) {
        this.assignTime = assignTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column quest_assign.status
     *
     * @return the value of quest_assign.status
     *
     * @mbggenerated
     */
    public String getStatus() {
        return status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column quest_assign.status
     *
     * @param status the value for quest_assign.status
     *
     * @mbggenerated
     */
    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }
}