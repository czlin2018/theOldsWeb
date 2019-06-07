package com.theoldsweb.myweb.web.mapper;

import com.theoldsweb.myweb.common.dto.LoveDto;
import com.theoldsweb.myweb.common.entity.Love;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

import java.util.Date;
import java.util.List;

public interface LoveMapper extends Mapper<Love> {
    List<LoveDto> getList( @Param("loveDto") LoveDto loveDto );

    int del( @Param("loveId") String loveId );

    int update( @Param("loveId") String loveId , @Param("updatTime") Date updatTime );

}