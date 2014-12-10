package com.app.cms.bb.entity;

import java.util.Date;

/**
 * Created by Administrator on 14-11-9.
 */
public class StockNirv {
    private int seq;
    private String stock;
    private Date date;
    private int strategyNum;
    private double shotPrice;
    private double stopProfitPrice;
    private double stopLossPrice;

    @Override
    public String toString() {
        return "StockNirv{" +
                "seq=" + seq +
                ", stock='" + stock + '\'' +
                ", date=" + date +
                ", strategyNum=" + strategyNum +
                ", shotPrice=" + shotPrice +
                ", stopProfitPrice=" + stopProfitPrice +
                ", stopLossPrice=" + stopLossPrice +
                '}';
    }

    public int getSeq() {
        return seq;
    }

    public void setSeq(int seq) {
        this.seq = seq;
    }

    public String getStock() {
        return stock;
    }

    public void setStock(String stock) {
        this.stock = stock;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getStrategyNum() {
        return strategyNum;
    }

    public void setStrategyNum(int strategyNum) {
        this.strategyNum = strategyNum;
    }

    public double getShotPrice() {
        return shotPrice;
    }

    public void setShotPrice(double shotPrice) {
        this.shotPrice = shotPrice;
    }

    public double getStopProfitPrice() {
        return stopProfitPrice;
    }

    public void setStopProfitPrice(double stopProfitPrice) {
        this.stopProfitPrice = stopProfitPrice;
    }

    public double getStopLossPrice() {
        return stopLossPrice;
    }

    public void setStopLossPrice(double stopLossPrice) {
        this.stopLossPrice = stopLossPrice;
    }
}
