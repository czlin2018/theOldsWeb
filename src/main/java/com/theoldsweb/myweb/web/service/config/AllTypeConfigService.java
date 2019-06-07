package com.theoldsweb.myweb.web.service.config;

import com.theoldsweb.myweb.common.api.BeanCopyUtil;
import com.theoldsweb.myweb.common.api.DateApi;
import com.theoldsweb.myweb.common.config.ResultDto;
import com.theoldsweb.myweb.common.config.SysExcCode;
import com.theoldsweb.myweb.common.dto.AllTypeConfigDto;
import com.theoldsweb.myweb.common.entity.AllTypeConfig;
import com.theoldsweb.myweb.web.mapper.AllTypeConfigMapper;
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
public class AllTypeConfigService {
    @Autowired
    private AllTypeConfigMapper allTypeConfigMapper;

    /**
     * 地址列表
     *
     * @param allTypeConfigDto
     * @return
     */
    public ResultDto getList( AllTypeConfigDto allTypeConfigDto ){

        List<AllTypeConfig> allTypeConfigs = allTypeConfigMapper.getList ( allTypeConfigDto.getLevel ( ) , allTypeConfigDto.getTypeOwer ( ) );
        return new ResultDto ( SysExcCode.SysCommonExcCode.SYS_SUCCESS , allTypeConfigs );
    }

    /**
     * 插入
     *
     * @param allTypeConfigDto
     * @return
     */
    @Transactional(rollbackFor=Exception.class)
    public ResultDto insert( AllTypeConfigDto allTypeConfigDto ){
        AllTypeConfig allTypeConfig = new AllTypeConfig ( );
        BeanCopyUtil.copy ( allTypeConfigDto , allTypeConfig );
        allTypeConfig.setCreateTime ( DateApi.currentDateTime ( ) );
        //检测数据库是否存在
        if ( checkIfExistts ( allTypeConfig ) ) {
            return new ResultDto ( SysExcCode.SysCommonExcCode.SYS_ERROR , "已经存在相同名字的地区" );
        }
        allTypeConfig.setCreateTime ( DateApi.currentDateTime ( ) );
        allTypeConfig.setUpdateTime ( DateApi.currentDateTime ( ) );
        allTypeConfig.setTypeId ( DateApi.getTimeId ( ) );
        int insert = allTypeConfigMapper.insert ( allTypeConfig );
        if(insert>0){
            return new ResultDto( SysExcCode.SysCommonExcCode.SYS_SUCCESS,"新增成功" );
        } else
            return new ResultDto ( SysExcCode.SysCommonExcCode.SYS_ERROR , "新增失败" );
    }

    /**
     * 删除
     *
     * @param typeId
     * @return
     */
    @Transactional(rollbackFor=Exception.class)
    public ResultDto delect( String typeId ){
        AllTypeConfig allTypeConfig = new AllTypeConfig ( );
        allTypeConfig.setTypeId ( typeId );
        int delete = allTypeConfigMapper.deleteByPrimaryKey ( allTypeConfig );
        if(delete>0){
            return new ResultDto( SysExcCode.SysCommonExcCode.SYS_SUCCESS,"删除成功" );
        }else
            return new ResultDto(SysExcCode.SysCommonExcCode.SYS_ERROR, "删除失败");
    }

    /**
     * 更新
     *
     * @param allTypeConfigDto
     * @return
     */
    @Transactional(rollbackFor=Exception.class)
    public ResultDto update( AllTypeConfigDto allTypeConfigDto ){
        AllTypeConfig allTypeConfig = new AllTypeConfig ( );
        BeanCopyUtil.copy ( allTypeConfigDto , allTypeConfig );
        if ( checkIfExistts ( allTypeConfigDto ) ) {
            return new ResultDto ( SysExcCode.SysCommonExcCode.SYS_ERROR , "已经存在相同配置" );
        }
        allTypeConfig.setUpdateTime ( DateApi.currentDateTime ( ) );
        int delete = allTypeConfigMapper.updateByPrimaryKeySelective ( allTypeConfig );
        if(delete>0){
            return new ResultDto( SysExcCode.SysCommonExcCode.SYS_SUCCESS,"更新成功" );
        }else
            return new ResultDto(SysExcCode.SysCommonExcCode.SYS_ERROR, "更新失败");
    }

    /**
     * 检查数据库是否存在该数据
     *
     * @param allTypeConfigDto
     * @return
     */
    private boolean checkIfExistts( AllTypeConfig allTypeConfigDto ){
        AllTypeConfig allTypeConfig = new AllTypeConfig ( );
        allTypeConfig.setTypeName ( allTypeConfigDto.getTypeName ( ) );
        AllTypeConfig tourConfig1 = allTypeConfigMapper.selectOne ( allTypeConfig );
        if ( tourConfig1 !=null ) {
            //代表新增
            if ( allTypeConfigDto.getTypeId ( ) == null )
                return true;
            else
                return ! tourConfig1.getTypeId ( ).equals ( allTypeConfigDto.getTypeId ( ) );
        }else
            return false;
    }
}


