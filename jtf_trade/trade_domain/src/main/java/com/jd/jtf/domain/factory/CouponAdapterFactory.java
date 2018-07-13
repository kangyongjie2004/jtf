package com.jd.jtf.domain.factory;

import com.jd.jtf.common.adaptable.AdapterManager;
import com.jd.jtf.common.adaptable.IAdapterFactory;
import com.jd.jtf.common.adaptable.IAdapterManager;
import com.jd.jtf.domain.bean.OrderInfo;
import com.jd.jtf.domain.helper.CouponHelper;
import com.jd.trade.service.ICouponService;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
//实现一个TocAdapterFactory工厂类，用来向平台注册IOrder的TOC扩展
//这个类会将Toc接口注册到AdapterManger里，这样IOrder就可以通过getAdapter方法得到toc相关的功能。
@Service
public class CouponAdapterFactory implements IAdapterFactory {

    @Resource
    public CouponHelper couponHelper;


    @PostConstruct
    public void init() {
        System.out.println("CouponAdapterFactory.........");
        IAdapterManager manager = AdapterManager.getDefault();
        manager.registerAdapters(this, OrderInfo.class);
    }


    @Override
    public Object getAdapter(Object adaptableObject, Class adapterType) {
        if (adapterType == ICouponService.class) {
            OrderInfo orderInfo = (OrderInfo) adaptableObject;
            ICouponService couponService = couponHelper.getCouponService(orderInfo.getType());
            if (couponService== null) {
                couponService = couponHelper.getCouponService("general");
            }
            return couponService;
        }
        return null;
    }

    @Override
    public Class[] getAdapterList() {
        return new Class[] { ICouponService.class };
    }

}
