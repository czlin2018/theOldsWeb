package com.theoldsweb.myweb.common.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;
@Data
@Table(name = "love_config")
public class LoveConfig implements Serializable {
    private Integer id;

    @Column(name = "love_type_id")
    private String loveTypeId;

    @Column(name = "love_type_name")
    private String loveTypeName;

    @Column(name = "create_time")
    private Date createTime;

    @Column(name = "update_time")
    private Date updateTime;
}