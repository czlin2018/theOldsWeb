package com.theoldsweb.myweb.common.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Table(name = "video_config")
public class VideoConfig implements Serializable {
    private Integer id;

    @Column(name = "video_type_id")
    private String videoTypeId;

    @Column(name = "video_type_name")
    private String videoTypeName;

    private String type;

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
     * @return video_type_id
     */
    public String getVideoTypeId() {
        return videoTypeId;
    }

    /**
     * @param videoTypeId
     */
    public void setVideoTypeId(String videoTypeId) {
        this.videoTypeId = videoTypeId;
    }

    /**
     * @return video_type_name
     */
    public String getVideoTypeName() {
        return videoTypeName;
    }

    /**
     * @param videoTypeName
     */
    public void setVideoTypeName(String videoTypeName) {
        this.videoTypeName = videoTypeName;
    }

    /**
     * @return type
     */
    public String getType() {
        return type;
    }

    /**
     * @param type
     */
    public void setType(String type) {
        this.type = type;
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
        VideoConfig other = (VideoConfig) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getVideoTypeId() == null ? other.getVideoTypeId() == null : this.getVideoTypeId().equals(other.getVideoTypeId()))
            && (this.getVideoTypeName() == null ? other.getVideoTypeName() == null : this.getVideoTypeName().equals(other.getVideoTypeName()))
            && (this.getType() == null ? other.getType() == null : this.getType().equals(other.getType()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getUpdateTime() == null ? other.getUpdateTime() == null : this.getUpdateTime().equals(other.getUpdateTime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getVideoTypeId() == null) ? 0 : getVideoTypeId().hashCode());
        result = prime * result + ((getVideoTypeName() == null) ? 0 : getVideoTypeName().hashCode());
        result = prime * result + ((getType() == null) ? 0 : getType().hashCode());
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
        sb.append(", videoTypeId=").append(videoTypeId);
        sb.append(", videoTypeName=").append(videoTypeName);
        sb.append(", type=").append(type);
        sb.append(", createTime=").append(createTime);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}