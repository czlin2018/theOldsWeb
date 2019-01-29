package com.theoldsweb.myweb.common.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;
@Data
@Table(name = "area_tb")
public class areatb implements Serializable {
    private Integer id;

    @Id
    @Column(name = "tour_area_id")
    private Integer tourAreaId;

    @Column(name = "tour_area_name")
    private String tourAreaName;


    @Column(name = "tour_country_id")
    private Integer tour_country_id;

    @Column(name = "create_time")
    private Date createTime;

    @Column(name = "update_time")
    private Date updateTime;


    public Integer getTour_country_id( ){
        return tour_country_id;
    }

    public void setTour_country_id( Integer tour_country_id ){
        this.tour_country_id=tour_country_id;
    }

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
     * @return tour_area_id
     */
    public Integer getTourAreaId() {
        return tourAreaId;
    }

    /**
     * @param tourAreaId
     */
    public void setTourAreaId(Integer tourAreaId) {
        this.tourAreaId = tourAreaId;
    }

    /**
     * @return tour_area_name
     */
    public String getTourAreaName() {
        return tourAreaName;
    }

    /**
     * @param tourAreaName
     */
    public void setTourAreaName(String tourAreaName) {
        this.tourAreaName = tourAreaName;
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
        areatb other = (areatb) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getTourAreaId() == null ? other.getTourAreaId() == null : this.getTourAreaId().equals(other.getTourAreaId()))
            && (this.getTourAreaName() == null ? other.getTourAreaName() == null : this.getTourAreaName().equals(other.getTourAreaName()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getTourAreaId() == null) ? 0 : getTourAreaId().hashCode());
        result = prime * result + ((getTourAreaName() == null) ? 0 : getTourAreaName().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", tourAreaId=").append(tourAreaId);
        sb.append(", tourAreaName=").append(tourAreaName);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}