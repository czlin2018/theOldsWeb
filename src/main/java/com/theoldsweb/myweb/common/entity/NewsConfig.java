package com.theoldsweb.myweb.common.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Table(name = "news_config")
public class NewsConfig implements Serializable {
    private Integer id;

    @Column(name = "new_type_id")
    private String newTypeId;

    @Column(name = "new_type_name")
    private String newTypeName;

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
     * @return new_type_id
     */
    public String getNewTypeId() {
        return newTypeId;
    }

    /**
     * @param newTypeId
     */
    public void setNewTypeId(String newTypeId) {
        this.newTypeId = newTypeId;
    }

    /**
     * @return new_type_name
     */
    public String getNewTypeName() {
        return newTypeName;
    }

    /**
     * @param newTypeName
     */
    public void setNewTypeName(String newTypeName) {
        this.newTypeName = newTypeName;
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
        NewsConfig other = (NewsConfig) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getNewTypeId() == null ? other.getNewTypeId() == null : this.getNewTypeId().equals(other.getNewTypeId()))
            && (this.getNewTypeName() == null ? other.getNewTypeName() == null : this.getNewTypeName().equals(other.getNewTypeName()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getUpdateTime() == null ? other.getUpdateTime() == null : this.getUpdateTime().equals(other.getUpdateTime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getNewTypeId() == null) ? 0 : getNewTypeId().hashCode());
        result = prime * result + ((getNewTypeName() == null) ? 0 : getNewTypeName().hashCode());
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
        sb.append(", newTypeId=").append(newTypeId);
        sb.append(", newTypeName=").append(newTypeName);
        sb.append(", createTime=").append(createTime);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}