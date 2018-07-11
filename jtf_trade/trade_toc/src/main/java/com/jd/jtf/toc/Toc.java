package com.jd.jtf.toc;

import com.jd.jtf.domain.order.IOrder;

public interface Toc  {

    void setOrderConsignmentTimeout(IOrder order);

    void setOrderConfirmTimeout(IOrder order);

    int getOrderConsignmentTimeout(IOrder order);

    int getOrderConfirmTimeout(IOrder order);

}
