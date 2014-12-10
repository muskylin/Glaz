package com.app.cms.bb.entity;

/**
 * Created by Administrator on 14-11-9.
 */
public class StockInfo {

    private String stock;
    private String date;
    private double open;
    private double high;
    private double low;
    private double close;
    private int volume_num;
    private double ma5;
    private double ma10;
    private double ma20;
    private double ma30;
    private double ma60;
    private double ma90;
    private double ma140;
    private double ma250;
    private double diff;
    private double macd;
    private double alg1;
    private double alg2;
    private double alg3;
    private double alg4;
    private double alg5;

    @Override
    public String toString() {
        return "StockInfo{" +
                "stock='" + stock + '\'' +
                ", date='" + date + '\'' +
                ", open=" + open +
                ", high=" + high +
                ", low=" + low +
                ", close=" + close +
                ", volume_num=" + volume_num +
                ", ma5=" + ma5 +
                ", ma10=" + ma10 +
                ", ma20=" + ma20 +
                ", ma30=" + ma30 +
                ", ma60=" + ma60 +
                ", ma90=" + ma90 +
                ", ma140=" + ma140 +
                ", ma250=" + ma250 +
                ", diff=" + diff +
                ", macd=" + macd +
                ", alg1=" + alg1 +
                ", alg2=" + alg2 +
                ", alg3=" + alg3 +
                ", alg4=" + alg4 +
                ", alg5=" + alg5 +
                '}';
    }

    public String getStock() {
        return stock;
    }

    public void setStock(String stock) {
        this.stock = stock;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public double getOpen() {
        return open;
    }

    public void setOpen(double open) {
        this.open = open;
    }

    public double getHigh() {
        return high;
    }

    public void setHigh(double high) {
        this.high = high;
    }

    public double getLow() {
        return low;
    }

    public void setLow(double low) {
        this.low = low;
    }

    public double getClose() {
        return close;
    }

    public void setClose(double close) {
        this.close = close;
    }

    public int getVolume_num() {
        return volume_num;
    }

    public void setVolume_num(int volume_num) {
        this.volume_num = volume_num;
    }

    public double getMa5() {
        return ma5;
    }

    public void setMa5(double ma5) {
        this.ma5 = ma5;
    }

    public double getMa10() {
        return ma10;
    }

    public void setMa10(double ma10) {
        this.ma10 = ma10;
    }

    public double getMa20() {
        return ma20;
    }

    public void setMa20(double ma20) {
        this.ma20 = ma20;
    }

    public double getMa30() {
        return ma30;
    }

    public void setMa30(double ma30) {
        this.ma30 = ma30;
    }

    public double getMa60() {
        return ma60;
    }

    public void setMa60(double ma60) {
        this.ma60 = ma60;
    }

    public double getMa90() {
        return ma90;
    }

    public void setMa90(double ma90) {
        this.ma90 = ma90;
    }

    public double getMa140() {
        return ma140;
    }

    public void setMa140(double ma140) {
        this.ma140 = ma140;
    }

    public double getMa250() {
        return ma250;
    }

    public void setMa250(double ma250) {
        this.ma250 = ma250;
    }

    public double getDiff() {
        return diff;
    }

    public void setDiff(double diff) {
        this.diff = diff;
    }

    public double getMacd() {
        return macd;
    }

    public void setMacd(double macd) {
        this.macd = macd;
    }

    public double getAlg1() {
        return alg1;
    }

    public void setAlg1(double alg1) {
        this.alg1 = alg1;
    }

    public double getAlg2() {
        return alg2;
    }

    public void setAlg2(double alg2) {
        this.alg2 = alg2;
    }

    public double getAlg3() {
        return alg3;
    }

    public void setAlg3(double alg3) {
        this.alg3 = alg3;
    }

    public double getAlg4() {
        return alg4;
    }

    public void setAlg4(double alg4) {
        this.alg4 = alg4;
    }

    public double getAlg5() {
        return alg5;
    }

    public void setAlg5(double alg5) {
        this.alg5 = alg5;
    }
}

