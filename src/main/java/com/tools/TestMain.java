package com.tools;


import com.app.cms.bb.service.impl.StockFunc;

import java.math.BigDecimal;
import java.math.MathContext;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 14-10-16.
 */
public class TestMain {
    public static void main(String[] args){
//        SchemeRegistry schemeRegistry = new SchemeRegistry();
//        schemeRegistry.register(new Scheme("http", 80, PlainSocketFactory.getSocketFactory()));
//        schemeRegistry.register(new Scheme("https", 443, SSLSocketFactory.getSocketFactory()));
//        PoolingClientConnectionManager cm = new PoolingClientConnectionManager(schemeRegistry);
//        cm.setMaxTotal(200);
//        cm.setDefaultMaxPerRoute(2);
//        HttpHost googleResearch = new HttpHost("research.google.com", 80);
//        HttpHost wikipediaEn = new HttpHost("en.wikipedia.org", 80);
//        cm.setMaxPerRoute(new HttpRoute(googleResearch), 30);
//        cm.setMaxPerRoute(new HttpRoute(wikipediaEn), 50);

//        StockFunc func = new StockFunc();
//        System.out.println(func.computerAdjPrice(17.64,8.82,17.68));
        List<String> list=new ArrayList<String>();
        list.add("保护环境");     //向列表中添加数据
        list.add("爱护地球");     //向列表中添加数据
        list.add("从我做起");        //向列表中添加数据
        list.add(0,"我加");     //在第1+1个元素的位置添加数据
        //通过循环输出列表中的内容
        for(int i=0;i<list.size();i++){
            System.out.println(i+":"+list.get(i));
        }
    }
}
