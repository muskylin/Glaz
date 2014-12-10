package com.app.cms.bb.service.impl;

import com.app.cms.bb.dao.SscelltblD;
import com.app.cms.bb.entity.GetStockInfoParamBean;
import com.app.cms.bb.entity.SscellhistblE;
import com.app.cms.bb.entity.StockInfo;
import com.app.cms.bb.service.CellServices;
import com.tools.http.MyHttpClient;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 14-10-8.
 */
@Service
public class CellServiceImpl implements CellServices {
    private static final Logger logger = LoggerFactory.getLogger(CellServiceImpl.class);
    @Autowired
    private SscelltblD celltbl;


    public List<String> getAllStockStr() {
        try {
            return celltbl.getAllStocks();
        } catch (Exception e) {
            logger.error(e.toString(), e);
            return null;
        }
    }

    public int insertStockHis(SscellhistblE cellhis) {
        try {
            return celltbl.insertStockHis(cellhis);
        } catch (Exception e) {
            logger.error(e.toString(), e);
            return 0;
        }
    }

    public int addAllStocks(List<SscellhistblE> stockList) {
        try {
            return celltbl.addAllStocks(stockList);
        } catch (Exception e) {
            logger.error(e.toString(), e);
            return 0;
        }
    }

    public void getStockHis() {
        int all_num = 0;
        int success_num = 0;
        int fail_num = 0;
        int ret = 0;
        try {
            List<String> cList = new ArrayList<String>();
            cList = getAllStockStr();
            all_num = cList.size();
//            System.out.println(cList.get(10));
            for (int i = 0; i < 500; i++) {

                ret = insertStockHisInfo(cList.get(i));
                if (ret == 1) {
                    success_num++;
                } else {
                    fail_num++;
                }
            }
            logger.info("insert success.all_num:" + all_num + ";success_num:" + success_num + ";fail_num:" + fail_num);
        } catch (Exception e) {
//            e.printStackTrace();
            logger.error(e.toString(), e);
        }
    }
    public void getStockHisByLimit(int num) {
        int all_num = 0;
        int success_num = 0;
        int fail_num = 0;
        int ret = 0;
        try {
            List<String> cList = new ArrayList<String>();
            if (num == 1){
                cList = celltbl.getAllStocks1();
            }
            if (num == 2){
                cList = celltbl.getAllStocks2();
            }
            if (num == 3){
                cList = celltbl.getAllStocks3();
            }
            if (num == 4){
                cList = celltbl.getAllStocks4();
            }
            if (num == 5){
                cList = celltbl.getAllStocks5();
            }
//            cList = getAllStockStr();
            all_num = cList.size();
//            System.out.println(cList.get(10));
            for (int i = 0; i < cList.size(); i++) {

                ret = insertStockHisInfo(cList.get(i));
                if (ret == 1) {
                    success_num++;
                } else {
                    fail_num++;
                }
            }
            logger.info("insert success.all_num:" + all_num + ";success_num:" + success_num + ";fail_num:" + fail_num);
        } catch (Exception e) {
//            e.printStackTrace();
            logger.error(e.toString(), e);
        }
    }
    public void getShStockHis() {
        int all_num = 0;
        int success_num = 0;
        int fail_num = 0;
        int ret = 0;
        try {
            List<String> cList = new ArrayList<String>();
            cList = celltbl.getShStocks();
            all_num = cList.size();
            for (int i = 0; i < cList.size(); i++) {
                ret = insertStockHisInfo(cList.get(i) + ".SS");
                if (ret == 1) {
                    success_num++;
                } else {
                    fail_num++;
                }
            }
            logger.info("insert shanghai's stocks success.all_num:" + all_num + ";success_num:" + success_num + ";fail_num:" + fail_num);
        } catch (Exception e) {
            logger.error("There are some wrong:" + e);
        }
    }

    public void getSzStockHis() {
        int all_num = 0;
        int success_num = 0;
        int fail_num = 0;
        int ret = 0;
        try {
            List<String> cList = new ArrayList<String>();
            cList = celltbl.getSzStocks();
            all_num = cList.size();
            for (int i = 0; i < cList.size(); i++) {
                ret = insertStockHisInfo(cList.get(i) + ".SZ");
                if (ret == 1) {
                    success_num++;
                } else {
                    fail_num++;
                }
            }
            logger.info("insert shenzheng's stocks success.all_num:" + all_num + ";success_num:" + success_num + ";fail_num:" + fail_num);
        } catch (Exception e) {
            logger.error("There are some wrong:" + e);
        }
    }

