package com.theoldsweb.myweb.web.service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.theoldsweb.myweb.common.api.BeanCopyUtil;
import com.theoldsweb.myweb.common.api.DateApi;
import com.theoldsweb.myweb.common.config.PageDto;
import com.theoldsweb.myweb.common.config.ResultDto;
import com.theoldsweb.myweb.common.config.SysExcCode;
import com.theoldsweb.myweb.common.dto.CommentsDto;
import com.theoldsweb.myweb.common.dto.NewsDto;
import com.theoldsweb.myweb.common.entity.Commentstb;
import com.theoldsweb.myweb.common.entity.News;
import com.theoldsweb.myweb.web.mapper.CommentstbMapper;
import com.theoldsweb.myweb.web.mapper.NewsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @描述:
 * @公司: lumi
 * @author: 泽林
 * @创建日期: 2019-03-19-3-4
 * @创建时间: 下午3:48
 */
@Service
public class NewsService{


    @Autowired
    NewsMapper newsMapper;
    @Autowired
    CommentstbMapper commentstbMapper;

    /**
     * 新闻列表
     *
     * @param pageDto
     * @return
     */
    public ResultDto getNewsList (PageDto pageDto, NewsDto newsDto1){
        Page<Object> objectPage = PageHelper.startPage ( pageDto.getPageNo ( ) , pageDto.getPageSize ( ) );
        List< NewsDto > newsDtoList = newsMapper.getList(newsDto1);
        for(NewsDto newsDto : newsDtoList){

            //查询评价
            newsDto.setCommentsNum(0);
            if ( ! "".equals ( newsDto.getCommentsId ( ) ) ) {
                String substring = newsDto.getCommentsId ( ).substring ( 1 , newsDto.getCommentsId ( ).length ( ) );
                String[] commentsIds = substring.split ( "," );
                newsDto.setCommentsNum(commentsIds.length);
                List< CommentsDto > commentstbList = new ArrayList<>();
                for(String commentsId : commentsIds){
                    CommentsDto commentsDto = commentstbMapper.selectByComments(commentsId);
                    commentstbList.add(commentsDto);
                }
                newsDto.setComments(commentstbList);
            }

        }

        pageDto.setTotalCount(objectPage.getTotal());
        pageDto.setPageData(newsDtoList);
        return new ResultDto(SysExcCode.SysCommonExcCode.SYS_SUCCESS, pageDto);

    }

    /**
     * 新建
     *
     * @param newsDto
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    public ResultDto insert (NewsDto newsDto){
        News news = new News();
        BeanCopyUtil.copy(newsDto, news);
        news.setNewId("n" + DateApi.getTimeId());
        news.setCreateTime(DateApi.currentDateTime());
        news.setUpdateTime(DateApi.currentDateTime());
        news.setNewGivealike(0);
        int insert = newsMapper.insert ( news );
        if(insert > 0){
            return new ResultDto(SysExcCode.SysCommonExcCode.SYS_SUCCESS, "添加成功");
        }else{
            return new ResultDto(SysExcCode.SysCommonExcCode.SYS_ERROR, "添加成功");
        }

    }

    /**
     * 评论
     *
     * @param praamMap
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    public ResultDto newsCommentsAdd (Map< String, String > praamMap){
        String newsId = praamMap.get("newsId");
        String commentsId = DateApi.getTimeId();
        String comments = praamMap.get("comments");

        //先入评论表
        Commentstb commentstb = new Commentstb();
        commentstb.setCommentsId(commentsId);
        commentstb.setComments(comments);
        commentstb.setCreateTime(DateApi.currentDateTime());
        commentstb.setUpdateTime(DateApi.currentDateTime());
        int insertSelective = commentstbMapper.insertSelective(commentstb);

        if(insertSelective >= 0){
            //追加在旅游表评论字段
            newsMapper.updateCommentsByNewId(newsId, commentsId, DateApi.currentDateTime());
        }else{
            return new ResultDto(SysExcCode.SysCommonExcCode.SYS_ERROR, "评论失败");
        }
        return new ResultDto(SysExcCode.SysCommonExcCode.SYS_SUCCESS, "评论成功");

    }
}
