package com.theoldsweb.myweb.common.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;
@Data
@Table(name = "activity")
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

}