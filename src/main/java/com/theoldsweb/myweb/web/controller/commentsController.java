package com.theoldsweb.myweb.web.controller;

import com.theoldsweb.myweb.common.config.PageDto;
import com.theoldsweb.myweb.common.config.ResultDto;
import com.theoldsweb.myweb.common.dto.commentsDto;
import com.theoldsweb.myweb.common.url.Url;
import com.theoldsweb.myweb.web.service.commentsService;
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
 * @创建日期: 2018-11-01
 * @创建时间: 下午12:20
 */
@RestController
public class commentsController {
    @Autowired
    private commentsService commentsService;
    /**
     * 查询
     */
    @GetMapping(Url.comments.getCommentsList)
    public ResultDto getCommentsList  ( PageDto pageDto ){
        return commentsService.getList(pageDto);
    }
    /**
     * 新增
     */
    @PostMapping(Url.comments.insert)
    public ResultDto insert  ( @RequestBody commentsDto commentsDto ){
        return commentsService.insert( commentsDto );
    }
    /**
     * 删除
     */
    @PostMapping(Url.comments.delect)
    public ResultDto delect  (@RequestBody commentsDto commentsDto){
        return commentsService.delect( commentsDto );
    }
    /**
     * 修改
     */
    @PostMapping(Url.comments.update)
    public ResultDto update  (@RequestBody commentsDto commentsDto){
        return commentsService.update( commentsDto );
    }
}
