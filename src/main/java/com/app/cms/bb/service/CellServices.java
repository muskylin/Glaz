package com.app.cms.bb.service;

import com.app.cms.bb.entity.SscellhistblE;

import java.util.List;

/**
 * Created by Administrator on 14-10-8.
 */
public interface CellServices {
List<String> getAllStockStr();
   void getStockHis();
   void getStockHisByLimit(int num);
    void getShStockHis();
    void getSzStockHis();
    void getCybStockHis();
   int insertStockHis(SscellhistblE cellhis);
    int addAllStocks(List<SscellhistblE> stockList);
    int insertStockHisInfo(String stock_str);
    void getOneStockRecords(String stock_id);
    void getShot();
}
