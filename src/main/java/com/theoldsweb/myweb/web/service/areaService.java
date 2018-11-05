package com.theoldsweb.myweb.web.service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.theoldsweb.myweb.common.api.BeanCopyUtil;
import com.theoldsweb.myweb.common.api.DateApi;
import com.theoldsweb.myweb.common.config.SysExcCode;
import com.theoldsweb.myweb.common.config.PageDto;
import com.theoldsweb.myweb.common.config.ResultDto;
import com.theoldsweb.myweb.common.dto.areaDto;
import com.theoldsweb.myweb.common.entity.areatb;
import com.theoldsweb.myweb.web.mapper.areatbMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

    @Transactional(rollbackFor=Exception.class)
    public ResultDto insert( areaDto areaDto ){
        areatb areatb=new areatb();
        BeanCopyUtil.copy( areaDto,areatb );
        //检测数据库时候存在
        if(checkIfExistts(areaDto))
        {
            return   new ResultDto(0, "已经存在相同名字的地区");
        }
        areatb.setCreateTime( DateApi.currentDateTime() );
        areatb.setUpdateTime( DateApi.currentDateTime() );
        int insert=areatbMapper.insert( areatb );
        if(insert>0){
            return new ResultDto( 0,"新增成功" );
        }else
        return new ResultDto(0, "新增失败");
    }

    @Transactional(rollbackFor=Exception.class)
    public ResultDto delect( areaDto areaDto){
        areatb areatb=new areatb();
        BeanCopyUtil.copy( areaDto,areatb );
        int delete=areatbMapper.deleteByPrimaryKey( areatb );
        if(delete>0){
            return new ResultDto( 0,"删除成功" );
        }else
            return new ResultDto(0, "删除失败");
    }
    @Transactional(rollbackFor=Exception.class)
    public ResultDto update( areaDto areaDto){
        areatb areatb=new areatb();
        BeanCopyUtil.copy( areaDto,areatb );
        if(checkIfExistts(areaDto))
        {
            return   new ResultDto(0, "已经存在相同名字的地区");
        }
        areatb.setUpdateTime( DateApi.currentDateTime() );
        int delete=areatbMapper.updateByPrimaryKey( areatb );
        if(delete>0){
            return new ResultDto( 0,"更新成功" );
        }else
            return new ResultDto(0, "更新失败");
    }


    private boolean checkIfExistts( areaDto areaDto ){
        areatb areatb=new areatb();
        areatb.setTourAreaName(areaDto.getTourAreaName());
        areatb areatb1=areatbMapper.selectOne( areatb );
        if ( areatb1!=null ) {
            //代表新增
            if ( areaDto.getTourAreaId()==null )
                return true;
            else
                return !areatb1.getTourAreaId().equals( areaDto.getTourAreaId() );
        }else
            return false;
    }
}


