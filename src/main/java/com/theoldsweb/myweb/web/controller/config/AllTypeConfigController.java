package com.theoldsweb.myweb.web.controller.config;

import com.theoldsweb.myweb.common.config.ResultDto;
import com.theoldsweb.myweb.common.dto.AllTypeConfigDto;
import com.theoldsweb.myweb.common.url.Url;
import com.theoldsweb.myweb.web.service.config.AllTypeConfigService;
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
public class AllTypeConfigController {
    @Autowired
    private AllTypeConfigService allTypeConfigService;
    /**
     * 查询
     */
    @GetMapping(Url.allConfig.getList)
    public ResultDto getAreaList( AllTypeConfigDto allTypeConfigDto ){
        return allTypeConfigService.getList ( allTypeConfigDto );
    }
    /**
     * 新增
     */
    @PostMapping(Url.allConfig.insert)
    public ResultDto insert( @RequestBody AllTypeConfigDto allTypeConfigDto ){
        return allTypeConfigService.insert ( allTypeConfigDto );
    }
    /**
     * 删除
     */
    @GetMapping(Url.allConfig.delect)
    public ResultDto delect( String tourAreaId ){
        return allTypeConfigService.delect ( tourAreaId );
    }
    /**
     * 修改
     */
    @PostMapping(Url.allConfig.update)
    public ResultDto update( @RequestBody AllTypeConfigDto allTypeConfigDto ){
        return allTypeConfigService.update ( allTypeConfigDto );
    }
}
