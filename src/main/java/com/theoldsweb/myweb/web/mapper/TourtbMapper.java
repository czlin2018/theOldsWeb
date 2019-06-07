package com.theoldsweb.myweb.web.mapper;

import com.theoldsweb.myweb.common.dto.TourtbDto;
import com.theoldsweb.myweb.common.entity.Tourtb;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

import java.util.Date;
import java.util.List;

@Repository
public interface TourtbMapper extends Mapper< Tourtb > {



    List<TourtbDto> selectByOne( TourtbDto tourtbDto );

    void updateCommentsByTourId( @Param("tourId") String tourId ,
                                 @Param("commentsId") String commentsId ,
                                 @Param("date") Date date );

    int del( @Param("tourId") String tourId );

}