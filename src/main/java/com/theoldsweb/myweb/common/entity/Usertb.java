package com.theoldsweb.myweb.common.entity;

import lombok.Data;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;
import javax.persistence.*;

@Data
@Table(name = "user_tb")
public class Usertb implements Serializable{
    private Integer id;
    /**
     * @Id设置为主键
     */
    @Id
    @Column(name = "user_id")
    private String userId;

    @Column(name = "user_name")
    private String userName;

    @Column(name = "user_password")
    private String userPassword;

    @Column(name = "user_phone_number")
    private BigInteger userPhoneNumber;

    @Column(name = "create_time")
    private Date createTime;

    @Column(name = "update_time")
    private Date updateTime;
}