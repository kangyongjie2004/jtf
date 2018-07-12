package com.jd.jtf.toc.plugin.impl;

import com.jd.jtf.domain.bean.OrderInfo;
import com.jd.jtf.toc.plugin.TocService;
import org.springframework.stereotype.Service;

@Service
public class ToplifeTocService implements TocService {

    @Override
    public void setOrderConsignmentTimeout(OrderInfo orderInfo) {
        orderInfo.putAttribute("consignment_timeout", 100);
    }

    @Override
    public Integer getOrderConsignmentTimeout(OrderInfo orderInfo) {
        return (Integer) orderInfo.getAttribute("consignment_timeout");
    }

    @Override
    public void setOrderConfirmTimeout(OrderInfo orderInfo) {
        orderInfo.putAttribute("confirm_timeout", 200);
    }

    @Override
    public Integer getOrderConfirmTimeout(OrderInfo orderInfo) {
        return (Integer) orderInfo.getAttribute("confirm_timeout");
    }

    @Override
    public Boolean isTimeout(OrderInfo orderInfo) {

        Long createTime = orderInfo.getCreatedTime();
        Long currentTime = System.currentTimeMillis();

        return false;
    }
    @Override
    public Float getCoupon(OrderInfo orderInfo){
        return 3f;
    }
}