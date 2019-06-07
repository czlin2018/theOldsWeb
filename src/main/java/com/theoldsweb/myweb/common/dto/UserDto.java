package com.theoldsweb.myweb.common.dto;

import lombok.Data;

import java.io.Serializable;
import java.math.BigInteger;

@Data
public class UserDto implements Serializable {

    private Integer id;

    private String userId;

    private String userName;


    private String userPassword;

    /**
     * 邮箱验证码
     */
    private String verificationCode;


    private BigInteger userPhoneNumber;

    private String createTime;


    private String updateTime;

}