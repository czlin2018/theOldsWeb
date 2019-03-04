package com.theoldsweb.myweb.common.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Table(name = "love_config")
public class LoveConfig implements Serializable {
    private Integer id;

    @Column(name = "love_type_id")
    private String loveTypeId;

    @Column(name = "love_type_name")
    private String loveTypeName;

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
     * @return love_type_id
     */
    public String getLoveTypeId() {
        return loveTypeId;
    }

    /**
     * @param loveTypeId
     */
    public void setLoveTypeId(String loveTypeId) {
        this.loveTypeId = loveTypeId;
    }

    /**
     * @return love_type_name
     */
    public String getLoveTypeName() {
        return loveTypeName;
    }

    /**
     * @param loveTypeName
     */
    public void setLoveTypeName(String loveTypeName) {
        this.loveTypeName = loveTypeName;
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
        LoveConfig other = (LoveConfig) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getLoveTypeId() == null ? other.getLoveTypeId() == null : this.getLoveTypeId().equals(other.getLoveTypeId()))
            && (this.getLoveTypeName() == null ? other.getLoveTypeName() == null : this.getLoveTypeName().equals(other.getLoveTypeName()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getUpdateTime() == null ? other.getUpdateTime() == null : this.getUpdateTime().equals(other.getUpdateTime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getLoveTypeId() == null) ? 0 : getLoveTypeId().hashCode());
        result = prime * result + ((getLoveTypeName() == null) ? 0 : getLoveTypeName().hashCode());
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
        sb.append(", loveTypeId=").append(loveTypeId);
        sb.append(", loveTypeName=").append(loveTypeName);
        sb.append(", createTime=").append(createTime);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}