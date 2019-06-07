package com.theoldsweb.myweb.web.service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.theoldsweb.myweb.common.api.BeanCopyUtil;
import com.theoldsweb.myweb.common.api.DateApi;
import com.theoldsweb.myweb.common.config.PageDto;
import com.theoldsweb.myweb.common.config.ResultDto;
import com.theoldsweb.myweb.common.config.SysExcCode;
import com.theoldsweb.myweb.common.dto.LoveDto;
import com.theoldsweb.myweb.common.entity.Love;
import com.theoldsweb.myweb.web.mapper.LoveMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @描述:
 * @版权: Copyright (c) 2016-2018
 * @公司: lumi
 * @作者: 泽林
 * @创建日期: 2019-06-05
 * @创建时间: 14:34
 */
@Service
public class LoveService {

    @Autowired
    LoveMapper loveMapper;

    public ResultDto getList( PageDto pageDto , LoveDto loveDto ){
        Page<Object> objectPage = PageHelper.startPage ( pageDto.getPageNo ( ) , pageDto.getPageSize ( ) );
        List<LoveDto> newsDtoList = loveMapper.getList ( loveDto );
        pageDto.setTotalCount ( objectPage.getTotal ( ) );
        pageDto.setPageData ( newsDtoList );
        return new ResultDto ( SysExcCode.SysCommonExcCode.SYS_SUCCESS , pageDto );
    }

    public ResultDto insert( LoveDto loveDto ){
        Love love = new Love ( );
        BeanCopyUtil.copy ( loveDto , love );
        love.setLoveId ( "l" + DateApi.getTimeId ( ) );
        love.setCreatTime ( DateApi.currentDateTime ( ) );
        love.setUpdateTime ( DateApi.currentDateTime ( ) );
        love.setLovestatus ( 1 );
        int insert = loveMapper.insert ( love );
        if ( insert > 0 ) {
            return new ResultDto ( SysExcCode.SysCommonExcCode.SYS_SUCCESS , "添加成功" );
        } else {
            return new ResultDto ( SysExcCode.SysCommonExcCode.SYS_ERROR , "添加成功" );
        }
    }

    public ResultDto del( String loveId ){
        int del = loveMapper.del ( loveId );
        if ( del > 0 ) {
            return new ResultDto ( SysExcCode.SysCommonExcCode.SYS_SUCCESS , "删除成功" );
        } else {
            return new ResultDto ( SysExcCode.SysCommonExcCode.SYS_ERROR , "删除失败" );
        }

    }

    public ResultDto update( String loveId ){
        int update = loveMapper.update ( loveId , DateApi.currentDateTime ( ) );
        if ( update > 0 ) {
            return new ResultDto ( SysExcCode.SysCommonExcCode.SYS_SUCCESS , "审核成功" );
        } else {
            return new ResultDto ( SysExcCode.SysCommonExcCode.SYS_ERROR , "审核失败" );
        }
    }
}
