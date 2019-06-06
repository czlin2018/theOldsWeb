package com.theoldsweb.myweb.common.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;
@Data
@Table(name = "activity")
public class Activity implements Serializable {
    private Integer id;

    @Column(name = "activity_id")
    private String activityId;

    @Column(name = "activity_title")
    private String activityTitle;

    @Column(name = "activity_content")
    private String activityContent;

    @Column(name = "activity_time")
    private String activityTime;

    @Column(name = "activity_classification")
    private String activityClassification;

    @Column(name = "activity_style")
    private String activityStyle;


    @Column(name = "activity_address")
    private String activityAddress;

    @Column(name = "activity_ower")
    private String activityOwer;

    @Column(name = "activity_condition")
    private String activityCondition;

    @Column(name = "activity_phone")
    private String activityPhone;

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