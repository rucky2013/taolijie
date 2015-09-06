package com.fh.taolijie.domain;

import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

public class PrivateNotificationModel extends Pageable {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column notification.id
     *
     * @mbggenerated
     */
    private Integer id;

    /**
     * 通知发送者的id
     */
    @NotNull
    private Integer memberId;
    private MemberModel member;

    /**
     * 通知接收者的id
     */
    @NotNull
    private Integer toMemberId;

    /**
     * 通知标题
     */
    @NotNull
    private String title;

    private Boolean isRead;

    /**
     * 通知的类型
     */
    private String notiType;

    private Date time;

    private Integer postId;

    private String postType;

    /**
     *
     * @deprecated
     */
    private String accessRange;

    /**
     * 通知内容
     */
    private String content;

    // ******* 仅查询用 ***********
    private List<String> notiTypeList;

    public PrivateNotificationModel() {}
    public PrivateNotificationModel(int pageNumber, int pageSize) {
        super(pageNumber, pageSize);
    }

    public Integer getToMemberId() {
        return toMemberId;
    }

    public void setToMemberId(Integer toMemberId) {
        this.toMemberId = toMemberId;
    }

    public MemberModel getMember() {
        return member;
    }

    public void setMember(MemberModel member) {
        this.member = member;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getMemberId() {
        return memberId;
    }

    public void setMemberId(Integer memberId) {
        this.memberId = memberId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public List<String> getNotiTypeList() {
        return notiTypeList;
    }

    public void setNotiTypeList(List<String> notiTypeList) {
        this.notiTypeList = notiTypeList;
    }

    public Boolean isRead() {
        return isRead;
    }

    public void setIsRead(Boolean isRead) {
        this.isRead = isRead;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public String getNotiType() {
        return notiType;
    }

    public void setNotiType(String type) {
        this.notiType = type;
    }

    public String getAccessRange() {
        return accessRange;
    }

    public void setAccessRange(String accessRange) {
        this.accessRange = accessRange == null ? null : accessRange.trim();
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public Integer getPostId() {
        return postId;
    }

    public void setPostId(Integer postId) {
        this.postId = postId;
    }

    public String getPostType() {
        return postType;
    }

    public void setPostType(String postType) {
        this.postType = postType;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("PrivateNotificationModel{");
        sb.append("id=").append(id);
        sb.append(", memberId=").append(memberId);
        sb.append(", member=").append(member);
        sb.append(", toMemberId=").append(toMemberId);
        sb.append(", title='").append(title).append('\'');
        sb.append(", isRead=").append(isRead);
        sb.append(", notiType='").append(notiType).append('\'');
        sb.append(", time=").append(time);
        sb.append(", postId=").append(postId);
        sb.append(", postType='").append(postType).append('\'');
        sb.append(", accessRange='").append(accessRange).append('\'');
        sb.append(", content='").append(content).append('\'');
        sb.append(", notiTypeList=").append(notiTypeList);
        sb.append('}');
        return sb.toString();
    }
}