package com.theoldsweb.myweb.web.mapper;

import com.theoldsweb.myweb.common.dto.commentsDto;
import com.theoldsweb.myweb.common.entity.commentstb;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

@Repository
public interface commentstbMapper extends Mapper<commentstb> {
    List<commentsDto> selectByComments( @Param( "tour_comments_id" ) String tour_comments_id );
}