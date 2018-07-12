package com.jd.jtf.domain.order.impl;

import com.jd.jtf.domain.bean.OrderInfo;
import com.jd.jtf.domain.plugin.ICouponService;
import com.jd.jtf.domain.order.IOrderService;
import org.eclipse.core.runtime.PlatformObject;
import org.springframework.stereotype.Service;


@Service
public class OrderService extends PlatformObject implements IOrderService {


    private String businessType;



    public void setBusinessType(String businessType) {
        this.businessType = businessType;
    }

    public String getBusinessType() {
        return businessType;
    }


    public OrderInfo CreateOrder(String orderId, String orderType) {
        OrderInfo info = new OrderInfo();

        info.setOrderId(orderId);
        info.setAddress("test");
        info.setOrderStatus("1");
        info.setPrice(100f);
        info.setType(orderType);
        getCoupon(orderId,orderType);

        return info;
    }


    public float getCoupon(String orderId, String orderType) {
        this.setBusinessType(orderType);
        ICouponService couponService = (ICouponService)this.getAdapter(ICouponService.class);
        OrderInfo orderInfo = getOrderInfo(orderId, orderType) ;
        return couponService.getCoupon(orderInfo);
    }


    public String deleteOrder(String orderId, String orderType) {
        System.out.printf("delete" + orderId);
        return "-1";
    }

    public OrderInfo getOrderInfo(String orderId, String businessType) {
        OrderInfo info = new OrderInfo();

        info.setOrderId(orderId);
        info.setAddress("test");
        info.setOrderStatus("1");
        info.setPrice(100f);
        info.setType(businessType);

        return info;
    }


}
