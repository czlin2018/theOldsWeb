package com.theoldsweb.myweb.web.mapper;

import com.theoldsweb.myweb.common.dto.VideoDto;
import com.theoldsweb.myweb.common.entity.Video;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

import java.util.Date;
import java.util.List;

public interface VideoMapper extends Mapper<Video> {
    List<VideoDto> getList( @Param("videoDto") VideoDto videoDto );

    void updateCommentsByNewId( @Param("videoId") String videoId , @Param("commentsId") String commentsId ,
                                @Param("currentDateTime") Date currentDateTime );

    int del( @Param("videoId") String videoId );

}