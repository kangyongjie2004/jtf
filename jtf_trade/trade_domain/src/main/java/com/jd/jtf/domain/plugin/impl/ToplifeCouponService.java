package com.jd.jtf.domain.plugin.impl;

import com.jd.jtf.domain.bean.OrderInfo;
import com.jd.jtf.domain.plugin.ICouponService;
import org.springframework.stereotype.Service;

@Service
public class ToplifeCouponService implements ICouponService {
    @Override
    public float getCoupon(OrderInfo orderInfo){
        System.out.println("Toplife");
        return 0f;
    }

}
