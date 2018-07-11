package com.jd.jtf.route;

import com.alibaba.fastjson.JSONObject;
import com.jd.jtf.domain.order.IOrder;
import com.jd.jtf.toc.Toc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/jtf")
public class BuyNowAction {


    @Autowired
    private IOrder order;


    @ResponseBody
    @RequestMapping("/toc")
    public JSONObject handleRequest(String type) {

        order.setType(type);

        //toc接口通过order的getAdapter的方式返回，在上面toc模快里TocAdapterFactory里，
        // 解释了会根据order的type类型，返回对应的实现，这里会返回GenrealToc的实现。
        Toc toc = (Toc) order.getAdapter(Toc.class);

        if (toc != null) {
            toc.setOrderConfirmTimeout(order);
            toc.setOrderConsignmentTimeout(order);
        }

//        Ump ump = (Ump)order.getAdapter(Ump.class);
//        if (ump!=null) {
//            ump.setOrderPromation(order);
//        }

        int consignment_timeout = toc.getOrderConsignmentTimeout(order);
        int confirm_timeout = toc.getOrderConfirmTimeout(order);

//        float promotion = ump.getOrderPromation(order);

        JSONObject jo = new JSONObject();

        jo.put("type", type);
        jo.put("confignment_timeout", consignment_timeout);
        jo.put("confirm_timeout", confirm_timeout);
//        jo.put("promotion",promotion);

        return jo;
    }
}