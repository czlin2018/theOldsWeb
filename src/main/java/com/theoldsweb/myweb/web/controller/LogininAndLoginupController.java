package com.theoldsweb.myweb.web.controller;

import com.theoldsweb.myweb.common.config.ResultDto;
import com.theoldsweb.myweb.common.dto.userDao;
import com.theoldsweb.myweb.common.url.Url;
import com.theoldsweb.myweb.web.service.LogininAndLoginupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @描述:
 * @版权: Copyright (c) 2016-2018
 * @公司: lumi
 * @作者: 泽林
 * @创建日期: 2018-10-23
 * @创建时间: 下午4:14
 */
@RestController
public class LogininAndLoginupController {

    @Autowired
    private LogininAndLoginupService logininAndLoginupService;
    /**
     * 登陆
     */
    @PostMapping(Url.user.login)
    public ResultDto loginIn  (@RequestBody userDao userDao){
        return logininAndLoginupService.login(userDao);
    }
    /**
     * 注册
     */

    @PostMapping(Url.user.logUp)
        public ResultDto loginUp  (@RequestBody userDao userDao){
        return logininAndLoginupService.logup(userDao);
    }
    /**
     * 修改(密码)
     */
    @PostMapping(Url.user.update)
    public ResultDto updateByUserId  (@RequestBody userDao userDao){
        return logininAndLoginupService.updateByUserId(userDao);
    }
}