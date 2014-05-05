package com.app.cms.bb.web;

import com.app.cms.bb.dao.IN_OUT_D;
import com.app.cms.bb.entity.IN_OUT_E;
import com.app.cms.ct.entity.CT_CONTENT_TBL_E;
import com.app.cms.ct.entity.dao.CT_CONTENT_TBL_D;
import com.tools.http.MyHttpClient;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 14-3-1.
 */
@Controller
@RequestMapping("/bb/web")
public class IN_OUT_A {
    private static final Logger logger = LoggerFactory.getLogger(IN_OUT_A.class);
    @Autowired
    private IN_OUT_D ind;
//    private CT_CONTENT_TBL_D cd;
    @RequestMapping("insertI")
    @ResponseBody
    public void insertI() {
        try {
            MyHttpClient myHttpClient = new MyHttpClient();
            byte[] result = myHttpClient.readParse("http://www.qianbao666.com/wallet/latestRechargeMore.html");
            JSONObject jo = JSONObject.fromObject(new String(result));
            JSONArray ja = JSONArray.fromObject(jo.get("data"));

            JSONObject jo_child;
            IN_OUT_E ioe = new IN_OUT_E();
            int size = ja.size();
            int count_insert = 0;
            List<Integer> idList = new ArrayList<Integer>();
            idList = ind.getIN_IDS();
//            System.out.println(idList.toString());
            for(int num = size -1;num >=0;num--){
                jo_child = ja.getJSONObject(num);
//                System.out.println(jo_child.getInt("id"));
                if(idList.contains(jo_child.getInt("id"))){

                    continue;
                }

                ioe.setId(jo_child.getInt("id"));
                ioe.setOp_time(jo_child.getString("time"));
                ioe.setTel(jo_child.getString("telephone"));
                ioe.setMoney(Float.valueOf(jo_child.getString("money").replaceAll(",", "")));
                ioe.setOp_type("IN");
                ind.insertIN_OUT_Case(ioe);
                count_insert ++;
            }
            logger.info("insert count:"+count_insert);
        } catch (Exception e) {
//            e.printStackTrace();
            logger.error(e.toString(),e);
        }
    }
    @RequestMapping("insertO")
    @ResponseBody
    public void insertO() {
        try {
            MyHttpClient myHttpClient = new MyHttpClient();
            byte[] result = myHttpClient.readParse("http://www.qianbao666.com/wallet/latestTransferMore.html");
            JSONObject jo = JSONObject.fromObject(new String(result));
            JSONArray ja = JSONArray.fromObject(jo.get("data"));

            JSONObject jo_child;
            IN_OUT_E ioe = new IN_OUT_E();
            int size = ja.size();
            int count_insert = 0;
            List<Integer> idList = new ArrayList<Integer>();
            idList = ind.getOUT_IDS();
            for(int num = size -1;num >=0;num--){

                jo_child = ja.getJSONObject(num);
                if(idList.contains(jo_child.getInt("id"))){

                    continue;
                }

                ioe.setId(jo_child.getInt("id"));
                ioe.setOp_time(jo_child.getString("time"));
                ioe.setTel(jo_child.getString("telephone"));
                ioe.setMoney(Float.valueOf(jo_child.getString("money").replaceAll(",", "")));
                ioe.setOp_type("OU");
                ind.insertIN_OUT_Case(ioe);
                count_insert ++;
            }
            logger.info("insert count:" + count_insert);
        } catch (Exception e) {
//            e.printStackTrace();
            logger.error(e.toString(),e);
        }
    }
    @RequestMapping("ii")
    @ResponseBody
    public void insert() {
        try{
logger.info("info");
            logger.error("error");
        System.out.println("****************************");

//        System.out.println(cd.countAll());
    } catch (Exception e) {
//            e.printStackTrace();
//        }
    }
    }
}
