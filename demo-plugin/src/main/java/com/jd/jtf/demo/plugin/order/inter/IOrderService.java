package com.jd.jtf.demo.plugin.order.inter;

import com.jd.jtf.demo.plugin.order.OrderInfo;

public interface IOrderService {


    public String getBusinessType();


    void setBusinessType(String businessType);

    public OrderInfo CreateOrder(String orderId, String orderType);

    public String deleteOrder(String orderId, String orderType);


    public OrderInfo getOrderInfo(String orderId, String businessType);

    public float getCoupon(String orderId, String orderType);

}
