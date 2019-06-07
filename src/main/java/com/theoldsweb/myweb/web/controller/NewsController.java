package com.theoldsweb.myweb.web.controller;

import com.theoldsweb.myweb.common.config.PageDto;
import com.theoldsweb.myweb.common.config.ResultDto;
import com.theoldsweb.myweb.common.dto.NewsDto;
import com.theoldsweb.myweb.common.url.Url;
import com.theoldsweb.myweb.web.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @描述:
 * @公司: lumi
 * @author: 泽林
 * @创建日期: 2019-03-19-3-4
 * @创建时间: 下午3:48
 */
@RestController
public class NewsController{
    @Autowired
    NewsService newsService;

    /**
     * 列表
     */
    @GetMapping(value = Url.news.getNewsList)
    public ResultDto getTourList (PageDto pageDto, NewsDto newsDto){
        return newsService.getNewsList(pageDto, newsDto);
    }

    /**
     * 添加
     */
    @PostMapping(value = Url.news.insert)
    public ResultDto insert (@RequestBody NewsDto newsDto){
        return newsService.insert(newsDto);
    }

    /**
     * 评论
     */
    @PostMapping(value = Url.news.newsCommentsAdd)
    public ResultDto newsCommentsAdd (@RequestBody Map< String, String > praamMap){
        return newsService.newsCommentsAdd(praamMap);
    }

    /**
     * 删除
     */
    @GetMapping(value = Url.news.del)
    public ResultDto del( String newsId ){
        return newsService.del ( newsId );
    }

}
