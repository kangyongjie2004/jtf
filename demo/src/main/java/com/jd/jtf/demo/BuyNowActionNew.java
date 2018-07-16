package com.jd.jtf.demo;

import com.alibaba.fastjson.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/jtf")
public class BuyNowActionNew {

    @ResponseBody
    @RequestMapping("/buy_general")
    public JSONObject handleRequest() {

        JSONObject jo = new JSONObject();

        jo.put("confignment_timeout", 10);
        jo.put("confirm_timeout", 20);

        return jo;
    }
}