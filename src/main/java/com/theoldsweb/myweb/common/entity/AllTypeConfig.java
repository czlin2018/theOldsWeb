package com.theoldsweb.myweb.common.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;
@Data
@Table(name = "all_type_config")
public class AllTypeConfig implements Serializable {
    private Integer id;

    @Column(name = "type_id")
    private String typeId;

    @Column(name = "type_name")
    private String typeName;

    /**
     * 1-旅游 2-新闻 3-观影 4附近定位 5-爱心社区 6-活动
     */
    @Column(name = "type_ower")
    private String typeOwer;

    @Column(name = "create_time")
    private Date createTime;

    @Column(name = "update_time")
    private Date updateTime;

}