    public void getCybStockHis() {
        int all_num = 0;
        int success_num = 0;
        int fail_num = 0;
        int ret = 0;
        try {
            List<String> cList = new ArrayList<String>();
            cList = celltbl.getCybStocks();
            all_num = cList.size();
            for (int i = 0; i < cList.size(); i++) {
                ret = insertStockHisInfo(cList.get(i) + ".SZ");
                if (ret == 1) {
                    success_num++;
                } else {
                    fail_num++;
                }
            }
            logger.info("insert chuangyeban's stocks success.all_num:" + all_num + ";success_num:" + success_num + ";fail_num:" + fail_num);
        } catch (Exception e) {
            logger.error("There are some wrong:" + e);
        }
    }

    public int insertStockHisInfo(String stock_str) {
        int ret = 0;
        if (stock_str == null || stock_str.equals("")) {
            logger.error("paramter is null!");
            return ret;
        }

        logger.info("stock_str"+stock_str);
        CloseableHttpClient httpclient = HttpClients.createDefault();
        String[] sArray = null;
        String[] stockAarry = null;
        String stock = null;
        try {
            List<SscellhistblE> stockList = new ArrayList<SscellhistblE>();
            stock = stock_str.substring(0, 6);
            HttpGet httpget = new HttpGet("http://ichart.finance.yahoo.com/table.csv?s=" + stock_str
//                    + "&d=7&e=23&f=2014&a=5&b=11&c=2014"
                    );
            StockFunc func = new StockFunc();
//            System.out.println("Executing request " + httpget.getRequestLine());

            // Create a custom response handler
            ResponseHandler<String> responseHandler = new ResponseHandler<String>() {

                public String handleResponse(
                        final HttpResponse response) throws ClientProtocolException, IOException {
                    int status = response.getStatusLine().getStatusCode();
                    if (status >= 200 && status < 300) {
                        HttpEntity entity = response.getEntity();
                        return entity != null ? EntityUtils.toString(entity) : null;
                    } else {
                        throw new ClientProtocolException("Unexpected response status: " + status);
                    }
                }

            };
            String responseBody = httpclient.execute(httpget, responseHandler);
//            System.out.println("responseBody = [" + responseBody + "]");
            sArray = responseBody.split("\\n");
            for (int j = 1; j < sArray.length; j++) {

                stockAarry = sArray[j].split(",");
                if (Integer.valueOf(stockAarry[5]) == 0){
                    continue;
                }
                SscellhistblE cellhis = new SscellhistblE();
                cellhis.setCell_id(stock);
                cellhis.setCell_dat(stockAarry[0]);
                cellhis.setOpen_prc(func.computerAdjPrice(Double.valueOf(stockAarry[4]), Double.valueOf(stockAarry[6]), Double.valueOf(stockAarry[1])));
                cellhis.setHigh_prc(func.computerAdjPrice(Double.valueOf(stockAarry[4]), Double.valueOf(stockAarry[6]), Double.valueOf(stockAarry[2])));
                cellhis.setLow_prc(func.computerAdjPrice(Double.valueOf(stockAarry[4]), Double.valueOf(stockAarry[6]), Double.valueOf(stockAarry[3])));
                cellhis.setClose_prc(func.computerAdjPrice(Double.valueOf(stockAarry[4]), Double.valueOf(stockAarry[6]), Double.valueOf(stockAarry[4])));
//                cellhis.setHigh_prc(Float.valueOf(stockAarry[2]));
//                cellhis.setLow_prc(Float.valueOf(stockAarry[3]));
//                cellhis.setClose_prc(Float.valueOf(stockAarry[4]));
                cellhis.setVolume_num(Integer.valueOf(stockAarry[5]));
                cellhis.setAdjc_prc(Double.valueOf(stockAarry[6]));
//                ret_insert = celltbl.insertStockHis(cellhis);
//                if (ret_insert == 0){
//
//                    logger.error("It's wrong!insert failed");
//                    break;
//
//                }
                stockList.add(cellhis);


            }
//            System.out.println("stockList = [" + stockList.size() + "]");
            celltbl.addAllStocks(stockList);
            ret = 1;
        } catch (Exception e) {
            logger.error(e.toString(), e);
//            logger.error("errorstock:" + stock);
        } finally {

            try {
                httpclient.close();
            } catch (Exception e1) {
                logger.error(e1.toString(), e1);
            }
        }


        //old insert process
//        String[] sArray = null;
//        int ret_insert = 0;
//        String stock = null;
//        try {
//
//
//            List<SscellhistblE> stockList = new ArrayList<SscellhistblE>();
//            List<String> strList = new ArrayList<String>();
//
//
//            String[] stockArray = stock_str.split(".");
//            stock = stock_str.substring(0, 6);
////            byte[] result = MyHttpClient.readParse("http://ichart.finance.yahoo.com/table.csv?s="+stock_str+"&d=7&e=23&f=2014&a=5&b=11&c=2014");
////            String s_result = new String(result);
////            sArray = s_result.split("\\n");
//
//            strList = MyHttpClient.sendGet("http://ichart.finance.yahoo.com/table.csv?s=" + stock_str + "&d=7&e=23&f=2014&a=5&b=11&c=2014");
//            if (strList == null) {
//                return ret;
//            }
//            String[] stockAarry = null;
//            for (int j = 1; j < strList.size(); j++) {
//
//                stockAarry = strList.get(j).split(",");
//                SscellhistblE cellhis = new SscellhistblE();
//                cellhis.setCell_id(stock);
//                cellhis.setCell_dat(stockAarry[0]);
//                cellhis.setOpen_prc(Float.valueOf(stockAarry[1]));
//                cellhis.setHigh_prc(Float.valueOf(stockAarry[2]));
//                cellhis.setLow_prc(Float.valueOf(stockAarry[3]));
//                cellhis.setClose_prc(Float.valueOf(stockAarry[4]));
//                cellhis.setVolume_num(Integer.valueOf(stockAarry[5]));
//                cellhis.setAdjc_prc(Float.valueOf(stockAarry[6]));
////                ret_insert = celltbl.insertStockHis(cellhis);
////                if (ret_insert == 0){
////
////                    logger.error("It's wrong!insert failed");
////                    break;
////
////                }
//                stockList.add(cellhis);
//
//
//            }
//            celltbl.addAllStocks(stockList);
//            ret = 1;
////            logger.info("*****************************");
////            logger.info("多少条？"+stockList.size());
////            logger.info("insert success.stock name:"+stock);
//        } catch (Exception e) {
////            e.printStackTrace();
////            logger.error(e.toString(), e);
//            logger.error("errorstock:" + stock);
//        }
        return ret;
    }

