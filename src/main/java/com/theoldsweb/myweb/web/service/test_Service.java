package com.theoldsweb.myweb.web.service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.theoldsweb.myweb.common.config.SysExcCode;
import com.theoldsweb.myweb.common.dto.PageDto;
import com.theoldsweb.myweb.common.dto.ResultDto;
import com.theoldsweb.myweb.common.entity.test_user;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @描述:
 * @版权: Copyright (c) 2016-2018
 * @公司: lumi
 * @作者: 泽林
 * @创建日期: 2018-10-19
 * @创建时间: 下午4:01
 */
@Service
public class test_Service {

    public static ResultDto get(PageDto pageDto){
//        数据获取
        test_user test_user=new test_user();
        test_user.setId(1);
        test_user.setName("泽林");
        List reasonList=new ArrayList();
        reasonList.add(test_user);
//        结果类封装
        Page<Object> objectPage = PageHelper.startPage(pageDto.getPageNo(), pageDto.getPageSize());
        pageDto.setTotalCount(objectPage.getTotal());
        pageDto.setPageData(reasonList);
        return new ResultDto(SysExcCode.SysCommonExcCode.SYS_SUCCESS, pageDto);

    }
}