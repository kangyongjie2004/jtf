package com.jd.jtf.route;

import com.alibaba.fastjson.JSONObject;
import com.jd.jtf.domain.bean.OrderInfo;
import com.jd.jtf.domain.order.IOrderService;
import com.jd.jtf.toc.plugin.TocService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/jtf")
public class BuyNowAction {


    @Autowired
    private IOrderService orderService;


    @ResponseBody
    @RequestMapping("/toc")
    public JSONObject handleRequest(String type) {



        OrderInfo orderInfo = orderService.getOrderInfo("111", type);
        orderService.setBusinessType(orderInfo.getType());

        //toc接口通过order的getAdapter的方式返回，在上面toc模快里TocAdapterFactory里，
        // 解释了会根据order的type类型，返回对应的实现，这里会返回GenrealToc的实现。
        TocService tocService = (TocService) orderService.getAdapter(TocService.class);

        //订单bean里增加属性
        if (tocService != null) {
            tocService.setOrderConfirmTimeout(orderInfo);
            tocService.setOrderConsignmentTimeout(orderInfo);
        }

        Boolean b = tocService.isTimeout(orderInfo);




        OrderInfo orderInfo1 = orderService.CreateOrder("1111",type);


        int consignment_timeout = tocService.getOrderConsignmentTimeout(orderInfo);
        int confirm_timeout = tocService.getOrderConfirmTimeout(orderInfo);

//        float promotion = ump.getOrderPromation(order);

        JSONObject jo = new JSONObject();

        jo.put("type", type);
        jo.put("confignment_timeout", consignment_timeout);
        jo.put("confirm_timeout", confirm_timeout);
//        jo.put("promotion",promotion);

        return jo;
    }

}