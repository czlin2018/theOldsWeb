package com.theoldsweb.myweb.common.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * @描述:
 * @版权: Copyright (c) 2016-2018
 * @公司: lumi
 * @作者: 泽林
 * @创建日期: 2018-10-30
 * @创建时间: 下午12:19
 */
@Data
public class AreaDto implements Serializable {

    private Integer id;

    private String tourAreaId;

    private String tourAreaName;

    private String tourCountryId;

    private String  createTime;

    private String updateTime;

}
