package com.jd.jtf.domain.plugin.impl;

import com.jd.trade.service.ICouponService;
import org.springframework.stereotype.Service;

@Service
public class FreshCouponService implements ICouponService {
    @Override
    public float getCoupon(String orderId){
        System.out.println("fresh");
        return 0f;
    }

}
