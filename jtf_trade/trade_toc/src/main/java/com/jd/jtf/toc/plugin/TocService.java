package com.jd.jtf.toc.plugin;

import com.jd.jtf.domain.bean.OrderInfo;

public interface TocService {

    void setOrderConsignmentTimeout(OrderInfo orderInfo);

    void setOrderConfirmTimeout(OrderInfo orderInfo);

    Integer getOrderConsignmentTimeout(OrderInfo orderInfo);

    Integer getOrderConfirmTimeout(OrderInfo orderInfo);

    Boolean isTimeout(OrderInfo orderInfo);

    Float getCoupon(OrderInfo orderInfo);


}
