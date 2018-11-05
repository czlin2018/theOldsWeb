package com.theoldsweb.myweb.web.service;

import com.theoldsweb.myweb.common.api.BeanCopyUtil;
import com.theoldsweb.myweb.common.api.dateApi;
import com.theoldsweb.myweb.common.config.ResultDto;
import com.theoldsweb.myweb.common.dto.userDto;
import com.theoldsweb.myweb.common.entity.usertb;
import com.theoldsweb.myweb.web.mapper.usertbMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @描述:
 * @版权: Copyright (c) 2016-2018
 * @公司: lumi
 * @作者: 泽林
 * @创建日期: 2018-10-23
 * @创建时间: 下午4:17
 */

@Service
public class LogininAndLoginupService {
    @Autowired
    private usertbMapper usertbMapper;
/**
 * 登陆
 */

    public ResultDto login( userDto userDao){
        usertb usertb=new usertb();
        BeanCopyUtil.copy(userDao,usertb);
        try {
            usertb usertb1=usertbMapper.selectOne( usertb );

            if(usertb1!=null){
                return new ResultDto(0, "登陆成功",usertb1);
            }else {
                return new ResultDto(0, "登录失败");
            }

        }catch (Exception e){
            return new ResultDto(0, "登录失败");
        }


    }
/**
 * 注册
 */

    public ResultDto logup( userDto userDao){
        if(checkIfExistts(userDao))
        {
            return   new ResultDto(0, "已经存在相同名字的用户");
        }
        usertb usertb=new usertb();
        BeanCopyUtil.copy(userDao,usertb);

        usertb.setUserId( "c"+dateApi.getTimeId( ) );
        usertb.setCreateTime( dateApi.currentDateTime() );
        usertb.setUpdateTime( dateApi.currentDateTime() );
        int count=usertbMapper.insert(usertb);
        if(count!=0){
            return new ResultDto(0, "注册成功");
        }else {
            return new ResultDto(0, "注册失败");
        }

    }
    /**
     * 修改
     */
    public ResultDto updateByUserId( userDto userDao){
        if(checkIfExistts(userDao))
        {
            return   new ResultDto(0, "已经存在相同名字的用户");
        }
        usertb usertb=new usertb();
        BeanCopyUtil.copy(userDao,usertb);
        usertb.setUpdateTime( dateApi.currentDateTime() );
        int count=usertbMapper.updateByPrimaryKeySelective(usertb);
        if(count!=0){
            return new ResultDto(0, "修改成功");
        }else {
            return new ResultDto(0, "修改失败");
        }
    }

    private boolean checkIfExistts( userDto userDto ){
        usertb usertb=new usertb();
        usertb.setUserName(userDto.getUserName());
        usertb usertb1=usertbMapper.selectOne( usertb );
        if ( usertb1!=null ) {
            //为空代表新增
            if ( userDto.getUserId()==null )
                return true;
            else
                return !usertb1.getUserId().equals( userDto.getUserId() );
        }else
            return false;
    }
}