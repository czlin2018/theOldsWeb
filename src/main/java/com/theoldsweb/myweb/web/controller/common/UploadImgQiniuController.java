//package com.theoldsweb.myweb.web.controller.common;
//
//import com.theoldsweb.myweb.common.api.DateApi;
//import com.theoldsweb.myweb.common.api.QiniuUtil;
//import com.theoldsweb.myweb.common.config.ResultDto;
//import com.theoldsweb.myweb.common.config.SysExcCode;
//import com.theoldsweb.myweb.common.url.Url;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RestController;
//import org.springframework.web.multipart.MultipartFile;
//
//import java.io.FileInputStream;
//import java.io.IOException;
//
///**
// * @描述: 通用上传图片接口
// * @版权: Copyright (c) 2016-2018
// * @公司: lumi
// * @作者: 泽林
// * @创建日期: 2019-01-30
// * @创建时间: 14:07
// */
//@RestController
//public class UploadImgQiniuController {
//
//    @Autowired
//    private QiniuUtil qiniuUtil;
//
//    /**
//     * 上传文件到七牛云存储
//     *
//     * @param multipartFile
//     * @return ResultDto
//     */
//    @PostMapping(value = Url.img.imgUpload)
//    public ResultDto uploadImgQiniu( @RequestParam("editormd-image-file") MultipartFile multipartFile ) throws IOException{
//        FileInputStream inputStream = (FileInputStream) multipartFile.getInputStream ( );
//        String picName = DateApi.getPicTimeId ( );
//        String path = qiniuUtil.uploadImg ( inputStream , picName );
//        ResultDto resultDto = new ResultDto ( );
//        resultDto.setCode ( SysExcCode.SysCommonExcCode.SYS_SUCCESS );
//        resultDto.setMsg ( "上传成功" );
//        resultDto.setData ( path );
//        return resultDto;
//    }
//}
