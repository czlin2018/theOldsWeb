package com.theoldsweb.myweb.web.service.config;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.theoldsweb.myweb.common.api.BeanCopyUtil;
import com.theoldsweb.myweb.common.api.DateApi;
import com.theoldsweb.myweb.common.config.PageDto;
import com.theoldsweb.myweb.common.config.ResultDto;
import com.theoldsweb.myweb.common.config.SysExcCode;
import com.theoldsweb.myweb.common.dto.AreaDto;
import com.theoldsweb.myweb.common.entity.Areatb;
import com.theoldsweb.myweb.web.mapper.AreatbMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @描述: 地址配置服务 //todo 加禁用启用
 * @版权: Copyright (c) 2016-2018
 * @公司: lumi
 * @作者: 泽林
 * @创建日期: 2018-11-01
 * @创建时间: 下午12:23
 */
@Service
public class AreaService{
    @Autowired
    private AreatbMapper areatbMapper;

    /**
     * 地址列表
     *
     * @param pageDto
     * @return
     */
    public ResultDto getList( PageDto pageDto ){
        Page<Object> objectPage = PageHelper.startPage(pageDto.getPageNo(), pageDto.getPageSize());
        List<Areatb> areatbs = areatbMapper.selectAll ( );
        for ( Areatb areatb : areatbs ) {
            areatb.getTourCountryId ( );
            if ( "1".equals ( areatb.getTourCountryId ( ) ) ) {
                areatb.setTourCountryId ( "国内" );
            } else {
                areatb.setTourCountryId ( "国外" );
            }
        }
        pageDto.setTotalCount(objectPage.getTotal());
        pageDto.setPageData(areatbs);
        return new ResultDto( SysExcCode.SysCommonExcCode.SYS_SUCCESS, pageDto);
    }

    /**
     * 插入
     *
     * @param areaDto
     * @return
     */
    @Transactional(rollbackFor=Exception.class)
    public ResultDto insert( AreaDto areaDto ){
        Areatb areatb = new Areatb ( );
        BeanCopyUtil.copy( areaDto,areatb );
        areatb.setCreateTime ( DateApi.currentDateTime ( ) );
        //检测数据库是否存在
        if ( checkIfExistts ( areaDto ) ) {
            return new ResultDto ( SysExcCode.SysCommonExcCode.SYS_ERROR , "已经存在相同名字的地区" );
        }
        areatb.setCreateTime( DateApi.currentDateTime() );
        areatb.setUpdateTime( DateApi.currentDateTime() );
        areatb.setTourAreaId ( DateApi.getTimeId ( ) );
        int insert=areatbMapper.insert( areatb );
        if(insert>0){
            return new ResultDto( SysExcCode.SysCommonExcCode.SYS_SUCCESS,"新增成功" );
        } else
            return new ResultDto ( SysExcCode.SysCommonExcCode.SYS_ERROR , "新增失败" );
    }

    /**
     * 删除
     *
     * @param tourAreaId
     * @return
     */
    @Transactional(rollbackFor=Exception.class)
    public ResultDto delect( String tourAreaId ){
        Areatb areatb = new Areatb ( );
        areatb.setTourAreaId ( tourAreaId );
        int delete=areatbMapper.deleteByPrimaryKey( areatb );
        if(delete>0){
            return new ResultDto( SysExcCode.SysCommonExcCode.SYS_SUCCESS,"删除成功" );
        }else
            return new ResultDto(SysExcCode.SysCommonExcCode.SYS_ERROR, "删除失败");
    }

    /**
     * 更新
     *
     * @param areaDto
     * @return
     */
    @Transactional(rollbackFor=Exception.class)
    public ResultDto update( AreaDto areaDto ){
        Areatb areatb = new Areatb ( );
        BeanCopyUtil.copy( areaDto,areatb );
        if ( checkIfExistts ( areaDto ) ) {
            return   new ResultDto(SysExcCode.SysCommonExcCode.SYS_ERROR, "已经存在相同名字的地区");
        }
        areatb.setUpdateTime ( DateApi.currentDateTime ( ) );
        int delete = areatbMapper.updateByPrimaryKeySelective ( areatb );
        if(delete>0){
            return new ResultDto( SysExcCode.SysCommonExcCode.SYS_SUCCESS,"更新成功" );
        }else
            return new ResultDto(SysExcCode.SysCommonExcCode.SYS_ERROR, "更新失败");
    }

    /**
     * 检查数据库是否存在该数据
     *
     * @param areaDto
     * @return
     */
    private boolean checkIfExistts( AreaDto areaDto ){
        Areatb areatb = new Areatb ( );
        areatb.setTourAreaName(areaDto.getTourAreaName());
        Areatb areatb1 = areatbMapper.selectOne ( areatb );
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


