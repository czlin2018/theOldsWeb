package com.theoldsweb.myweb.common.api;

import com.aliyuncs.dysmsapi.model.v20170525.QuerySendDetailsResponse;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsResponse;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.*;

/**
 * @描述:
 * @版权: Copyright (c) 2016-2018
 * @公司: lumi
 * @作者: 泽林
 * @创建日期: 2018-11-05
 * @创建时间: 下午4:35
 */
public class SmsUtilsTest {

     SmsUtils sendSms=new SmsUtils();
    @Test
    public void testSend  ( ) throws Exception
    {
        SendSmsResponse response = sendSms.sendSms("13420110632","456789");
        System.out.println(response.getCode());
        System.out.println(response.getMessage());
        QuerySendDetailsResponse qr=sendSms.querySendDetails("13420110632");
        System.out.println("该用户收到的短信条数："+qr.getTotalCount());
        for (QuerySendDetailsResponse.SmsSendDetailDTO o:qr.getSmsSendDetailDTOs())
        {
            System.out.println("发送时间："+o.getSendDate());
        }

    }
}
