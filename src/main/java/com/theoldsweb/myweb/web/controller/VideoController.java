package com.theoldsweb.myweb.web.controller;

import com.theoldsweb.myweb.common.config.PageDto;
import com.theoldsweb.myweb.common.config.ResultDto;
import com.theoldsweb.myweb.common.dto.VideoDto;
import com.theoldsweb.myweb.common.url.Url;
import com.theoldsweb.myweb.web.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @描述:
 * @版权: Copyright (c) 2016-2018
 * @公司: lumi
 * @作者: 泽林
 * @创建日期: 2019-06-05
 * @创建时间: 14:36
 */
@RestController
public class VideoController {
    @Autowired
    private VideoService videoService;

    /**
     * 视频
     */
    @GetMapping(value = Url.video.getList)
    public ResultDto getTourAll( PageDto pageDto , VideoDto videoDto ){
        return videoService.getList ( pageDto , videoDto );
    }


    /**
     * 添加
     */
    @PostMapping(value = Url.video.insert)
    public ResultDto insert( @RequestBody VideoDto videoDto ){
        return videoService.insert ( videoDto );
    }

    /**
     * 评论
     */
    @PostMapping(value = Url.video.videoCommentsAdd)
    public ResultDto newsCommentsAdd( @RequestBody Map<String, String> praamMap ){
        return videoService.videoCommentsAdd ( praamMap );
    }
}
