package com.fh.taolijie.domain.acc;

import com.fh.taolijie.domain.Pageable;

import java.math.BigDecimal;
import java.util.Date;

public class WithdrawApplyModel extends Pageable {
    private Integer id;

    private Integer memberId;
    private String username;

    private Date applyTime;

    private BigDecimal amount;

    private String status;

    private Date updateTime;

    private String alipayAcc;

    private String bankAcc;

    private String memo;

    private Integer accId;

    public WithdrawApplyModel() {}

    public WithdrawApplyModel(int pn, int ps) {
        super(pn, ps);
    }

    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column withdraw_apply.id
     *
     * @param id the value for withdraw_apply.id
     *
     * @mbggenerated
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column withdraw_apply.member_id
     *
     * @return the value of withdraw_apply.member_id
     *
     * @mbggenerated
     */
    public Integer getMemberId() {
        return memberId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column withdraw_apply.member_id
     *
     * @param memberId the value for withdraw_apply.member_id
     *
     * @mbggenerated
     */
    public void setMemberId(Integer memberId) {
        this.memberId = memberId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column withdraw_apply.username
     *
     * @return the value of withdraw_apply.username
     *
     * @mbggenerated
     */
    public String getUsername() {
        return username;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column withdraw_apply.username
     *
     * @param username the value for withdraw_apply.username
     *
     * @mbggenerated
     */
    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column withdraw_apply.apply_time
     *
     * @return the value of withdraw_apply.apply_time
     *
     * @mbggenerated
     */
    public Date getApplyTime() {
        return applyTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column withdraw_apply.apply_time
     *
     * @param applyTime the value for withdraw_apply.apply_time
     *
     * @mbggenerated
     */
    public void setApplyTime(Date applyTime) {
        this.applyTime = applyTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column withdraw_apply.amount
     *
     * @return the value of withdraw_apply.amount
     *
     * @mbggenerated
     */
    public BigDecimal getAmount() {
        return amount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column withdraw_apply.amount
     *
     * @param amount the value for withdraw_apply.amount
     *
     * @mbggenerated
     */
    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column withdraw_apply.status
     *
     * @return the value of withdraw_apply.status
     *
     * @mbggenerated
     */
    public String getStatus() {
        return status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column withdraw_apply.status
     *
     * @param status the value for withdraw_apply.status
     *
     * @mbggenerated
     */
    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column withdraw_apply.update_time
     *
     * @return the value of withdraw_apply.update_time
     *
     * @mbggenerated
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column withdraw_apply.update_time
     *
     * @param updateTime the value for withdraw_apply.update_time
     *
     * @mbggenerated
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column withdraw_apply.alipay_acc
     *
     * @return the value of withdraw_apply.alipay_acc
     *
     * @mbggenerated
     */
    public String getAlipayAcc() {
        return alipayAcc;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column withdraw_apply.alipay_acc
     *
     * @param alipayAcc the value for withdraw_apply.alipay_acc
     *
     * @mbggenerated
     */
    public void setAlipayAcc(String alipayAcc) {
        this.alipayAcc = alipayAcc == null ? null : alipayAcc.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column withdraw_apply.bank_acc
     *
     * @return the value of withdraw_apply.bank_acc
     *
     * @mbggenerated
     */
    public String getBankAcc() {
        return bankAcc;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column withdraw_apply.bank_acc
     *
     * @param bankAcc the value for withdraw_apply.bank_acc
     *
     * @mbggenerated
     */
    public void setBankAcc(String bankAcc) {
        this.bankAcc = bankAcc == null ? null : bankAcc.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column withdraw_apply.memo
     *
     * @return the value of withdraw_apply.memo
     *
     * @mbggenerated
     */
    public String getMemo() {
        return memo;
    }

    public Integer getAccId() {
        return accId;
    }

    public void setAccId(Integer accId) {
        this.accId = accId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column withdraw_apply.memo
     *
     * @param memo the value for withdraw_apply.memo
     *
     * @mbggenerated
     */
    public void setMemo(String memo) {
        this.memo = memo == null ? null : memo.trim();
    }
}