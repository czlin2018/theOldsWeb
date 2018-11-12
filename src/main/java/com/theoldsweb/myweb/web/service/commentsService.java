package com.theoldsweb.myweb.web.service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.theoldsweb.myweb.common.api.BeanCopyUtil;
import com.theoldsweb.myweb.common.api.DateApi;
import com.theoldsweb.myweb.common.config.PageDto;
import com.theoldsweb.myweb.common.config.ResultDto;
import com.theoldsweb.myweb.common.config.SysExcCode;
import com.theoldsweb.myweb.common.dto.commentsDto;
import com.theoldsweb.myweb.common.entity.commentstb;
import com.theoldsweb.myweb.web.mapper.commentstbMapper;
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
public class commentsService {
    @Autowired
    private commentstbMapper commentstbMapper;

    public ResultDto getList( PageDto pageDto ){
        List <commentstb> commentstbList=commentstbMapper.selectAll( );
        Page<Object> objectPage = PageHelper.startPage(pageDto.getPageNo(), pageDto.getPageSize());
        pageDto.setTotalCount(objectPage.getTotal());
        pageDto.setPageData(commentstbList);
        return new ResultDto( SysExcCode.SysCommonExcCode.SYS_SUCCESS, pageDto);
    }
    @Transactional(rollbackFor=Exception.class)
    public ResultDto insert( commentsDto commentsDto ){
        commentstb commentstb=new commentstb();
        BeanCopyUtil.copy( commentsDto,commentstb );
        commentstb.setCreateTime( DateApi.currentDateTime() );
        commentstb.setUpdateTime( DateApi.currentDateTime() );
        int insert=commentstbMapper.insert( commentstb );
        if(insert>0){
            return new ResultDto( SysExcCode.SysCommonExcCode.SYS_SUCCESS,"新增成功" );
        }else
        return new ResultDto(SysExcCode.SysCommonExcCode.SYS_ERROR, "新增失败");
    }
    @Transactional(rollbackFor=Exception.class)
    public ResultDto delect( commentsDto commentsDto){
        commentstb commentstb=new commentstb();
        BeanCopyUtil.copy( commentsDto,commentstb );
        int delete=commentstbMapper.deleteByPrimaryKey( commentstb );
        if(delete>0){
            return new ResultDto( SysExcCode.SysCommonExcCode.SYS_SUCCESS,"删除成功" );
        }else
            return new ResultDto(SysExcCode.SysCommonExcCode.SYS_ERROR, "删除失败");
    }
    @Transactional(rollbackFor=Exception.class)
    public ResultDto update( commentsDto commentsDto){
        commentstb commentstb=new commentstb();
        BeanCopyUtil.copy( commentsDto,commentstb );
        commentstb.setUpdateTime( DateApi.currentDateTime() );
        int delete=commentstbMapper.updateByPrimaryKey( commentstb );
        if(delete>0){
            return new ResultDto( SysExcCode.SysCommonExcCode.SYS_SUCCESS,"更新成功" );
        }else
            return new ResultDto(SysExcCode.SysCommonExcCode.SYS_ERROR, "更新失败");
    }


}



