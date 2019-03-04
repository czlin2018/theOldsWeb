package com.theoldsweb.myweb.common.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;
@Data
@Table(name = "tour_config")
public class TourConfig implements Serializable {
    private Integer id;

    @Id
    @Column(name = "tour_area_id")
    private String tourAreaId;

    @Column(name = "tour_area_name")
    private String tourAreaName;


    @Column(name = "tour_country_id")
    private String tourCountryId;

    @Column(name = "create_time")
    private Date createTime;

    @Column(name = "update_time")
    private Date updateTime;


}