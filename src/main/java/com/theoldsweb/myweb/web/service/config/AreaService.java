package com.theoldsweb.myweb.web.service.config;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.theoldsweb.myweb.common.api.BeanCopyUtil;
import com.theoldsweb.myweb.common.api.DateApi;
import com.theoldsweb.myweb.common.config.PageDto;
import com.theoldsweb.myweb.common.config.ResultDto;
import com.theoldsweb.myweb.common.config.SysExcCode;
import com.theoldsweb.myweb.common.dto.TourConfigDto;
import com.theoldsweb.myweb.common.entity.TourConfig;
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
        List< TourConfig > tourConfigs = areatbMapper.selectAll ( );
        for ( TourConfig tourConfig : tourConfigs) {
            tourConfig.getTourCountryId ( );
            if ( "1".equals ( tourConfig.getTourCountryId ( ) ) ) {
                tourConfig.setTourCountryId ( "国内" );
            } else {
                tourConfig.setTourCountryId ( "国外" );
            }
        }
        pageDto.setTotalCount(objectPage.getTotal());
        pageDto.setPageData(tourConfigs);
        return new ResultDto( SysExcCode.SysCommonExcCode.SYS_SUCCESS, pageDto);
    }

    /**
     * 插入
     *
     * @param tourConfigDto
     * @return
     */
    @Transactional(rollbackFor=Exception.class)
    public ResultDto insert( TourConfigDto tourConfigDto){
        TourConfig tourConfig = new TourConfig( );
        BeanCopyUtil.copy(tourConfigDto, tourConfig);
        tourConfig.setCreateTime ( DateApi.currentDateTime ( ) );
        //检测数据库是否存在
        if ( checkIfExistts (tourConfigDto) ) {
            return new ResultDto ( SysExcCode.SysCommonExcCode.SYS_ERROR , "已经存在相同名字的地区" );
        }
        tourConfig.setCreateTime( DateApi.currentDateTime() );
        tourConfig.setUpdateTime( DateApi.currentDateTime() );
        tourConfig.setTourAreaId ( DateApi.getTimeId ( ) );
        int insert=areatbMapper.insert(tourConfig);
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
        TourConfig tourConfig = new TourConfig( );
        tourConfig.setTourAreaId ( tourAreaId );
        int delete=areatbMapper.deleteByPrimaryKey(tourConfig);
        if(delete>0){
            return new ResultDto( SysExcCode.SysCommonExcCode.SYS_SUCCESS,"删除成功" );
        }else
            return new ResultDto(SysExcCode.SysCommonExcCode.SYS_ERROR, "删除失败");
    }

    /**
     * 更新
     *
     * @param tourConfigDto
     * @return
     */
    @Transactional(rollbackFor=Exception.class)
    public ResultDto update( TourConfigDto tourConfigDto){
        TourConfig tourConfig = new TourConfig( );
        BeanCopyUtil.copy(tourConfigDto, tourConfig);
        if ( checkIfExistts (tourConfigDto) ) {
            return   new ResultDto(SysExcCode.SysCommonExcCode.SYS_ERROR, "已经存在相同名字的地区");
        }
        tourConfig.setUpdateTime ( DateApi.currentDateTime ( ) );
        int delete = areatbMapper.updateByPrimaryKeySelective (tourConfig);
        if(delete>0){
            return new ResultDto( SysExcCode.SysCommonExcCode.SYS_SUCCESS,"更新成功" );
        }else
            return new ResultDto(SysExcCode.SysCommonExcCode.SYS_ERROR, "更新失败");
    }

    /**
     * 检查数据库是否存在该数据
     *
     * @param tourConfigDto
     * @return
     */
    private boolean checkIfExistts( TourConfigDto tourConfigDto){
        TourConfig tourConfig = new TourConfig( );
        tourConfig.setTourAreaName(tourConfigDto.getTourAreaName());
        TourConfig tourConfig1 = areatbMapper.selectOne (tourConfig);
        if ( tourConfig1 !=null ) {
            //代表新增
            if ( tourConfigDto.getTourAreaId()==null )
                return true;
            else
                return ! tourConfig1.getTourAreaId().equals( tourConfigDto.getTourAreaId() );
        }else
            return false;
    }
}


