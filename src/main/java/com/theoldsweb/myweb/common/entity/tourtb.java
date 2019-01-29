package com.theoldsweb.myweb.common.entity;


import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Data
@Table(name = "tour_tb")
public class tourtb implements Serializable {
    private Integer id;

    @Id
    @Column(name = "tour_id")
    private String tourId;

    @Column(name = "tour_title")
    private String tourTitle;

    @Column(name = "tour_digest")
    private String tourDigest;

    @Column(name = "tour_main_body")
    private String tourMainBody;

    @Column(name = "tour_pic")
    private String tourPic;

    /**
     * 关联评论表,用评论表
     */
    @Column(name = "tour_comments_id")
    private String tourCommentsId;

    @Column(name = "tour_comments_num")
    private Integer tourCommentsNum;


    /**
     * 1国内 2国外
     */
    @Column(name = "tour_country_id")
    private Integer tourCountryId;

    @Column(name = "tour_area_id")
    private Integer tourAreaId;

    @Column(name = "tour_giveALike")
    private Integer tourGivealike;

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
     * @return tour_id
     */
    public String getTourId() {
        return tourId;
    }

    /**
     * @param tourId
     */
    public void setTourId(String tourId) {
        this.tourId = tourId;
    }

    /**
     * @return tour_title
     */
    public String getTourTitle() {
        return tourTitle;
    }

    /**
     * @param tourTitle
     */
    public void setTourTitle(String tourTitle) {
        this.tourTitle = tourTitle;
    }

    /**
     * @return tour_digest
     */
    public String getTourDigest() {
        return tourDigest;
    }

    /**
     * @param tourDigest
     */
    public void setTourDigest(String tourDigest) {
        this.tourDigest = tourDigest;
    }

    /**
     * @return tour_main_body
     */
    public String getTourMainBody() {
        return tourMainBody;
    }

    /**
     * @param tourMainBody
     */
    public void setTourMainBody(String tourMainBody) {
        this.tourMainBody = tourMainBody;
    }

    /**
     * @return tour_pic
     */
    public String getTourPic() {
        return tourPic;
    }

    /**
     * @param tourPic
     */
    public void setTourPic(String tourPic) {
        this.tourPic = tourPic;
    }

    /**
     * 获取关联评论表,用评论表,评论id1,2,3,4等分割
     *
     * @return tour_comments_id - 关联评论表,用评论表,评论id1,2,3,4等分割
     */
    public String getTourCommentsId() {
        return tourCommentsId;
    }

    /**
     * 设置关联评论表,用评论表,评论id1,2,3,4等分割
     *
     * @param tourCommentsId 关联评论表,用评论表,评论id1,2,3,4等分割
     */
    public void setTourCommentsId(String tourCommentsId) {
        this.tourCommentsId = tourCommentsId;
    }

    /**
     * 获取1国内 2国外
     *
     * @return tour_country_id - 1国内 2国外
     */
    public Integer getTourCountryId() {
        return tourCountryId;
    }

    /**
     * 设置1国内 2国外
     *
     * @param tourCountryId 1国内 2国外
     */
    public void setTourCountryId(Integer tourCountryId) {
        this.tourCountryId = tourCountryId;
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
     * @return tour_giveALike
     */
    public Integer getTourGivealike() {
        return tourGivealike;
    }

    /**
     * @param tourGivealike
     */
    public void setTourGivealike(Integer tourGivealike) {
        this.tourGivealike = tourGivealike;
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
     * @return udate_time
     */
    public Date getUdateTime() {
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
        tourtb other = (tourtb) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getTourId() == null ? other.getTourId() == null : this.getTourId().equals(other.getTourId()))
            && (this.getTourTitle() == null ? other.getTourTitle() == null : this.getTourTitle().equals(other.getTourTitle()))
            && (this.getTourDigest() == null ? other.getTourDigest() == null : this.getTourDigest().equals(other.getTourDigest()))
            && (this.getTourMainBody() == null ? other.getTourMainBody() == null : this.getTourMainBody().equals(other.getTourMainBody()))
            && (this.getTourPic() == null ? other.getTourPic() == null : this.getTourPic().equals(other.getTourPic()))
            && (this.getTourCommentsId() == null ? other.getTourCommentsId() == null : this.getTourCommentsId().equals(other.getTourCommentsId()))
            && (this.getTourCountryId() == null ? other.getTourCountryId() == null : this.getTourCountryId().equals(other.getTourCountryId()))
            && (this.getTourAreaId() == null ? other.getTourAreaId() == null : this.getTourAreaId().equals(other.getTourAreaId()))
            && (this.getTourGivealike() == null ? other.getTourGivealike() == null : this.getTourGivealike().equals(other.getTourGivealike()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getUdateTime() == null ? other.getUdateTime() == null : this.getUdateTime().equals(other.getUdateTime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getTourId() == null) ? 0 : getTourId().hashCode());
        result = prime * result + ((getTourTitle() == null) ? 0 : getTourTitle().hashCode());
        result = prime * result + ((getTourDigest() == null) ? 0 : getTourDigest().hashCode());
        result = prime * result + ((getTourMainBody() == null) ? 0 : getTourMainBody().hashCode());
        result = prime * result + ((getTourPic() == null) ? 0 : getTourPic().hashCode());
        result = prime * result + ((getTourCommentsId() == null) ? 0 : getTourCommentsId().hashCode());
        result = prime * result + ((getTourCountryId() == null) ? 0 : getTourCountryId().hashCode());
        result = prime * result + ((getTourAreaId() == null) ? 0 : getTourAreaId().hashCode());
        result = prime * result + ((getTourGivealike() == null) ? 0 : getTourGivealike().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getUdateTime() == null) ? 0 : getUdateTime().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", tourId=").append(tourId);
        sb.append(", tourTitle=").append(tourTitle);
        sb.append(", tourDigest=").append(tourDigest);
        sb.append(", tourMainBody=").append(tourMainBody);
        sb.append(", tourPic=").append(tourPic);
        sb.append(", tourCommentsId=").append(tourCommentsId);
        sb.append(", tourCountryId=").append(tourCountryId);
        sb.append(", tourAreaId=").append(tourAreaId);
        sb.append(", tourGivealike=").append(tourGivealike);
        sb.append(", createTime=").append(createTime);
        sb.append(", udateTime=").append(updateTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}