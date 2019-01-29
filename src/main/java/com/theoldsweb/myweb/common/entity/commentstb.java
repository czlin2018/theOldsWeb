package com.theoldsweb.myweb.common.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Data
@Table(name = "comments_tb")
public class commentstb implements Serializable {
    private Integer id;

    @Id
    @Column(name = "tour_comments_id")
    private Integer tourCommentsId;

    @Column(name = "tour_comments")
    private String tourComments;

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
     * @return tour_comments_id
     */
    public Integer getTourCommentsId() {
        return tourCommentsId;
    }

    /**
     * @param tourCommentsId
     */
    public void setTourCommentsId(Integer tourCommentsId) {
        this.tourCommentsId = tourCommentsId;
    }

    /**
     * @return tour_comments
     */
    public String getTourComments() {
        return tourComments;
    }

    /**
     * @param tourComments
     */
    public void setTourComments(String tourComments) {
        this.tourComments = tourComments;
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
        commentstb other = (commentstb) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getTourCommentsId() == null ? other.getTourCommentsId() == null : this.getTourCommentsId().equals(other.getTourCommentsId()))
            && (this.getTourComments() == null ? other.getTourComments() == null : this.getTourComments().equals(other.getTourComments()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getTourCommentsId() == null) ? 0 : getTourCommentsId().hashCode());
        result = prime * result + ((getTourComments() == null) ? 0 : getTourComments().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", tourCommentsId=").append(tourCommentsId);
        sb.append(", tourComments=").append(tourComments);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}