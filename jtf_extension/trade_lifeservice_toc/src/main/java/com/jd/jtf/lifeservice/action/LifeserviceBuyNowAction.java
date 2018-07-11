package com.jd.jtf.lifeservice.action;//package com.jd.jtf.lifeservice.action;


import com.alibaba.fastjson.JSONObject;
import com.jd.jtf.domain.order.IOrder;
import com.jd.jtf.toc.Toc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/jtf")
public class LifeserviceBuyNowAction {


    @Autowired
    private IOrder order;

    @ResponseBody
    @RequestMapping("/buy_general")
    public JSONObject handleRequest() {

        order.setType("general");
        //toc接口通过order的getAdapter的方式返回，在上面toc模快里TocAdapterFactory里，
        // 解释了会根据order的type类型，返回对应的实现，这里会返回GenrealToc的实现。
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
