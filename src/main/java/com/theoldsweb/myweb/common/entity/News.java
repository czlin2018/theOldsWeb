package com.theoldsweb.myweb.common.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

@Data
@Table(name = "news")
public class News implements Serializable {
    private Integer id;

    /**
     * 新闻id
     */
    @Column(name = "new_id")
    private String newId;

    /**
     * 新闻标题
     */
    @Column(name = "new_title")
    private String newTitle;

    /**
     * 新闻摘要
     */
    @Column(name = "new_digest")
    private String newDigest;

    /**
     * 正文
     */
    @Column(name = "new_main_body")
    private String newMainBody;

    /**
     * 图片
     */
    @Column(name = "new_pic")
    private String newPic;

    /**
     * 关联评论表,用评论表
     */
    @Column(name = "comments_id")
    private String commentsId = "";

    /**
     * 新闻类型
     */
    @Column(name = "new_type")
    private Integer newType;

    /**
     * 点赞数
     */
    @Column(name = "new_giveALike")
    private Integer newGivealike;

    @Column(name = "create_time")
    private Date createTime;

    @Column(name = "update_time")
    private Date updateTime;
}