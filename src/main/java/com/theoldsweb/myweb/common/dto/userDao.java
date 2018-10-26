package com.theoldsweb.myweb.common.dto;
import lombok.Data;
import java.util.Date;

@Data
public class userDao {

    private Integer id;


    private String userId;

    private String userName;


    private String userPassword;


    private Integer userPhoneNumber;

    private Date createTime;


    private Date updateTime;

}