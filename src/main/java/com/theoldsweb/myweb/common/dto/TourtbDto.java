package com.theoldsweb.myweb.common.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @描述:
 * @版权: Copyright (c) 2016-2018
 * @公司: lumi
 * @作者: 泽林
 * @创建日期: 2018-10-30
 * @创建时间: 下午12:21
 */
@Data
public class TourtbDto  implements Serializable {

    private Integer selectType;

    private String tourId;

    private String tourTitle;

    private String tourDigest;

    private String tourMainBody;

    private String tourPic;

    /**
     * 关联评论表,用评论表,评论id
     */
    private String CommentsId;

    /**
     * 评价数量
     */
    private Integer commentsNum;

    /**
     * 评价内容
     */
    private List comments;

    /**
     * 国内 国外
     */
    private Integer tourCountryId;

    private String tourCountryName;

    private Integer tourAreaId;

    private String tourAreaName;

    private Integer tourGivealike;

    private String  createTime;

    private String  updateTime;
}
