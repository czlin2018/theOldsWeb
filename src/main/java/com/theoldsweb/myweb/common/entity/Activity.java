package com.theoldsweb.myweb.common.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

public class Activity implements Serializable {
    private Integer id;

    @Column(name = "activity_id")
    private Integer activityId;

    @Column(name = "activity_title")
    private String activityTitle;

    @Column(name = "activity_content")
    private String activityContent;

    @Column(name = "activity_time")
    private Date activityTime;

    @Column(name = "activity_address")
    private String activityAddress;

    @Column(name = "activity_ower")
    private String activityOwer;

    @Column(name = "activity_condition")
    private String activityCondition;

    @Column(name = "activity_phone")
    private Integer activityPhone;

    @Column(name = "activity_number_of_people")
    private Integer activityNumberOfPeople;

    @Column(name = "activity_has_people")
    private String activityHasPeople;

    @Column(name = "activity_status")
    private Integer activityStatus;

    @Column(name = "creat_time")
    private Date creatTime;

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
     * @return activity_id
     */
    public Integer getActivityId() {
        return activityId;
    }

    /**
     * @param activityId
     */
    public void setActivityId(Integer activityId) {
        this.activityId = activityId;
    }

    /**
     * @return activity_title
     */
    public String getActivityTitle() {
        return activityTitle;
    }

    /**
     * @param activityTitle
     */
    public void setActivityTitle(String activityTitle) {
        this.activityTitle = activityTitle;
    }

    /**
     * @return activity_content
     */
    public String getActivityContent() {
        return activityContent;
    }

    /**
     * @param activityContent
     */
    public void setActivityContent(String activityContent) {
        this.activityContent = activityContent;
    }

    /**
     * @return activity_time
     */
    public Date getActivityTime() {
        return activityTime;
    }

    /**
     * @param activityTime
     */
    public void setActivityTime(Date activityTime) {
        this.activityTime = activityTime;
    }

    /**
     * @return activity_address
     */
    public String getActivityAddress() {
        return activityAddress;
    }

    /**
     * @param activityAddress
     */
    public void setActivityAddress(String activityAddress) {
        this.activityAddress = activityAddress;
    }

    /**
     * @return activity_ower
     */
    public String getActivityOwer() {
        return activityOwer;
    }

    /**
     * @param activityOwer
     */
    public void setActivityOwer(String activityOwer) {
        this.activityOwer = activityOwer;
    }

    /**
     * @return activity_condition
     */
    public String getActivityCondition() {
        return activityCondition;
    }

    /**
     * @param activityCondition
     */
    public void setActivityCondition(String activityCondition) {
        this.activityCondition = activityCondition;
    }

    /**
     * @return activity_phone
     */
    public Integer getActivityPhone() {
        return activityPhone;
    }

    /**
     * @param activityPhone
     */
    public void setActivityPhone(Integer activityPhone) {
        this.activityPhone = activityPhone;
    }

    /**
     * @return activity_number_of_people
     */
    public Integer getActivityNumberOfPeople() {
        return activityNumberOfPeople;
    }

    /**
     * @param activityNumberOfPeople
     */
    public void setActivityNumberOfPeople(Integer activityNumberOfPeople) {
        this.activityNumberOfPeople = activityNumberOfPeople;
    }

    /**
     * @return activity_has_people
     */
    public String getActivityHasPeople() {
        return activityHasPeople;
    }

    /**
     * @param activityHasPeople
     */
    public void setActivityHasPeople(String activityHasPeople) {
        this.activityHasPeople = activityHasPeople;
    }

    /**
     * @return activity_status
     */
    public Integer getActivityStatus() {
        return activityStatus;
    }

    /**
     * @param activityStatus
     */
    public void setActivityStatus(Integer activityStatus) {
        this.activityStatus = activityStatus;
    }

    /**
     * @return creat_time
     */
    public Date getCreatTime() {
        return creatTime;
    }

