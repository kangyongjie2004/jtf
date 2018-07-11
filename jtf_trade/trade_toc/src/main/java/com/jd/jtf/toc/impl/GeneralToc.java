package com.jd.jtf.toc.impl;

import com.jd.jtf.domain.order.IOrder;
import com.jd.jtf.toc.Toc;
import org.springframework.stereotype.Service;

@Service
public class GeneralToc  implements Toc {

    @Override
    public void setOrderConsignmentTimeout(IOrder order) {
        order.putAttribute("consignment_timeout", 100);
    }

    @Override
    public int getOrderConsignmentTimeout(IOrder order) {
        return 100;
    }

    @Override
    public void setOrderConfirmTimeout(IOrder order) {
        order.putAttribute("confirm_timeout", 200);
    }

    @Override
    public int getOrderConfirmTimeout(IOrder order) {
        return 200;
    }
}