    public void getOneStockRecords(String stock_id){
        int ret = 0;
try{
    if (stock_id == null || stock_id.equals("")){
        return;
    }
    StockFunc func = new StockFunc();
    List<StockInfo> stockInfos = new ArrayList<StockInfo>();
    GetStockInfoParamBean params = new GetStockInfoParamBean();
    params.setStock_id(stock_id);
    params.setDate_str("2014-11-15");
    stockInfos = celltbl.getOneStockRecords(params);
if (stockInfos.size() <=0){
    logger.info(stock_id +"has nothing!");
    return;
}
    //计算均线

stockInfos = func.computeMA(stockInfos);
    //计算macd相关

    //根据算法计算
//stockInfos = func.computeMyAlgorithm(stockInfos);


//        System.out.println(stockInfos.get(0).toString());

ret = celltbl.addOneStockrecords(stockInfos);
if (ret > 0){
    logger.info("records add success!");
}
} catch (Exception e) {
            logger.error(e.toString(),e);
}
finally{

}
    }
    public void getShot() {

        int ret = 0;
        try {
            List<String> cList = new ArrayList<String>();
            cList = celltbl.getSzStocks();

            for (int i = 0; i < cList.size(); i++) {
                getOneStockRecords(cList.get(i));

            }

        } catch (Exception e) {
            logger.error("There are some wrong:" + e);
        }
    }
}
//根据历史记录获取每个股票的list，并按时间排序
//新增股票历史记录附属信息表，每天循环计算当天的关键信息，包括：diff、macd、5日均线、10日均线、20日均线等
//1、计算颈线值（较为复杂）；2、趋势线值；
//根据当前值判定是否状态变化
