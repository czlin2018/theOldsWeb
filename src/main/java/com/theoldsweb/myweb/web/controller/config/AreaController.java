package com.theoldsweb.myweb.web.controller.config;

import com.theoldsweb.myweb.common.config.PageDto;
import com.theoldsweb.myweb.common.config.ResultDto;
import com.theoldsweb.myweb.common.dto.AreaDto;
import com.theoldsweb.myweb.common.url.Url;
import com.theoldsweb.myweb.web.service.config.areaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @描述: 地址配置
 * @版权: Copyright (c) 2016-2018
 * @公司: lumi
 * @作者: 泽林
 * @创建日期: 2018-11-01
 * @创建时间: 下午12:20
 */
@RestController
public class AreaController {
    @Autowired
    private areaService areaService;
    /**
     * 查询
     */
    @GetMapping(Url.area.getAreaList)
    public ResultDto getAreaList  ( PageDto pageDto ){
        return areaService.getList(pageDto);
    }
    /**
     * 新增
     */
    @PostMapping(Url.area.insert)
    public ResultDto insert( @RequestBody AreaDto areaDto ){
        return areaService.insert( areaDto );
    }
    /**
     * 删除
     */
    @GetMapping(Url.area.delect)
    public ResultDto delect( String tourAreaId ){
        return areaService.delect ( tourAreaId );
    }
    /**
     * 修改
     */
    @PostMapping(Url.area.update)
    public ResultDto update( @RequestBody AreaDto areaDto ){
        return areaService.update( areaDto );
    }
}