    /**
     * @param creatTime
     */
    public void setCreatTime(Date creatTime) {
        this.creatTime = creatTime;
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
        Activity other = (Activity) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getActivityId() == null ? other.getActivityId() == null : this.getActivityId().equals(other.getActivityId()))
            && (this.getActivityTitle() == null ? other.getActivityTitle() == null : this.getActivityTitle().equals(other.getActivityTitle()))
            && (this.getActivityContent() == null ? other.getActivityContent() == null : this.getActivityContent().equals(other.getActivityContent()))
            && (this.getActivityTime() == null ? other.getActivityTime() == null : this.getActivityTime().equals(other.getActivityTime()))
            && (this.getActivityAddress() == null ? other.getActivityAddress() == null : this.getActivityAddress().equals(other.getActivityAddress()))
            && (this.getActivityOwer() == null ? other.getActivityOwer() == null : this.getActivityOwer().equals(other.getActivityOwer()))
            && (this.getActivityCondition() == null ? other.getActivityCondition() == null : this.getActivityCondition().equals(other.getActivityCondition()))
            && (this.getActivityPhone() == null ? other.getActivityPhone() == null : this.getActivityPhone().equals(other.getActivityPhone()))
            && (this.getActivityNumberOfPeople() == null ? other.getActivityNumberOfPeople() == null : this.getActivityNumberOfPeople().equals(other.getActivityNumberOfPeople()))
            && (this.getActivityHasPeople() == null ? other.getActivityHasPeople() == null : this.getActivityHasPeople().equals(other.getActivityHasPeople()))
            && (this.getActivityStatus() == null ? other.getActivityStatus() == null : this.getActivityStatus().equals(other.getActivityStatus()))
            && (this.getCreatTime() == null ? other.getCreatTime() == null : this.getCreatTime().equals(other.getCreatTime()))
            && (this.getUpdateTime() == null ? other.getUpdateTime() == null : this.getUpdateTime().equals(other.getUpdateTime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getActivityId() == null) ? 0 : getActivityId().hashCode());
        result = prime * result + ((getActivityTitle() == null) ? 0 : getActivityTitle().hashCode());
        result = prime * result + ((getActivityContent() == null) ? 0 : getActivityContent().hashCode());
        result = prime * result + ((getActivityTime() == null) ? 0 : getActivityTime().hashCode());
        result = prime * result + ((getActivityAddress() == null) ? 0 : getActivityAddress().hashCode());
        result = prime * result + ((getActivityOwer() == null) ? 0 : getActivityOwer().hashCode());
        result = prime * result + ((getActivityCondition() == null) ? 0 : getActivityCondition().hashCode());
        result = prime * result + ((getActivityPhone() == null) ? 0 : getActivityPhone().hashCode());
        result = prime * result + ((getActivityNumberOfPeople() == null) ? 0 : getActivityNumberOfPeople().hashCode());
        result = prime * result + ((getActivityHasPeople() == null) ? 0 : getActivityHasPeople().hashCode());
        result = prime * result + ((getActivityStatus() == null) ? 0 : getActivityStatus().hashCode());
        result = prime * result + ((getCreatTime() == null) ? 0 : getCreatTime().hashCode());
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
        sb.append(", activityId=").append(activityId);
        sb.append(", activityTitle=").append(activityTitle);
        sb.append(", activityContent=").append(activityContent);
        sb.append(", activityTime=").append(activityTime);
        sb.append(", activityAddress=").append(activityAddress);
        sb.append(", activityOwer=").append(activityOwer);
        sb.append(", activityCondition=").append(activityCondition);
        sb.append(", activityPhone=").append(activityPhone);
        sb.append(", activityNumberOfPeople=").append(activityNumberOfPeople);
        sb.append(", activityHasPeople=").append(activityHasPeople);
        sb.append(", activityStatus=").append(activityStatus);
        sb.append(", creatTime=").append(creatTime);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}