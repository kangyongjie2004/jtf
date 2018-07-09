package com.jd.jtf.lifeservice.action;//package com.jd.jtf.lifeservice.action;


import com.alibaba.fastjson.JSONObject;
import com.jd.jtf.domain.order.Order;
import com.jd.jtf.toc.Toc;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/jtf")
public class LifeserviceBuyNowAction {
    @ResponseBody
    @RequestMapping("/buy_general")
    public JSONObject handleRequest() {


        Order order = new Order("lifeservice", 1);
        Toc toc = (Toc) order.getAdapter(Toc.class);
        toc.setOrderConfirmTimeout(order);
        toc.setOrderConsignmentTimeout(order);

        int consignment_timeout = toc.getOrderConsignmentTimeout(order);
        int confirm_timeout = toc.getOrderConfirmTimeout(order);

        JSONObject jo = new JSONObject();

        jo.put("confignment_timeout", consignment_timeout);
        jo.put("confirm_timeout", confirm_timeout);
//        jo.put("promotion",promotion);

        return jo;

    }
}
