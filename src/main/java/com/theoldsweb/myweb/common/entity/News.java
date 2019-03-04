package com.theoldsweb.myweb.common.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

public class News implements Serializable {
    private Integer id;

    /**
     * 新闻id
     */
    @Column(name = "new_id")
    private String newId;

    /**
     * 新闻标题
     */
    @Column(name = "new_title")
    private String newTitle;

    /**
     * 新闻摘要
     */
    @Column(name = "new_digest")
    private String newDigest;

    /**
     * 正文
     */
    @Column(name = "new_main_body")
    private String newMainBody;

    /**
     * 图片
     */
    @Column(name = "new_pic")
    private String newPic;

    /**
     * 关联评论表,用评论表
     */
    @Column(name = "comments_id")
    private String commentsId;

    /**
     * 新闻类型
     */
    @Column(name = "new_type")
    private Integer newType;

    /**
     * 点赞数
     */
    @Column(name = "new_giveALike")
    private Integer newGivealike;

    @Column(name = "create_time")
    private Date createTime;

    @Column(name = "update_time")
    private Date updateTime;

    private static final long serialVersionUID = 1L;

    /**
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取新闻id
     *
     * @return new_id - 新闻id
     */
    public String getNewId() {
        return newId;
    }

    /**
     * 设置新闻id
     *
     * @param newId 新闻id
     */
    public void setNewId(String newId) {
        this.newId = newId;
    }

    /**
     * 获取新闻标题
     *
     * @return new_title - 新闻标题
     */
    public String getNewTitle() {
        return newTitle;
    }

    /**
     * 设置新闻标题
     *
     * @param newTitle 新闻标题
     */
    public void setNewTitle(String newTitle) {
        this.newTitle = newTitle;
    }

    /**
     * 获取新闻摘要
     *
     * @return new_digest - 新闻摘要
     */
    public String getNewDigest() {
        return newDigest;
    }

    /**
     * 设置新闻摘要
     *
     * @param newDigest 新闻摘要
     */
    public void setNewDigest(String newDigest) {
        this.newDigest = newDigest;
    }

    /**
     * 获取正文
     *
     * @return new_main_body - 正文
     */
    public String getNewMainBody() {
        return newMainBody;
    }

    /**
     * 设置正文
     *
     * @param newMainBody 正文
     */
    public void setNewMainBody(String newMainBody) {
        this.newMainBody = newMainBody;
    }

    /**
     * 获取图片
     *
     * @return new_pic - 图片
     */
    public String getNewPic() {
        return newPic;
    }

    /**
     * 设置图片
     *
     * @param newPic 图片
     */
    public void setNewPic(String newPic) {
        this.newPic = newPic;
    }

    /**
     * 获取关联评论表,用评论表
     *
     * @return comments_id - 关联评论表,用评论表
     */
    public String getCommentsId() {
        return commentsId;
    }

    /**
     * 设置关联评论表,用评论表
     *
     * @param commentsId 关联评论表,用评论表
     */
    public void setCommentsId(String commentsId) {
        this.commentsId = commentsId;
    }

    /**
     * 获取新闻类型
     *
     * @return new_type - 新闻类型
     */
    public Integer getNewType() {
        return newType;
    }

    /**
     * 设置新闻类型
     *
     * @param newType 新闻类型
     */
    public void setNewType(Integer newType) {
        this.newType = newType;
    }

    /**
     * 获取点赞数
     *
     * @return new_giveALike - 点赞数
     */
    public Integer getNewGivealike() {
        return newGivealike;
    }

    /**
     * 设置点赞数
     *
     * @param newGivealike 点赞数
     */
    public void setNewGivealike(Integer newGivealike) {
        this.newGivealike = newGivealike;
    }

    /**
     * @return create_time
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * @param createTime
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * @return update_time
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * @param updateTime
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        News other = (News) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getNewId() == null ? other.getNewId() == null : this.getNewId().equals(other.getNewId()))
            && (this.getNewTitle() == null ? other.getNewTitle() == null : this.getNewTitle().equals(other.getNewTitle()))
            && (this.getNewDigest() == null ? other.getNewDigest() == null : this.getNewDigest().equals(other.getNewDigest()))
            && (this.getNewMainBody() == null ? other.getNewMainBody() == null : this.getNewMainBody().equals(other.getNewMainBody()))
            && (this.getNewPic() == null ? other.getNewPic() == null : this.getNewPic().equals(other.getNewPic()))
            && (this.getCommentsId() == null ? other.getCommentsId() == null : this.getCommentsId().equals(other.getCommentsId()))
            && (this.getNewType() == null ? other.getNewType() == null : this.getNewType().equals(other.getNewType()))
            && (this.getNewGivealike() == null ? other.getNewGivealike() == null : this.getNewGivealike().equals(other.getNewGivealike()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getUpdateTime() == null ? other.getUpdateTime() == null : this.getUpdateTime().equals(other.getUpdateTime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getNewId() == null) ? 0 : getNewId().hashCode());
        result = prime * result + ((getNewTitle() == null) ? 0 : getNewTitle().hashCode());
        result = prime * result + ((getNewDigest() == null) ? 0 : getNewDigest().hashCode());
        result = prime * result + ((getNewMainBody() == null) ? 0 : getNewMainBody().hashCode());
        result = prime * result + ((getNewPic() == null) ? 0 : getNewPic().hashCode());
        result = prime * result + ((getCommentsId() == null) ? 0 : getCommentsId().hashCode());
        result = prime * result + ((getNewType() == null) ? 0 : getNewType().hashCode());
        result = prime * result + ((getNewGivealike() == null) ? 0 : getNewGivealike().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getUpdateTime() == null) ? 0 : getUpdateTime().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", newId=").append(newId);
        sb.append(", newTitle=").append(newTitle);
        sb.append(", newDigest=").append(newDigest);
        sb.append(", newMainBody=").append(newMainBody);
        sb.append(", newPic=").append(newPic);
        sb.append(", commentsId=").append(commentsId);
        sb.append(", newType=").append(newType);
        sb.append(", newGivealike=").append(newGivealike);
        sb.append(", createTime=").append(createTime);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}