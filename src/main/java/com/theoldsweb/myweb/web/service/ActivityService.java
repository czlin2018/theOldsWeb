package com.theoldsweb.myweb.web.service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.theoldsweb.myweb.common.api.BeanCopyUtil;
import com.theoldsweb.myweb.common.api.DateApi;
import com.theoldsweb.myweb.common.config.PageDto;
import com.theoldsweb.myweb.common.config.ResultDto;
import com.theoldsweb.myweb.common.config.SysExcCode;
import com.theoldsweb.myweb.common.dto.ActivityDto;
import com.theoldsweb.myweb.common.entity.Activity;
import com.theoldsweb.myweb.web.mapper.ActivityMapper;
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
public class ActivityService {

    @Autowired
    ActivityMapper activityMapper;

    public ResultDto getList( PageDto pageDto , ActivityDto activityDto ){
        Page<Object> objectPage = PageHelper.startPage ( pageDto.getPageNo ( ) , pageDto.getPageSize ( ) );
        List<ActivityDto> newsDtoList = activityMapper.getList ( activityDto );
        pageDto.setTotalCount ( objectPage.getTotal ( ) );
        pageDto.setPageData ( newsDtoList );
        return new ResultDto ( SysExcCode.SysCommonExcCode.SYS_SUCCESS , pageDto );
    }

    public ResultDto insert( ActivityDto activityDto ){
        Activity activity = new Activity ( );
        BeanCopyUtil.copy ( activityDto , activity );
        activity.setActivityId ( "a" + DateApi.getTimeId ( ) );
        activity.setCreatTime ( DateApi.currentDateTime ( ) );
        activity.setUpdateTime ( DateApi.currentDateTime ( ) );
        int insert = activityMapper.insert ( activity );
        if ( insert > 0 ) {
            return new ResultDto ( SysExcCode.SysCommonExcCode.SYS_SUCCESS , "添加成功" );
        } else {
            return new ResultDto ( SysExcCode.SysCommonExcCode.SYS_ERROR , "添加成功" );
        }
    }
}
