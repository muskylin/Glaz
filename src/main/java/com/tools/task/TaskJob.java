package com.tools.task;

import com.app.cms.bb.web.IN_OUT_A;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * Created by Administrator on 14-3-3.
 */
@Service
public class TaskJob {
    private static final Logger logger = LoggerFactory.getLogger(TaskJob.class);
    public void collectIn(){
        try {
            IN_OUT_A ina = (IN_OUT_A) SpringUtil.getObject("IN_OUT_A");
            logger.info("collectIn's task is beginning!");
            ina.insertI();
            logger.info("collectIn's task is done!");
        }catch (Exception e){
            e.printStackTrace();

            logger.error("collectIn's task is fail!");
        }
    }
    public void collectOut(){
        try {
            IN_OUT_A ina = (IN_OUT_A) SpringUtil.getObject("IN_OUT_A");
            logger.info("collectOut's task is beginning!");
            ina.insertO();
            logger.info("collectOut's task is done!");
        }catch (Exception e){
            e.printStackTrace();

            logger.error("collectOut's task is fail!");
        }
    }
}
