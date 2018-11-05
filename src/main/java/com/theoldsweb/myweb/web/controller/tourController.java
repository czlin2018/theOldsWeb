package com.theoldsweb.myweb.web.controller;

import com.qiniu.common.Constants;
import com.theoldsweb.myweb.common.api.QiniuUtil;
import com.theoldsweb.myweb.common.api.dateApi;
import com.theoldsweb.myweb.common.config.PageDto;
import com.theoldsweb.myweb.common.config.ResultDto;
import com.theoldsweb.myweb.common.config.SysExcCode;
import com.theoldsweb.myweb.common.dto.TourtbDto;
import com.theoldsweb.myweb.common.url.Url;
import com.theoldsweb.myweb.web.service.TourService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import sun.security.krb5.internal.PAData;

import java.io.FileInputStream;
import java.io.IOException;

/**
 * @描述:
 * @版权: Copyright (c) 2016-2018
 * @公司: lumi
 * @作者: 泽林
 * @创建日期: 2018-10-30
 * @创建时间: 下午12:27r
 */
@RestController
public class tourController {

    @Autowired
    private TourService toutService;
    @Autowired
    private QiniuUtil qiniuUtil;

    @GetMapping(value=Url.tour.getTourList)
    public ResultDto getTourAll ( PageDto pageDto ){
        return toutService.getTourAll(pageDto);
    }

    @PostMapping(value=Url.tour.insert)
    public ResultDto insert ( @RequestBody TourtbDto tourtbDto ){
        return toutService.insert(tourtbDto);
    }

    @PostMapping(value=Url.tour.selectByOne)
    public ResultDto selectByOne ( @RequestBody TourtbDto tourtbDto ){
        return toutService.selectByOne(tourtbDto);
    }

    /**
     * 上传文件到七牛云存储
     * @param multipartFile
     * @return
     */
    @PutMapping(value=Url.tour.imgUpload)
    public ResultDto uploadImgQiniu(@RequestParam("editormd-image-file") MultipartFile multipartFile) throws IOException{
        FileInputStream inputStream = (FileInputStream) multipartFile.getInputStream();
        String picName=dateApi.getPicTimeId( );
        String path = qiniuUtil.uploadImg(inputStream, picName);
        ResultDto resultDto=new ResultDto(  );
        resultDto.setCode( SysExcCode.SysCommonExcCode.SYS_SUCCESS );
        resultDto.setMsg( "上传成功" );
        resultDto.setData( path );
        return resultDto;
    }

}
