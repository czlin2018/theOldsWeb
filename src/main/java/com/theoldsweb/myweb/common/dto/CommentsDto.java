package com.theoldsweb.myweb.common.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * @描述:
 * @版权: Copyright (c) 2016-2018
 * @公司: lumi
 * @作者: 泽林
 * @创建日期: 2018-10-30
 * @创建时间: 下午12:21
 */
@Data
public class CommentsDto implements Serializable {

    private Integer id;

    private String commentsId;

    private String comments;

    private String createTime;

    private String updateTime;

}
