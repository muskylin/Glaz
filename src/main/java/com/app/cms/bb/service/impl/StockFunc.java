package com.app.cms.bb.service.impl;


import com.app.cms.bb.entity.StockInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;
import java.math.MathContext;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by Administrator on 14-11-9.
 */
public class StockFunc {
    private static final Logger logger = LoggerFactory.getLogger(CellServiceImpl.class);

    public double computerAdjPrice(double closePrice, double adjPrice, double srcPrice) {
        double retPrice = 0;
        if (closePrice <= 0) {
            return retPrice;
        }
        if (closePrice == adjPrice) {
            return srcPrice;
        }
        double c = Math.round(adjPrice * srcPrice * 100 / closePrice);
//        System.out.println(c);
        retPrice = c / 100;
        return retPrice;
    }

    public List<StockInfo> computeMA(List<StockInfo> stockInfos) {
        if (stockInfos == null || stockInfos.size() == 0) {
            return null;
        }
        double total = 0;
        double ave = 0;
        try {
            double c = 0;
            int j = 0;
            int size = stockInfos.size();
            for (int i = 0; i < size; i++) {
//                logger.info(String.valueOf(i));
                total = 0;
                c = 0;
                //计算各均线
                if (i < (size - 5)) {
                    for (j = 0; j < 5; j++) {
                        total = total + stockInfos.get(i + j).getClose();
                    }
                    c = Math.round(total * 100 / 5);
                    stockInfos.get(i).setMa5(c / 100);
                }
                total = 0;
                if (i < (size - 10)) {
                    for (j = 0; j < 10; j++) {
                        total = total + stockInfos.get(i + j).getClose();
                    }
                    c = Math.round(total * 100 / 10);
                    stockInfos.get(i).setMa10(c / 100);
                }
                total = 0;
                if (i < (size - 20)) {
                    for (j = 0; j < 20; j++) {
                        total = total + stockInfos.get(i + j).getClose();
                    }
                    c = Math.round(total * 100 / 20);
                    stockInfos.get(i).setMa20(c / 100);
                }
                total = 0;
                if (i < (size - 30)) {
                    for (j = 0; j < 30; j++) {
                        total = total + stockInfos.get(i + j).getClose();
                    }
                    c = Math.round(total * 100 / 30);
                    stockInfos.get(i).setMa30(c / 100);
                }
                total = 0;
                if (i < (size - 60)) {
                    for (j = 0; j < 60; j++) {
                        total = total + stockInfos.get(i + j).getClose();
                    }
                    c = Math.round(total * 100 / 60);
                    stockInfos.get(i).setMa60(c / 100);
                }
                total = 0;
                if (i < (size - 90)) {
                    for (j = 0; j < 90; j++) {
                        total = total + stockInfos.get(i + j).getClose();
                    }
                    c = Math.round(total * 100 / 90);
                    stockInfos.get(i).setMa90(c / 100);
                }
                total = 0;
                if (i < (size - 140)) {
                    for (j = 0; j < 140; j++) {
                        total = total + stockInfos.get(i + j).getClose();
                    }
                    c = Math.round(total * 100 / 140);
                    stockInfos.get(i).setMa140(c / 100);
                }
                total = 0;

                if (i < (size - 250)) {
                    for (j = 0; j < 250; j++) {
                        total = total + stockInfos.get(i + j).getClose();
                    }
                    c = Math.round(total * 100 / 250);
                    stockInfos.get(i).setMa250(c / 100);
                }


            }
        } catch (Exception e) {
            logger.error(e.toString(), e);
        } finally {
            return stockInfos;
        }
    }

    public List<StockInfo> computeMyAlgorithm(List<StockInfo> stockInfos) {
        if (stockInfos == null || stockInfos.size() == 0) {
            return null;
        }
        double max = 0;
        double maxInScope = 0;
        int idOfMax = 0;
        int idOfMaxInScope = 0;
        double high = 0;
        int scope = 250;
        boolean fitable = true;
        double shotPrice = 0;
        double c = 0;
        double x = 0;
        double rex = 0;
double ignore_scope = 0;
double y = 0;
        double z = 0;
        try {
            //find record of max price
            for (int i = 1; i < stockInfos.size(); i++) {
                high = stockInfos.get(i).getHigh();
                if (high > max) {
                    max = high;
                    idOfMax = i;
                }
                if (i <= scope) {
                    maxInScope = high;
                    idOfMaxInScope = i;
                }
            }

            if (idOfMax < 20) {
                logger.info("fuck!!!!!!!"+stockInfos.get(0).getStock());
                return stockInfos;
            }
//            logger.info("max:"+String.valueOf(max));
//            logger.info("idOfMax:"+String.valueOf(idOfMax));
ignore_scope = 0.25*idOfMax;
            ignore_scope = Math.round(ignore_scope);

            BigDecimal bd = null;
            BigDecimal divisor = BigDecimal.ONE;
            MathContext mc = new MathContext(3);

            y = max/idOfMax;
            bd = new BigDecimal(y);
            y = bd.divide(divisor, mc).doubleValue();

            for (int i = 5; i <= (idOfMax - ignore_scope); i++) {
                high = stockInfos.get(i).getHigh();
                rex = (max - high) / (idOfMax - i);

                bd = new BigDecimal(rex);
                rex = bd.divide(divisor, mc).doubleValue();
                if (x == 0 || rex < x) {
                    x = rex;
                }
            }
            z = x/y;
//            logger.info("z:"+String.valueOf(z));
            if (z > 0.25){
                logger.info("fuck!!!!!!!"+stockInfos.get(0).getStock());
                return stockInfos;
            }
//            logger.info("x:"+String.valueOf(x));


            shotPrice = max - x*(idOfMax -1);
            logger.info(String.valueOf(stockInfos.get(0).getStock()+"'s shotPrice:"+shotPrice));
            c = Math.round(shotPrice * 100);
            shotPrice = c / 100;
            if (shotPrice > 0 && shotPrice < stockInfos.get(0).getClose()){
                for (int i = 1; i <= 5; i++) {
                    high = stockInfos.get(i).getHigh();
                    rex = (max - high) / (idOfMax - i);

                    bd = new BigDecimal(rex);
                    rex = bd.divide(divisor, mc).doubleValue();
                    if (rex < x) {
                        logger.info("假突破!!!!!!!"+stockInfos.get(0).getStock());
                        return stockInfos;
                    }
                }
                stockInfos.get(0).setAlg1(shotPrice);
                logger.info("bingo!!!!!!!");
//                logger.info("max:"+String.valueOf(max));
//            logger.info("idOfMax:"+String.valueOf(idOfMax));
//                logger.info("x:"+String.valueOf(x));
//                logger.info("y:"+String.valueOf(y));
//                logger.info("z:"+String.valueOf(z));
                logger.info(stockInfos.get(0).getStock()+"is shoted;shotprice:"+String.valueOf(shotPrice));
            }
        } catch (Exception e) {
            logger.info("max:"+String.valueOf(max));
            logger.info("idOfMax:"+String.valueOf(idOfMax));
            logger.info("rex:"+String.valueOf(rex));
            logger.error(e.toString(), e);
        } finally {
            return stockInfos;
        }
    }
}
