package com.theoldsweb.myweb.common.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;
@Data
@Table(name = "love")
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
}