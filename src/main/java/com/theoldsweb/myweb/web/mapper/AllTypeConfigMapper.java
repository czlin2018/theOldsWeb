package com.theoldsweb.myweb.web.mapper;

import com.theoldsweb.myweb.common.entity.AllTypeConfig;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface AllTypeConfigMapper extends Mapper<AllTypeConfig> {
    List<AllTypeConfig> getList( @Param("level") Integer level , @Param("typeOwer") String typeOwer );
}