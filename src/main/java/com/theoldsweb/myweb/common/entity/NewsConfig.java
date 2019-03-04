package com.theoldsweb.myweb.common.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Data
@Table(name = "news_config")
public class NewsConfig implements Serializable {
    private Integer id;

    @Column(name = "new_type_id")
    private String newTypeId;

    @Column(name = "new_type_name")
    private String newTypeName;

    @Column(name = "create_time")
    private Date createTime;

    @Column(name = "update_time")
    private Date updateTime;

}