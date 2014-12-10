package com.app.cms.bb.entity;



/**
 * Created by Administrator on 14-3-1.
 */
public class SscellhistblE {

    private String cell_id;

    private String cell_dat;
    private double open_prc;
    private double high_prc;
    private  double low_prc;
    private double close_prc;
    private int volume_num;
    private double adjc_prc;

    public String getCell_id() {
        return cell_id;
    }

    public void setCell_id(String cell_id) {
        this.cell_id = cell_id;
    }


    public String getCell_dat() {
        return cell_dat;
    }

    public void setCell_dat(String cell_dat) {
        this.cell_dat = cell_dat;
    }

    public double getOpen_prc() {
        return open_prc;
    }

    public void setOpen_prc(double open_prc) {
        this.open_prc = open_prc;
    }

    public double getHigh_prc() {
        return high_prc;
    }

    public void setHigh_prc(double high_prc) {
        this.high_prc = high_prc;
    }

    public double getLow_prc() {
        return low_prc;
    }

    public void setLow_prc(double low_prc) {
        this.low_prc = low_prc;
    }

    public double getClose_prc() {
        return close_prc;
    }

    public void setClose_prc(double close_prc) {
        this.close_prc = close_prc;
    }

    public int getVolume_num() {
        return volume_num;
    }

    public void setVolume_num(int volume_num) {
        this.volume_num = volume_num;
    }

    public double getAdjc_prc() {
        return adjc_prc;
    }

    public void setAdjc_prc(double adjc_prc) {
        this.adjc_prc = adjc_prc;
    }
}
