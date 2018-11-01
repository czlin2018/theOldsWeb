package com.theoldsweb.myweb.web.service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.theoldsweb.myweb.common.api.BeanCopyUtil;
import com.theoldsweb.myweb.common.api.dateApi;
import com.theoldsweb.myweb.common.config.SysExcCode;
import com.theoldsweb.myweb.common.config.PageDto;
import com.theoldsweb.myweb.common.config.ResultDto;
import com.theoldsweb.myweb.common.dto.areaDto;
import com.theoldsweb.myweb.common.entity.areatb;
import com.theoldsweb.myweb.web.mapper.areatbMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @描述:
 * @版权: Copyright (c) 2016-2018
 * @公司: lumi
 * @作者: 泽林
 * @创建日期: 2018-11-01
 * @创建时间: 下午12:23
 */
@Service
public class areaService {
    @Autowired
    private areatbMapper areatbMapper;

    public ResultDto getList( PageDto pageDto ){
        List <areatb> areatbs=areatbMapper.selectAll( );
        Page<Object> objectPage = PageHelper.startPage(pageDto.getPageNo(), pageDto.getPageSize());
        pageDto.setTotalCount(objectPage.getTotal());
        pageDto.setPageData(areatbs);
        return new ResultDto( SysExcCode.SysCommonExcCode.SYS_SUCCESS, pageDto);
    }

    public ResultDto insert( areaDto areaDto ){
        areatb areatb=new areatb();
        BeanCopyUtil.copy( areaDto,areatb );
        areatb.setCreateTime( dateApi.currentDateTime() );
        areatb.setUpdateTime( dateApi.currentDateTime() );
        int insert=areatbMapper.insert( areatb );
        if(insert>0){
            return new ResultDto( 0,"新增成功" );
        }else
        return new ResultDto(0, "新增失败");
    }

    public ResultDto delect( areaDto areaDto){
        areatb areatb=new areatb();
        BeanCopyUtil.copy( areaDto,areatb );
        int delete=areatbMapper.deleteByPrimaryKey( areatb );
        if(delete>0){
            return new ResultDto( 0,"删除成功" );
        }else
            return new ResultDto(0, "删除失败");
    }
    public ResultDto update( areaDto areaDto){
        areatb areatb=new areatb();
        BeanCopyUtil.copy( areaDto,areatb );
        areatb.setUpdateTime( dateApi.currentDateTime() );
        int delete=areatbMapper.updateByPrimaryKey( areatb );
        if(delete>0){
            return new ResultDto( 0,"更新成功" );
        }else
            return new ResultDto(0, "更新失败");
    }
}


