package com.theoldsweb.myweb.common.entity;


import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

@Data
@Table(name = "tour_tb")
public class Tourtb implements Serializable {
    private Integer id;

    @Id
    @Column(name = "tour_id")
    private String tourId;

    @Column(name = "tour_title")
    private String tourTitle;

    @Column(name = "tour_digest")
    private String tourDigest;

    @Column(name = "tour_main_body")
    private String tourMainBody;

    @Column(name = "tour_pic")
    private String tourPic;

    @Column(name = "tour_contry_id")
    private Integer tourCountryId;

    /**
     * 关联评论表,用评论表
     */
    @Column(name = "comments_id")
    private String commentsId = "";

    @Column(name = "tour_area_id")
    private Integer tourAreaId;

    @Column(name = "tour_giveALike")
    private Integer tourGivealike;

    @Column(name = "create_time")
    private Date createTime;

    @Column(name = "update_time")
    private Date updateTime;

}