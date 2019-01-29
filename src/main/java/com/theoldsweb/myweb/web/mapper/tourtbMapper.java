package com.theoldsweb.myweb.web.mapper;

import com.theoldsweb.myweb.common.dto.TourtbDto;
import com.theoldsweb.myweb.common.entity.tourtb;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

@Repository
public interface tourtbMapper extends Mapper<tourtb> {

    List<TourtbDto> getList( );


    List<TourtbDto> selectByOne( TourtbDto tourtbDto );
}