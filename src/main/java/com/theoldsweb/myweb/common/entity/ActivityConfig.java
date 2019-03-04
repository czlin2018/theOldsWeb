package com.theoldsweb.myweb.common.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Data
@Table(name = "activity_config")
public class ActivityConfig implements Serializable {
    private Integer id;

    @Column(name = "activity_type_id")
    private String activityTypeId;

    @Column(name = "activity_type_name")
    private String activityTypeName;

    @Column(name = "create_time")
    private Date createTime;

    @Column(name = "update_time")
    private Date updateTime;


}