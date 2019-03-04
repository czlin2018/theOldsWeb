package com.theoldsweb.myweb.common.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

@Data
@Table(name = "comments_tb")
public class Commentstb implements Serializable {
    private Integer id;

    @Id
    @Column(name = "comments_id")
    private String commentsId;

    @Column(name = "comments")
    private String comments;

    @Column(name = "create_time")
    private Date createTime;

    @Column(name = "update_time")
    private Date updateTime;

}