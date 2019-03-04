package com.theoldsweb.myweb.web.controller;

import com.theoldsweb.myweb.common.config.PageDto;
import com.theoldsweb.myweb.common.config.ResultDto;
import com.theoldsweb.myweb.common.dto.TourtbDto;
import com.theoldsweb.myweb.common.url.Url;
import com.theoldsweb.myweb.web.service.TourService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @描述: 旅游tab页控制器
 * @版权: Copyright (c) 2016-2018
 * @公司: lumi
 * @作者: 泽林
 * @创建日期: 2018-10-30
 * @创建时间: 下午12:27r
 */
@RestController
public class tourController{

    @Autowired
    private TourService toutService;

    /**
     * 旅游列表
     */
    @GetMapping(value=Url.tour.getTourList)
    public ResultDto getTourAll ( PageDto pageDto ){
        return toutService.getTourAll(pageDto);
    }

    /**
     * 旅游添加
     */
    @PostMapping(value=Url.tour.insert)
    public ResultDto insert ( @RequestBody TourtbDto tourtbDto ){
        return toutService.insert(tourtbDto);
    }

    /**
     * 评论
     */
    @PostMapping(value = Url.tour.tourCommentsAdd)
    public ResultDto tourCommentsAdd( @RequestBody Map<String, String> praamMap ){
        return toutService.tourCommentsAdd ( praamMap );
    }


}
