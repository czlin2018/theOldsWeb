package com.theoldsweb.myweb.web.controller;

import com.theoldsweb.myweb.common.config.PageDto;
import com.theoldsweb.myweb.common.config.ResultDto;
import com.theoldsweb.myweb.common.dto.ActivityDto;
import com.theoldsweb.myweb.common.url.Url;
import com.theoldsweb.myweb.web.service.ActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @描述:
 * @版权: Copyright (c) 2016-2018
 * @公司: lumi
 * @作者: 泽林
 * @创建日期: 2019-06-05
 * @创建时间: 14:36
 */
@RestController
public class AcitivityController {
    @Autowired
    private ActivityService activityService;

    /**
     * 安心社区列表
     */
    @GetMapping(value = Url.activity.getList)
    public ResultDto getTourAll( PageDto pageDto , ActivityDto activityDto ){
        return activityService.getList ( pageDto , activityDto );
    }


    /**
     * 添加
     */
    @PostMapping(value = Url.activity.insert)
    public ResultDto insert( @RequestBody ActivityDto activityDto ){
        return activityService.insert ( activityDto );
    }
}
