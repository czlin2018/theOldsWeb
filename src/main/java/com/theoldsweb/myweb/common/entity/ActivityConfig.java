package com.theoldsweb.myweb.common.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Table(name = "activity_config")
public class ActivityConfig implements Serializable {
    private Integer id;

    @Column(name = "activity_type_id")
    private String activityTypeId;

    @Column(name = "activity_type_name")
    private String activityTypeName;

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
     * @return activity_type_id
     */
    public String getActivityTypeId() {
        return activityTypeId;
    }

    /**
     * @param activityTypeId
     */
    public void setActivityTypeId(String activityTypeId) {
        this.activityTypeId = activityTypeId;
    }

    /**
     * @return activity_type_name
     */
    public String getActivityTypeName() {
        return activityTypeName;
    }

    /**
     * @param activityTypeName
     */
    public void setActivityTypeName(String activityTypeName) {
        this.activityTypeName = activityTypeName;
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
        ActivityConfig other = (ActivityConfig) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getActivityTypeId() == null ? other.getActivityTypeId() == null : this.getActivityTypeId().equals(other.getActivityTypeId()))
            && (this.getActivityTypeName() == null ? other.getActivityTypeName() == null : this.getActivityTypeName().equals(other.getActivityTypeName()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getUpdateTime() == null ? other.getUpdateTime() == null : this.getUpdateTime().equals(other.getUpdateTime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getActivityTypeId() == null) ? 0 : getActivityTypeId().hashCode());
        result = prime * result + ((getActivityTypeName() == null) ? 0 : getActivityTypeName().hashCode());
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
        sb.append(", activityTypeId=").append(activityTypeId);
        sb.append(", activityTypeName=").append(activityTypeName);
        sb.append(", createTime=").append(createTime);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}