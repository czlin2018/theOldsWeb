package com.theoldsweb.myweb.web.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @描述:
 * @版权: Copyright (c) 2016-2018
 * @公司: lumi
 * @作者: 泽林
 * @创建日期: 2019-02-15
 * @创建时间: 17:08
 */
public class NewsService {
    public static void main( String[] arg ){

        List<Object> a = new ArrayList ( );
        a.add ( 1 );
        System.out.println ( a );
        Date time = new Date ( );
        System.out.println ( time.toString ( ) );
        System.out.println ( time.getTime ( ) );
        System.out.println ( time );
    }

}
