package com.app.cms.bb.web;

import com.app.cms.bb.dao.IN_OUT_D;
import com.app.cms.bb.entity.IN_OUT_E;
import com.app.cms.ct.entity.CT_CONTENT_TBL_E;
import com.app.cms.ct.entity.dao.CT_CONTENT_TBL_D;
import com.tools.http.MyHttpClient;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by Administrator on 14-3-1.
 */
@Controller
@RequestMapping("/bb/web")
public class IN_OUT_A {
    @Autowired
//    private IN_OUT_D ind;
    private CT_CONTENT_TBL_D cd;
//    @RequestMapping("insertI")
//    @ResponseBody
//    public void insertI() {
//        try {
//            MyHttpClient myHttpClient = new MyHttpClient();
//            byte[] result = myHttpClient.readParse("http://www.qianbao666.com/wallet/latestRechargeMore.html");
//            JSONObject jo = JSONObject.fromObject(new String(result));
//            JSONArray ja = JSONArray.fromObject(jo.get("data"));
//            System.out.println("****************************");
//            System.out.println(ja.size());
//
//            JSONObject jo_child;
//            IN_OUT_E ioe = new IN_OUT_E();
//            int size = ja.size();
//            for(int num = 0;num <size;num++){
//                jo_child = ja.getJSONObject(num);
//                ioe.setId(jo_child.getInt("id"));
//                ioe.setOp_time(jo_child.getString("time"));
//                ioe.setTel(jo_child.getString("telephone"));
//                ioe.setMoney(Float.valueOf(jo_child.getString("money").replaceAll(",", "")));
//                ioe.setOp_type("IN");
//                System.out.println(ioe.getId());
//                ind.insertIN_OUT_Case(ioe);
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
    @RequestMapping("ii")
    @ResponseBody
    public void insert() {
        try{

        System.out.println("****************************");

        System.out.println(cd.countAll());
    } catch (Exception e) {
//            e.printStackTrace();
//        }
    }
    }
}
