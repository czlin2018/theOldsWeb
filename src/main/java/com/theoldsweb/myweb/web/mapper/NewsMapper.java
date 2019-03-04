package com.theoldsweb.myweb.web.mapper;

import com.theoldsweb.myweb.common.dto.NewsDto;
import com.theoldsweb.myweb.common.entity.News;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

import java.util.Date;
import java.util.List;

public interface NewsMapper extends Mapper<News> {

    void updateCommentsByNewId (@Param("newsId") String newsId, @Param("commentsId") String commentsId, @Param("currentDateTime") Date currentDateTime);

    List< NewsDto > getList (@Param("newsDto") NewsDto newsDto);
}