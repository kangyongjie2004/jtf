package com.jd.wanjia.service.impl;

import com.jd.trade.service.ICouponService;
import org.springframework.stereotype.Service;

@Service
public class WanjiaCouponService implements ICouponService {
    @Override
    public float getCoupon(String orderId){
        System.out.println("Wanjia");
        return 0f;
    }

}
