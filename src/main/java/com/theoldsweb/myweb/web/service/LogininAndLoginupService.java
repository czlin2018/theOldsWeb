package com.theoldsweb.myweb.web.service;

import com.theoldsweb.myweb.common.api.BeanCopyUtil;
import com.theoldsweb.myweb.common.api.DateApi;
import com.theoldsweb.myweb.common.api.RedisUtil;
import com.theoldsweb.myweb.common.config.PageDto;
import com.theoldsweb.myweb.common.config.ResultDto;
import com.theoldsweb.myweb.common.config.SysExcCode;
import com.theoldsweb.myweb.common.dto.*;
import com.theoldsweb.myweb.common.entity.Usertb;
import com.theoldsweb.myweb.web.controller.common.SendEmail;
import com.theoldsweb.myweb.web.mapper.UsertbMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    private ActivityService activityService;

    @Autowired
    private LoveService loveService;

    @Autowired
    private VideoService videoService;

    @Autowired
    private TourService tourService;

    @Autowired
    private UsertbMapper usertbMapper;

    @Autowired
    private RedisUtil redisUtil;


    /**
     * 获得验证码
     *
     * @param userId 用户id (邮箱)
     * @return
     */
    public ResultDto getVerificationCode( String userId ){
        String verificationCode = DateApi.getTimeId ( );

        //注册在redis
        redisUtil.register ( userId , verificationCode );

        //发送电子邮件
        try {
            SendEmail.send ( userId , verificationCode );
        } catch (GeneralSecurityException e) {
            return new ResultDto ( SysExcCode.SysCommonExcCode.SYS_ERROR , "获取失败" );
        }
        return new ResultDto ( SysExcCode.SysCommonExcCode.SYS_SUCCESS , verificationCode );

    }


    /**
     * 首页
     *
     * @return
     */
    public ResultDto index( ){
        List result = new ArrayList ( );
        Map<String, Object> map = new HashMap<> ( );

        //获取活动
        map = new HashMap<> ( );
        map.put ( "name" , "activity" );
        PageDto pageDto = new PageDto ( );
        ActivityDto activityDto = new ActivityDto ( );
        PageDto data = (PageDto) activityService.getList ( pageDto , activityDto ).getData ( );
        map.put ( "values" , data.getPageData ( ) );
        result.add ( map );

        //获取社区
        map = new HashMap<> ( );
        map.put ( "name" , "love" );
        pageDto = new PageDto ( );
        LoveDto loveDto = new LoveDto ( );
        data = (PageDto) loveService.getList ( pageDto , loveDto ).getData ( );
        map.put ( "values" , data.getPageData ( ) );
        result.add ( map );


        //获取视频
        map = new HashMap<> ( );
        map.put ( "name" , "video" );
        pageDto = new PageDto ( );
        VideoDto videoDto = new VideoDto ( );
        data = (PageDto) videoService.getList ( pageDto , videoDto ).getData ( );
        map.put ( "values" , data.getPageData ( ) );
        result.add ( map );

        //获取旅游
        map = new HashMap<> ( );
        map.put ( "name" , "tour" );
        pageDto = new PageDto ( );
        TourtbDto tourtbDto = new TourtbDto ( );
        data = (PageDto) tourService.getTourAll ( pageDto , tourtbDto ).getData ( );
        map.put ( "values" , data.getPageData ( ) );
        result.add ( map );

        return new ResultDto ( SysExcCode.SysCommonExcCode.SYS_SUCCESS , "获取成功" , result );

    }



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

        usertb.setUserId ( userDao.getUserId ( ) );
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
     * 修改
     *
     * @param userDto
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    public ResultDto forget( UserDto userDto ){
        //从redis取得验证码,判断验证码是否正确
        Object verificationCode = redisUtil.find ( userDto.getUserId ( ) );
        if ( ! userDto.getVerificationCode ( ).equals ( verificationCode ) ) {
            return new ResultDto ( SysExcCode.SysCommonExcCode.SYS_ERROR , "验证码输入不正确" );
        }

        Usertb usertb = new Usertb ( );
        BeanCopyUtil.copy ( userDto , usertb );
        usertb.setUpdateTime ( DateApi.currentDateTime ( ) );
        int count = usertbMapper.updateByPrimaryKeySelective ( usertb );
        if ( count != 0 ) {
            return new ResultDto ( SysExcCode.SysCommonExcCode.SYS_ERROR , "修改成功" );
        } else {
            return new ResultDto ( SysExcCode.SysCommonExcCode.SYS_ERROR , "修改失败" );
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