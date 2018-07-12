package com.jd.jtf.domain.helper;

import com.jd.jtf.domain.plugin.impl.FreshCouponService;
import com.jd.jtf.domain.plugin.impl.GenenalCouponService;
import com.jd.jtf.domain.plugin.impl.ToplifeCouponService;
import com.jd.trade.service.ICouponService;
import com.jd.wanjia.service.impl.WanjiaCouponService;
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
    @Resource
    private WanjiaCouponService wanjiaCouponService;

    static String type_general = "general";
    static String type_toplite = "toplife";
    static String type_fresh = "fresh";
    static String type_wanjia = "wanjia";

    public ICouponService getCouponService(String type) {

        ICouponService couponService;
        if (type.equals(type_toplite)) {
            couponService = toplifeCouponService;
        } else if (type.equals(type_fresh)) {
            couponService = freshCouponService;
        } else if (type.equals(type_wanjia)) {
            couponService = wanjiaCouponService;
        }else {
            couponService = genenalCouponService;
        }

        return couponService;
    }


}
