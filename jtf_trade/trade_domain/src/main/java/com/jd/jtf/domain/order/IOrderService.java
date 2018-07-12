package com.jd.jtf.domain.order;

import com.jd.jtf.domain.bean.OrderInfo;
import org.eclipse.core.runtime.IAdaptable;


public interface IOrderService {


    public String getBusinessType();


    void setBusinessType(String businessType);

    public OrderInfo CreateOrder(String orderId, String orderType);

    public String deleteOrder(String orderId, String orderType);


    public OrderInfo getOrderInfo(String orderId, String businessType);

    public float getCoupon(String orderId, String orderType);

}
