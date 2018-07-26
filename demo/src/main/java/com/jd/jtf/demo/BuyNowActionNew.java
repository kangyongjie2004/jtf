package com.jd.jtf.demo;

import com.alibaba.fastjson.JSONObject;
import com.jd.jtf.demo.plugin.order.OrderInfo;
import com.jd.jtf.demo.plugin.order.inter.ITocService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/jtf")
public class BuyNowActionNew {

    @ResponseBody
    @RequestMapping("/buy_general")
    public JSONObject handleRequest() {

        OrderInfo oi = new OrderInfo();

        oi.setBusinessType("fresh");
        ITocService iTocService = oi.getAdapter(ITocService.class);

        int timeout = iTocService.getTimeout();

        JSONObject jo = new JSONObject();

//        jo.put("confignment_timeout", 10);
//        jo.put("confirm_timeout", 20);
        jo.put("timeout", timeout);

        return jo;
    }
}