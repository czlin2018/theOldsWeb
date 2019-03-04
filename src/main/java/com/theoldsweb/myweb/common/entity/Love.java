package com.theoldsweb.myweb.common.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

public class Love implements Serializable {
    private Integer id;

    @Column(name = "love_id")
    private Integer loveId;

    @Column(name = "love_title")
    private String loveTitle;

    @Column(name = "love_content")
    private String loveContent;

    @Column(name = "love_time")
    private Date loveTime;

    @Column(name = "love_address")
    private String loveAddress;

    @Column(name = "love_ower")
    private String loveOwer;

    @Column(name = "love_condition")
    private String loveCondition;

    @Column(name = "love_phone")
    private Integer lovePhone;

    @Column(name = "love_number_of_people")
    private Integer loveNumberOfPeople;

    @Column(name = "love_has_people")
    private String loveHasPeople;

    private Integer lovestatus;

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
     * @return love_id
     */
    public Integer getLoveId() {
        return loveId;
    }

    /**
     * @param loveId
     */
    public void setLoveId(Integer loveId) {
        this.loveId = loveId;
    }

    /**
     * @return love_title
     */
    public String getLoveTitle() {
        return loveTitle;
    }

    /**
     * @param loveTitle
     */
    public void setLoveTitle(String loveTitle) {
        this.loveTitle = loveTitle;
    }

    /**
     * @return love_content
     */
    public String getLoveContent() {
        return loveContent;
    }

    /**
     * @param loveContent
     */
    public void setLoveContent(String loveContent) {
        this.loveContent = loveContent;
    }

    /**
     * @return love_time
     */
    public Date getLoveTime() {
        return loveTime;
    }

    /**
     * @param loveTime
     */
    public void setLoveTime(Date loveTime) {
        this.loveTime = loveTime;
    }

    /**
     * @return love_address
     */
    public String getLoveAddress() {
        return loveAddress;
    }

    /**
     * @param loveAddress
     */
    public void setLoveAddress(String loveAddress) {
        this.loveAddress = loveAddress;
    }

    /**
     * @return love_ower
     */
    public String getLoveOwer() {
        return loveOwer;
    }

    /**
     * @param loveOwer
     */
    public void setLoveOwer(String loveOwer) {
        this.loveOwer = loveOwer;
    }

    /**
     * @return love_condition
     */
    public String getLoveCondition() {
        return loveCondition;
    }

    /**
     * @param loveCondition
     */
    public void setLoveCondition(String loveCondition) {
        this.loveCondition = loveCondition;
    }

    /**
     * @return love_phone
     */
    public Integer getLovePhone() {
        return lovePhone;
    }

    /**
     * @param lovePhone
     */
    public void setLovePhone(Integer lovePhone) {
        this.lovePhone = lovePhone;
    }

    /**
     * @return love_number_of_people
     */
    public Integer getLoveNumberOfPeople() {
        return loveNumberOfPeople;
    }

    /**
     * @param loveNumberOfPeople
     */
    public void setLoveNumberOfPeople(Integer loveNumberOfPeople) {
        this.loveNumberOfPeople = loveNumberOfPeople;
    }

    /**
     * @return love_has_people
     */
    public String getLoveHasPeople() {
        return loveHasPeople;
    }

    /**
     * @param loveHasPeople
     */
    public void setLoveHasPeople(String loveHasPeople) {
        this.loveHasPeople = loveHasPeople;
    }

    /**
     * @return lovestatus
     */
    public Integer getLovestatus() {
        return lovestatus;
    }

    /**
     * @param lovestatus
     */
    public void setLovestatus(Integer lovestatus) {
        this.lovestatus = lovestatus;
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
        Love other = (Love) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getLoveId() == null ? other.getLoveId() == null : this.getLoveId().equals(other.getLoveId()))
            && (this.getLoveTitle() == null ? other.getLoveTitle() == null : this.getLoveTitle().equals(other.getLoveTitle()))
            && (this.getLoveContent() == null ? other.getLoveContent() == null : this.getLoveContent().equals(other.getLoveContent()))
            && (this.getLoveTime() == null ? other.getLoveTime() == null : this.getLoveTime().equals(other.getLoveTime()))
            && (this.getLoveAddress() == null ? other.getLoveAddress() == null : this.getLoveAddress().equals(other.getLoveAddress()))
            && (this.getLoveOwer() == null ? other.getLoveOwer() == null : this.getLoveOwer().equals(other.getLoveOwer()))
            && (this.getLoveCondition() == null ? other.getLoveCondition() == null : this.getLoveCondition().equals(other.getLoveCondition()))
            && (this.getLovePhone() == null ? other.getLovePhone() == null : this.getLovePhone().equals(other.getLovePhone()))
            && (this.getLoveNumberOfPeople() == null ? other.getLoveNumberOfPeople() == null : this.getLoveNumberOfPeople().equals(other.getLoveNumberOfPeople()))
            && (this.getLoveHasPeople() == null ? other.getLoveHasPeople() == null : this.getLoveHasPeople().equals(other.getLoveHasPeople()))
            && (this.getLovestatus() == null ? other.getLovestatus() == null : this.getLovestatus().equals(other.getLovestatus()))
            && (this.getCreatTime() == null ? other.getCreatTime() == null : this.getCreatTime().equals(other.getCreatTime()))
            && (this.getUpdateTime() == null ? other.getUpdateTime() == null : this.getUpdateTime().equals(other.getUpdateTime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getLoveId() == null) ? 0 : getLoveId().hashCode());
        result = prime * result + ((getLoveTitle() == null) ? 0 : getLoveTitle().hashCode());
        result = prime * result + ((getLoveContent() == null) ? 0 : getLoveContent().hashCode());
        result = prime * result + ((getLoveTime() == null) ? 0 : getLoveTime().hashCode());
        result = prime * result + ((getLoveAddress() == null) ? 0 : getLoveAddress().hashCode());
        result = prime * result + ((getLoveOwer() == null) ? 0 : getLoveOwer().hashCode());
        result = prime * result + ((getLoveCondition() == null) ? 0 : getLoveCondition().hashCode());
        result = prime * result + ((getLovePhone() == null) ? 0 : getLovePhone().hashCode());
        result = prime * result + ((getLoveNumberOfPeople() == null) ? 0 : getLoveNumberOfPeople().hashCode());
        result = prime * result + ((getLoveHasPeople() == null) ? 0 : getLoveHasPeople().hashCode());
        result = prime * result + ((getLovestatus() == null) ? 0 : getLovestatus().hashCode());
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
        sb.append(", loveId=").append(loveId);
        sb.append(", loveTitle=").append(loveTitle);
        sb.append(", loveContent=").append(loveContent);
        sb.append(", loveTime=").append(loveTime);
        sb.append(", loveAddress=").append(loveAddress);
        sb.append(", loveOwer=").append(loveOwer);
        sb.append(", loveCondition=").append(loveCondition);
        sb.append(", lovePhone=").append(lovePhone);
        sb.append(", loveNumberOfPeople=").append(loveNumberOfPeople);
        sb.append(", loveHasPeople=").append(loveHasPeople);
        sb.append(", lovestatus=").append(lovestatus);
        sb.append(", creatTime=").append(creatTime);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}