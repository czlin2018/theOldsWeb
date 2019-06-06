package com.theoldsweb.myweb.common.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;
@Data
@Table(name = "video")
public class Video implements Serializable {
    private Integer id;

    @Column(name = "video_id")
    private String videoId;

    @Column(name = "video_title")
    private String videoTitle;

    @Column(name = "video_ower")
    private String videoOwer;

    @Column(name = "url")
    private String url;

    @Column(name = "`video_classification`")
    private String videoClassification;

    @Column(name = "`video_style`")
    private String videoStyle;


    @Column(name = "comments_id")
    private String commentsId;

    @Column(name = "video_giveALike")
    private Integer videoGiveALike;

    @Column(name = "creat_time")
    private Date creatTime;

    @Column(name = "update_time")
    private Date updateTime;
}