package com.theoldsweb.myweb.common.dto;
import lombok.Data;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;

@Data
public class userDto  implements Serializable {

    private Integer id;


    private String userId;

    private String userName;


    private String userPassword;


    private BigInteger userPhoneNumber;

    private Date createTime;


    private Date updateTime;

}