package com.theoldsweb.myweb.web.controller;

import com.theoldsweb.myweb.common.config.PageDto;
import com.theoldsweb.myweb.common.config.ResultDto;
import com.theoldsweb.myweb.common.dto.LoveDto;
import com.theoldsweb.myweb.common.url.Url;
import com.theoldsweb.myweb.web.service.LoveService;
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
public class LoveController {
    @Autowired
    private LoveService loveService;

    /**
     * 安心社区列表
     */
    @GetMapping(value = Url.love.getList)
    public ResultDto getTourAll( PageDto pageDto , LoveDto loveDto ){
        return loveService.getList ( pageDto , loveDto );
    }


    /**
     * 添加
     */
    @PostMapping(value = Url.love.insert)
    public ResultDto insert( @RequestBody LoveDto loveDto ){
        return loveService.insert ( loveDto );
    }

    /**
     * 删除
     */
    @GetMapping(value = Url.love.del)
    public ResultDto del( String loveId ){
        return loveService.del ( loveId );
    }

    /**
     * 审核
     */
    @GetMapping(value = Url.love.update)
    public ResultDto update( String loveId ){
        return loveService.update ( loveId );
    }
}
