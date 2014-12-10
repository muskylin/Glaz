package com.app.cms.bb.entity;

/**
 * Created by Administrator on 14-11-16.
 */
public class GetStockInfoParamBean {
    private String stock_id;
    private String date_str;

    @Override
    public String toString() {
        return "GetStockInfoParamBean{" +
                "stock_id='" + stock_id + '\'' +
                ", date_str='" + date_str + '\'' +
                '}';
    }

    public String getStock_id() {
        return stock_id;
    }

    public void setStock_id(String stock_id) {
        this.stock_id = stock_id;
    }

    public String getDate_str() {
        return date_str;
    }

    public void setDate_str(String date_str) {
        this.date_str = date_str;
    }
}
