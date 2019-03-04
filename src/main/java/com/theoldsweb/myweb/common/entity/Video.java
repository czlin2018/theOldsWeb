package com.theoldsweb.myweb.common.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;
@Data
@Table(name = "video")
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
}