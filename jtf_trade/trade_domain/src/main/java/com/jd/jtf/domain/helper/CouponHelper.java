package com.jd.jtf.domain.helper;

import com.jd.jtf.domain.plugin.ICouponService;
import com.jd.jtf.domain.plugin.impl.FreshCouponService;
import com.jd.jtf.domain.plugin.impl.GenenalCouponService;
import com.jd.jtf.domain.plugin.impl.ToplifeCouponService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class CouponHelper {

    @Resource
    private GenenalCouponService genenalCouponService;
    @Resource
    private ToplifeCouponService toplifeCouponService;
    @Resource
    private FreshCouponService freshCouponService;


    static String type_general = "general";
    static String type_toplite = "toplife";
    static String type_fresh = "fresh";

    public ICouponService getCouponService(String type) {

        ICouponService couponService;
        if (type.equals(type_toplite)) {
            couponService = toplifeCouponService;
        } else if (type.equals(type_fresh)) {
            couponService = freshCouponService;
        } else {
            couponService = genenalCouponService;
        }

        return couponService;
    }


}
