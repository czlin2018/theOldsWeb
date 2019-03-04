package com.theoldsweb.myweb.common.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

public class Video implements Serializable {
    private Integer id;

    @Column(name = "video_id")
    private Integer videoId;

    @Column(name = "video_title")
    private String videoTitle;

    @Column(name = "video_ower")
    private String videoOwer;

    @Column(name = "comments_id")
    private String commentsId;

    @Column(name = "tour_giveALike")
    private Integer tourGivealike;

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
     * @return video_id
     */
    public Integer getVideoId() {
        return videoId;
    }

    /**
     * @param videoId
     */
    public void setVideoId(Integer videoId) {
        this.videoId = videoId;
    }

    /**
     * @return video_title
     */
    public String getVideoTitle() {
        return videoTitle;
    }

    /**
     * @param videoTitle
     */
    public void setVideoTitle(String videoTitle) {
        this.videoTitle = videoTitle;
    }

    /**
     * @return video_ower
     */
    public String getVideoOwer() {
        return videoOwer;
    }

    /**
     * @param videoOwer
     */
    public void setVideoOwer(String videoOwer) {
        this.videoOwer = videoOwer;
    }

    /**
     * @return comments_id
     */
    public String getCommentsId() {
        return commentsId;
    }

    /**
     * @param commentsId
     */
    public void setCommentsId(String commentsId) {
        this.commentsId = commentsId;
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
        Video other = (Video) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getVideoId() == null ? other.getVideoId() == null : this.getVideoId().equals(other.getVideoId()))
            && (this.getVideoTitle() == null ? other.getVideoTitle() == null : this.getVideoTitle().equals(other.getVideoTitle()))
            && (this.getVideoOwer() == null ? other.getVideoOwer() == null : this.getVideoOwer().equals(other.getVideoOwer()))
            && (this.getCommentsId() == null ? other.getCommentsId() == null : this.getCommentsId().equals(other.getCommentsId()))
            && (this.getTourGivealike() == null ? other.getTourGivealike() == null : this.getTourGivealike().equals(other.getTourGivealike()))
            && (this.getCreatTime() == null ? other.getCreatTime() == null : this.getCreatTime().equals(other.getCreatTime()))
            && (this.getUpdateTime() == null ? other.getUpdateTime() == null : this.getUpdateTime().equals(other.getUpdateTime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getVideoId() == null) ? 0 : getVideoId().hashCode());
        result = prime * result + ((getVideoTitle() == null) ? 0 : getVideoTitle().hashCode());
        result = prime * result + ((getVideoOwer() == null) ? 0 : getVideoOwer().hashCode());
        result = prime * result + ((getCommentsId() == null) ? 0 : getCommentsId().hashCode());
        result = prime * result + ((getTourGivealike() == null) ? 0 : getTourGivealike().hashCode());
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
        sb.append(", videoId=").append(videoId);
        sb.append(", videoTitle=").append(videoTitle);
        sb.append(", videoOwer=").append(videoOwer);
        sb.append(", commentsId=").append(commentsId);
        sb.append(", tourGivealike=").append(tourGivealike);
        sb.append(", creatTime=").append(creatTime);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}