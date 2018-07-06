package com.jd.jtf.toc.virtual;

import com.google.inject.Inject;
import com.jd.jtf.domain.order.IOrder;
import com.jd.jtf.toc.AbstractTocComponent;
import com.jd.jtf.toc.Toc;
import com.jd.jtf.toc.TocName;
import com.jd.jtf.toc.TocSettings;

public class VirtualToc extends AbstractTocComponent implements Toc {

    final TocSettings settings;

    @Inject
    public VirtualToc(TocName tocName, TocSettings settings) {
        super(tocName, settings);
        this.settings = settings;
    }

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