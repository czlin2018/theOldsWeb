package com.theoldsweb.myweb.web;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import tk.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan(basePackages = "com.theoldsweb.myweb.web.mapper")
@SpringBootApplication
public class MywebApplication {

    public static void main(String[] args){
        SpringApplication.run(MywebApplication.class,args);
    }


}