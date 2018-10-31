package com.theoldsweb.myweb.web.service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.theoldsweb.myweb.common.api.BeanCopyUtil;
import com.theoldsweb.myweb.common.config.SysExcCode;
import com.theoldsweb.myweb.common.dto.PageDto;
import com.theoldsweb.myweb.common.dto.ResultDto;
import com.theoldsweb.myweb.common.dto.TourtbDto;
import com.theoldsweb.myweb.common.dto.commensdDto;
import com.theoldsweb.myweb.common.entity.areatb;
import com.theoldsweb.myweb.common.entity.tourtb;
import com.theoldsweb.myweb.web.mapper.tourtbMapper;
import com.theoldsweb.myweb.web.mapper.areatbMapper;
import com.theoldsweb.myweb.web.mapper.commentstbMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @描述:
 * @版权: Copyright (c) 2016-2018
 * @公司: lumi
 * @作者: 泽林
 * @创建日期: 2018-10-30
 * @创建时间: 下午5:08
 */
@Service
public class TourService {


    @Autowired
    private tourtbMapper tourtbMapper;
    @Autowired
    private areatbMapper areatbMapper;
    @Autowired
    private commentstbMapper commentstbMapper;

    public ResultDto getTourAll( PageDto pageDto ){
        List <TourtbDto>tourDtoList=tourtbMapper.getList();
        for ( TourtbDto tourtbDto : tourDtoList ) {
            if(tourtbDto.getTourCountryId()==1){
                tourtbDto.setTourCountryName( "国内" );
            }else{
                tourtbDto.setTourCountryName( "国外" );
            }
            //查询地区
            areatb areatb=areatbMapper.selectByPrimaryKey( tourtbDto.getTourAreaId( ) );
            if ( areatb!=null ){
            tourtbDto.setTourAreaName( areatb.getTourAreaName() );}
            //查询评价
            List <commensdDto> commentstbList=commentstbMapper.selectByComments( tourtbDto.getTourCommentsId( ) );
            tourtbDto.setTourComments( commentstbList );
        }

        Page<Object> objectPage = PageHelper.startPage(pageDto.getPageNo(), pageDto.getPageSize());
        pageDto.setTotalCount(objectPage.getTotal());
        pageDto.setPageData(tourDtoList);
        return new ResultDto( SysExcCode.SysCommonExcCode.SYS_SUCCESS, pageDto);

    }


    public ResultDto insert( TourtbDto tourtbDto ){
        tourtb tourtb=new tourtb();
        BeanCopyUtil.copy( tourtbDto,tourtb );
        int insert=tourtbMapper.insert( tourtb );
        if(insert>0){
            return new ResultDto( 0,"添加成功" );
        }else
            return new ResultDto( 0,"失败成功" );

    }
}
