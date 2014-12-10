package com.app.cms.bb.web;

import com.app.cms.bb.dao.SscelltblD;
import com.app.cms.bb.entity.SscellhistblE;
import com.app.cms.bb.service.CellServices;
import com.tools.http.MyHttpClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.sql.Date;
import java.util.List;

/**
 * Created by Administrator on 14-9-16.
 */
@Controller
@RequestMapping("/s")
public class StockAction {
    private static final Logger logger = LoggerFactory.getLogger(StockAction.class);

    @Autowired
    private CellServices service;
    private SscelltblD ss;

    @RequestMapping("getstock")
    @ResponseBody
    public void getNowInfo() {
        try {

            String url = "http://hq.sinajs.cn/list=sh600151,sz000830,s_sh000001,s_sz399001";
            MyHttpClient myHttpClient = new MyHttpClient();
            byte[] result = myHttpClient.readParse(url);
String s_result = new String(result);

            System.out.println("********************");
            System.out.println(url);
            System.out.println(s_result);
        } catch (Exception e) {
//            e.printStackTrace();
            logger.error(e.toString(),e);
        }
    }

    @RequestMapping("getstockhisT")
    @ResponseBody
    public void getStockHisTest() {
        try {
//            MyHttpClient myHttpClient = new MyHttpClient();
            String url = "http://ichart.finance.yahoo.com/table.csv?s=300072.sz&d=7&e=23&f=2010&a=5&b=11&c=2010";
            byte[] result = MyHttpClient.readParse(url);
            String s_result = new String(result);

            System.out.println("********************");
            System.out.println(url);
            System.out.println(s_result);




        } catch (Exception e) {
//            e.printStackTrace();
            logger.error("There are some wrongs!/n"+e.getStackTrace());
        }
    }

    @RequestMapping("getstockhis")
    @ResponseBody
    public void getStockHis(int num) {
        if (num <=0){
            return;
        }
        try {
            logger.info("hh");
            service.getStockHisByLimit(num);
//            service.getStockHis();




        } catch (Exception e) {
            logger.error(e.toString(),e);
        }
    }
    @RequestMapping("sz")
    @ResponseBody
    public void getSzStockHis() {
        try {
            service.getSzStockHis();




        } catch (Exception e) {
            logger.error(e.toString(),e);
        }
    }
    @RequestMapping("sh")
    @ResponseBody
    public void getShStockHis() {
        try {
            service.getShStockHis();




        } catch (Exception e) {
            logger.error(e.toString(),e);
        }
    }
    @RequestMapping("cyb")
    @ResponseBody
    public void getCybStockHis() {
        try {
            service.getCybStockHis();




        } catch (Exception e) {
            logger.error(e.toString(),e);
        }
    }
    @RequestMapping("inserts")
    @ResponseBody
    public void inserts() {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date date = null;
        try {
             date = new java.sql.Date(format.parse("2014-09-23").getTime());
            SscellhistblE cellhis = new SscellhistblE();
            cellhis.setCell_id("000002");
            cellhis.setCell_dat("2014-09-23");
            cellhis.setOpen_prc(12);
            cellhis.setHigh_prc(12.12f);
            cellhis.setLow_prc(12);
            cellhis.setClose_prc(12);
            cellhis.setVolume_num(12);
            cellhis.setAdjc_prc(12);

           int result = service.insertStockHis(cellhis);
            System.out.println("1234"+result);


        } catch (Exception e) {
            logger.error(e.toString(),e);
        }
    }

    @RequestMapping("test")
    @ResponseBody
    public void test() {
        try {
//            service.getShot();
//            service.getOneStockRecords("000020");


        } catch (Exception e) {
            logger.error(e.toString(),e);
        }
    }
}
