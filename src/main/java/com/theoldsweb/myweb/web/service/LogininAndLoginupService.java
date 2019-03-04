package com.theoldsweb.myweb.web.service;

import com.theoldsweb.myweb.common.api.BeanCopyUtil;
import com.theoldsweb.myweb.common.api.DateApi;
import com.theoldsweb.myweb.common.api.RedisUtil;
import com.theoldsweb.myweb.common.config.ResultDto;
import com.theoldsweb.myweb.common.config.SysExcCode;
import com.theoldsweb.myweb.common.dto.UserDto;
import com.theoldsweb.myweb.common.entity.Usertb;
import com.theoldsweb.myweb.web.mapper.UsertbMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @描述: 简单用户登录服务  //todo 后期密文注册
 * @版权: Copyright (c) 2016-2018
 * @公司: lumi
 * @作者: 泽林
 * @创建日期: 2018-10-23
 * @创建时间: 下午4:17
 */

@Service
public class LogininAndLoginupService{
    @Autowired
    private UsertbMapper usertbMapper;
    @Autowired
    private RedisUtil redisUtil;

    /**
     * 登录
     *
     * @param userDao
     * @return
     */
    public ResultDto login( UserDto userDao ){
        Usertb usertb = new Usertb( );
        BeanCopyUtil.copy ( userDao , usertb );
        Usertb usertb1 = usertbMapper.selectOne ( usertb );
                if ( usertb1 != null ) {
                    usertb1.setUserPassword ( "*******" );
                    return new ResultDto(  SysExcCode.SysCommonExcCode.SYS_SUCCESS , "登陆成功" , usertb1 );
                } else {
                    return new ResultDto( SysExcCode.SysCommonExcCode.SYS_ERROR , "登录失败,账户名或密码错误" );
                }
            }


    /**
     * 注册
     *
     * @param userDao
     * @return
     */
    @Transactional(rollbackFor=Exception.class)
    public ResultDto logup( UserDto userDao ){
        if(checkIfExistts(userDao))
        {
            return   new ResultDto(SysExcCode.SysCommonExcCode.SYS_ERROR, "已经存在相同名字的用户");
        }
        Usertb usertb=new Usertb();
        BeanCopyUtil.copy(userDao,usertb);

        usertb.setUserId( "c"+ DateApi.getTimeId( ) );
        usertb.setCreateTime( DateApi.currentDateTime() );
        usertb.setUpdateTime( DateApi.currentDateTime() );
        int count=usertbMapper.insert(usertb);
        if(count!=0){
            return new ResultDto(SysExcCode.SysCommonExcCode.SYS_SUCCESS, "注册成功");
        }else {
            return new ResultDto(SysExcCode.SysCommonExcCode.SYS_ERROR, "注册失败");
        }

    }

    /**
     * 修改
     * @param userDao
     * @return
     */
    @Transactional(rollbackFor=Exception.class)
    public ResultDto updateByUserId( UserDto userDao ){
        if ( checkIfExistts ( userDao ) ) {
            return   new ResultDto(SysExcCode.SysCommonExcCode.SYS_ERROR, "已经存在相同名字的用户");
        }
        Usertb usertb=new Usertb();
        BeanCopyUtil.copy(userDao,usertb);
        usertb.setUpdateTime( DateApi.currentDateTime() );
        int count=usertbMapper.updateByPrimaryKeySelective(usertb);
        if(count!=0){
            return new ResultDto(SysExcCode.SysCommonExcCode.SYS_ERROR, "修改成功");
        }else {
            return new ResultDto(SysExcCode.SysCommonExcCode.SYS_ERROR, "修改失败");
        }
    }

    /**
     * 检查是否存在
     *
     * @param userDto
     * @return
     */
    private boolean checkIfExistts( UserDto userDto ){
        Usertb usertb=new Usertb();
        usertb.setUserName(userDto.getUserName());
        Usertb usertb1=usertbMapper.selectOne( usertb );
        if ( usertb1!=null ) {
            //为空代表新增
            if ( userDto.getUserId()==null ){
                return true;
            }else{
                return !usertb1.getUserId().equals( userDto.getUserId() );
            }
        }else{
            return false;
        }
    }
}