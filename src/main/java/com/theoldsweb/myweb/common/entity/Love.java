package com.theoldsweb.myweb.common.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;
@Data
@Table(name = "love")
public class Love implements Serializable {
    private Integer id;

    @Column(name = "love_id")
    private String loveId;

    @Column(name = "love_title")
    private String loveTitle;

    @Column(name = "love_content")
    private String loveContent;

    @Column(name = "love_classification")
    private String loveClassification;

    @Column(name = "love_style")
    private String loveStyle;

    @Column(name = "love_time")
    private String loveTime;

    @Column(name = "love_address")
    private String loveAddress;

    @Column(name = "love_ower")
    private String loveOwer;

    @Column(name = "love_condition")
    private String loveCondition;

    @Column(name = "love_phone")
    private String lovePhone;


    @Column(name = "love_pic")
    private String lovePic;

    private Integer lovestatus;

    @Column(name = "creat_time")
    private Date creatTime;

    @Column(name = "update_time")
    private Date updateTime;
}