package com.theoldsweb.myweb.web.mapper;

import com.theoldsweb.myweb.common.dto.ActivityDto;
import com.theoldsweb.myweb.common.entity.Activity;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface ActivityMapper extends Mapper<Activity> {
    List<ActivityDto> getList( @Param("activityDto") ActivityDto activityDto );

    int del( @Param("activityId") String activityId );

}