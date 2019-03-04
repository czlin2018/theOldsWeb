package com.theoldsweb.myweb.common.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Data
@Table(name = "video_config")
public class VideoConfig implements Serializable{
    private Integer id;

    @Column(name = "video_type_id")
    private String videoTypeId;

    @Column(name = "video_type_name")
    private String videoTypeName;

    private String type;

    @Column(name = "create_time")
    private Date createTime;

    @Column(name = "update_time")
    private Date updateTime;
}