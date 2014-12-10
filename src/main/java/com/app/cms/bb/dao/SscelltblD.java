package com.app.cms.bb.dao;

import com.app.cms.bb.entity.GetStockInfoParamBean;
import com.app.cms.bb.entity.IN_OUT_E;
import com.app.cms.bb.entity.SscellhistblE;
import com.app.cms.bb.entity.StockInfo;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Administrator on 14-3-1.
 */
@Repository
@Transactional
public interface SscelltblD {
    public List<String> getAllStocks();
    public List<String> getShStocks();
    public List<String> getSzStocks();
    public List<String> getCybStocks();
    public int insertStockHis(SscellhistblE cellhis);
    public int addAllStocks(List<SscellhistblE> stockList);
    public int addOneStockrecords(List<StockInfo> stockInfoList);
    public List<StockInfo> getOneStockRecords(GetStockInfoParamBean params);


    public List<String> getAllStocks1();
    public List<String> getAllStocks2();
    public List<String> getAllStocks3();
    public List<String> getAllStocks4();
    public List<String> getAllStocks5();
}
