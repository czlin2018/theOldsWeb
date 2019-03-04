package com.theoldsweb.myweb.web.mapper;

import com.theoldsweb.myweb.common.dto.CommentsDto;
import com.theoldsweb.myweb.common.entity.Commentstb;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

@Repository
public interface CommentstbMapper extends Mapper< Commentstb > {
    CommentsDto selectByComments( @Param("comments_id") String comments_id );
}