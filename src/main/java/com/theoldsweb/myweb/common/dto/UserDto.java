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


    private BigInteger userPhoneNumber;

    private String createTime;


    private String updateTime;

}