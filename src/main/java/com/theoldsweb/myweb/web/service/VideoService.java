package com.theoldsweb.myweb.web.service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.theoldsweb.myweb.common.api.BeanCopyUtil;
import com.theoldsweb.myweb.common.api.DateApi;
import com.theoldsweb.myweb.common.config.PageDto;
import com.theoldsweb.myweb.common.config.ResultDto;
import com.theoldsweb.myweb.common.config.SysExcCode;
import com.theoldsweb.myweb.common.dto.CommentsDto;
import com.theoldsweb.myweb.common.dto.VideoDto;
import com.theoldsweb.myweb.common.entity.Commentstb;
import com.theoldsweb.myweb.common.entity.Video;
import com.theoldsweb.myweb.web.mapper.CommentstbMapper;
import com.theoldsweb.myweb.web.mapper.VideoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @描述:
 * @版权: Copyright (c) 2016-2018
 * @公司: lumi
 * @作者: 泽林
 * @创建日期: 2019-06-05
 * @创建时间: 14:34
 */
@Service
public class VideoService {

    @Autowired
    VideoMapper videoMapper;


    @Autowired
    CommentstbMapper commentstbMapper;


    public ResultDto getList( PageDto pageDto , VideoDto videoDto ){
        Page<Object> objectPage = PageHelper.startPage ( pageDto.getPageNo ( ) , pageDto.getPageSize ( ) );
        List<VideoDto> newsDtoList = videoMapper.getList ( videoDto );


        for ( VideoDto videoDto1 : newsDtoList ) {

            //查询评价
            videoDto1.setCommentsNum ( 0 );
            if ( ! "".equals ( videoDto1.getCommentsId ( ) ) ) {
                String substring = videoDto1.getCommentsId ( ).substring ( 1 , videoDto1.getCommentsId ( ).length ( ) );
                String[] commentsIds = substring.split ( "," );
                videoDto1.setCommentsNum ( commentsIds.length );
                List<CommentsDto> commentstbList = new ArrayList<> ( );
                for ( String commentsId : commentsIds ) {
                    CommentsDto commentsDto = commentstbMapper.selectByComments ( commentsId );
                    commentstbList.add ( commentsDto );
                }
                videoDto1.setComments ( commentstbList );
            }

        }
        pageDto.setTotalCount ( objectPage.getTotal ( ) );
        pageDto.setPageData ( newsDtoList );
        return new ResultDto ( SysExcCode.SysCommonExcCode.SYS_SUCCESS , pageDto );
    }


    public ResultDto insert( VideoDto videoDto ){
        Video video = new Video ( );
        BeanCopyUtil.copy ( videoDto , video );
        video.setVideoId ( "ac" + DateApi.getTimeId ( ) );
        video.setCommentsId ( "" );
        video.setVideoGiveALike ( 0 );
        video.setCreatTime ( DateApi.currentDateTime ( ) );
        video.setUpdateTime ( DateApi.currentDateTime ( ) );
        int insert = videoMapper.insert ( video );
        if ( insert > 0 ) {
            return new ResultDto ( SysExcCode.SysCommonExcCode.SYS_SUCCESS , "添加成功" );
        } else {
            return new ResultDto ( SysExcCode.SysCommonExcCode.SYS_ERROR , "添加成功" );
        }
    }

    /**
     * 评论
     *
     * @param praamMap
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    public ResultDto videoCommentsAdd( Map<String, String> praamMap ){
        String videoId = praamMap.get ( "videoId" );
        String commentsId = DateApi.getTimeId ( );
        String comments = praamMap.get ( "comments" );

        //先入评论表
        Commentstb commentstb = new Commentstb ( );
        commentstb.setCommentsId ( commentsId );
        commentstb.setComments ( comments );
        commentstb.setCreateTime ( DateApi.currentDateTime ( ) );
        commentstb.setUpdateTime ( DateApi.currentDateTime ( ) );
        int insertSelective = commentstbMapper.insertSelective ( commentstb );

        if ( insertSelective >= 0 ) {
            //追加在旅游表评论字段
            videoMapper.updateCommentsByNewId ( videoId , commentsId , DateApi.currentDateTime ( ) );
        } else {
            return new ResultDto ( SysExcCode.SysCommonExcCode.SYS_ERROR , "评论失败" );
        }
        return new ResultDto ( SysExcCode.SysCommonExcCode.SYS_SUCCESS , "评论成功" );

    }
}


