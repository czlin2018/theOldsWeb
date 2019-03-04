package com.theoldsweb.myweb.web.service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.theoldsweb.myweb.common.api.BeanCopyUtil;
import com.theoldsweb.myweb.common.api.DateApi;
import com.theoldsweb.myweb.common.config.PageDto;
import com.theoldsweb.myweb.common.config.ResultDto;
import com.theoldsweb.myweb.common.config.SysExcCode;
import com.theoldsweb.myweb.common.dto.CommentsDto;
import com.theoldsweb.myweb.common.dto.TourtbDto;
import com.theoldsweb.myweb.common.entity.Commentstb;
import com.theoldsweb.myweb.common.entity.Tourtb;
import com.theoldsweb.myweb.web.mapper.CommentstbMapper;
import com.theoldsweb.myweb.web.mapper.TourtbMapper;
import com.theoldsweb.myweb.web.mapper.AreatbMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @描述: 旅游tab页服务
 * @版权: Copyright (c) 2016-2018
 * @公司: lumi
 * @作者: 泽林
 * @创建日期: 2018-10-30
 * @创建时间: 下午5:08
 */
@Service
public class TourService {
    @Autowired
    private TourtbMapper tourtbMapper;
    @Autowired
    private AreatbMapper areatbMapper;
    @Autowired
    private CommentstbMapper commentstbMapper;


    /**
     * 旅游地区列表
     *
     * @param pageDto
     * @return
     */
    public ResultDto getTourAll( PageDto pageDto ){
        List <TourtbDto>tourDtoList=tourtbMapper.getList();
        for ( TourtbDto tourtbDto : tourDtoList ) {

            //查询评价
            tourtbDto.setCommentsNum ( 0 );
            if ( tourtbDto.getCommentsId ( ) != null ) {
                String[] commentsIds = tourtbDto.getCommentsId ( ).split ( "," );
                tourtbDto.setCommentsNum ( commentsIds.length );
                List<CommentsDto> commentstbList = new ArrayList<> ( );
                for ( String commentsId : commentsIds ) {
                    CommentsDto commentsDto = commentstbMapper.selectByComments ( commentsId );
                    commentstbList.add ( commentsDto );
                }
                tourtbDto.setComments ( commentstbList );
            }

            //对上国内国外
            if ( (tourtbDto.getTourCountryId ( ) == 1) ) {
                tourtbDto.setTourCountryName ( "国内" );
            } else{
                tourtbDto.setTourCountryName ( "国外" );
            }

        }
        Page<Object> objectPage = PageHelper.startPage(pageDto.getPageNo(), pageDto.getPageSize());
        pageDto.setTotalCount(objectPage.getTotal());
        pageDto.setPageData(tourDtoList);
        return new ResultDto( SysExcCode.SysCommonExcCode.SYS_SUCCESS, pageDto);

    }

    /**
     * 新建
     *
     * @param tourtbDto
     * @return
     */
    @Transactional(rollbackFor=Exception.class)
    public ResultDto insert( TourtbDto tourtbDto ){
        Tourtb tourtb=new Tourtb();
        BeanCopyUtil.copy( tourtbDto,tourtb );
        tourtb.setTourId( "t"+ DateApi.getTimeId( ) );
        tourtb.setCreateTime( DateApi.currentDateTime() );
        tourtb.setUpdateTime( DateApi.currentDateTime() );
        tourtb.setTourGivealike( 0 );
        int insert=tourtbMapper.insert( tourtb );
        if(insert>0){
            return new ResultDto( SysExcCode.SysCommonExcCode.SYS_SUCCESS,"添加成功" );
        }else{
            return new ResultDto( SysExcCode.SysCommonExcCode.SYS_ERROR,"添加成功" );
        }

    }

    /**
     * 评论
     *
     * @param praamMap
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    public ResultDto tourCommentsAdd( Map<String, String> praamMap ){
        String tourId = praamMap.get ( "tourId" );
        String commentsId = DateApi.getTimeId ( );
        String comments = praamMap.get ( "comments" );

        //先入评论表
        Commentstb commentstb = new Commentstb( );
        commentstb.setCommentsId ( commentsId );
        commentstb.setComments ( comments );
        commentstb.setCreateTime ( DateApi.currentDateTime ( ) );
        commentstb.setUpdateTime ( DateApi.currentDateTime ( ) );
        int insertSelective = commentstbMapper.insertSelective ( commentstb );

        if ( insertSelective >= 0 ) {
            //追加在旅游表评论字段
            tourtbMapper.updateCommentsByTourId ( tourId , commentsId , DateApi.currentDateTime ( ) );
        } else{
            return new ResultDto ( SysExcCode.SysCommonExcCode.SYS_ERROR , "评论失败" );
        }
        return new ResultDto ( SysExcCode.SysCommonExcCode.SYS_SUCCESS , "评论成功" );


    }
}
