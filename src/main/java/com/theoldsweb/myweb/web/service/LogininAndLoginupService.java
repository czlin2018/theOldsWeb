package com.theoldsweb.myweb.web.service;

import com.theoldsweb.myweb.common.api.BeanCopyUtil;
import com.theoldsweb.myweb.common.api.DateApi;
import com.theoldsweb.myweb.common.api.RedisUtil;
import com.theoldsweb.myweb.common.config.ResultDto;
import com.theoldsweb.myweb.common.dto.userDto;
import com.theoldsweb.myweb.common.entity.usertb;
import com.theoldsweb.myweb.web.mapper.usertbMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
    @Autowired
    private RedisUtil redisUtil;
/**
 * 登陆
 */

    public ResultDto login( userDto userDao){
        //查看缓存
        usertb usertb2=(usertb) redisUtil.find(userDao.getUserName() );
        if ( usertb2 == null ) {

            usertb usertb=new usertb( );
            BeanCopyUtil.copy( userDao , usertb );
            try {
                usertb usertb1=usertbMapper.selectOne( usertb );
                redisUtil.register(usertb1.getUserName() , usertb1);
                if ( usertb1 != null ) {
                    return new ResultDto( 0 , "登陆成功" , usertb1 );
                } else {
                    return new ResultDto( 0 , "登录失败" );
                }

            } catch (Exception e) {
                return new ResultDto( 0 , "登录失败" );
            }
        }
         return new ResultDto( 0 , "登陆成功" , usertb2 );
    }
/**
 * 注册
 */
    @Transactional(rollbackFor=Exception.class)
    public ResultDto logup( userDto userDao){
        if(checkIfExistts(userDao))
        {
            return   new ResultDto(0, "已经存在相同名字的用户");
        }
        usertb usertb=new usertb();
        BeanCopyUtil.copy(userDao,usertb);

        usertb.setUserId( "c"+ DateApi.getTimeId( ) );
        usertb.setCreateTime( DateApi.currentDateTime() );
        usertb.setUpdateTime( DateApi.currentDateTime() );
        int count=usertbMapper.insert(usertb);
        if(count!=0){
            redisUtil.register(usertb.getUserName() , usertb);
            return new ResultDto(0, "注册成功");
        }else {
            return new ResultDto(0, "注册失败");
        }

    }
    /**
     * 修改
     */
    @Transactional(rollbackFor=Exception.class)
    public ResultDto updateByUserId( userDto userDao){
        if(checkIfExistts(userDao))
        {
            return   new ResultDto(0, "已经存在相同名字的用户");
        }
        usertb usertb=new usertb();
        BeanCopyUtil.copy(userDao,usertb);
        usertb.setUpdateTime( DateApi.currentDateTime() );
        int count=usertbMapper.updateByPrimaryKeySelective(usertb);
        if(count!=0){
            redisUtil.register(usertb.getUserName() , usertb);
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