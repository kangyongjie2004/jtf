package com.jd.jtf.domain.factory;



import com.jd.jtf.domain.helper.CouponHelper;
import com.jd.jtf.domain.plugin.ICouponService;
import com.jd.jtf.domain.order.IOrderService;
import org.eclipse.core.internal.runtime.AdapterManager;
import org.eclipse.core.runtime.IAdapterFactory;
import org.eclipse.core.runtime.IAdapterManager;
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

        IAdapterManager manager = AdapterManager.getDefault();
        manager.registerAdapters(this, IOrderService.class);
    }


    @Override
    public Object getAdapter(Object adaptableObject, Class adapterType) {
        if (adapterType == ICouponService.class) {
            IOrderService orderService = (IOrderService) adaptableObject;
            ICouponService couponService = couponHelper.getCouponService(orderService.getBusinessType());
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
