package com.jd.jtf.toc.factory;

import com.jd.jtf.domain.order.IOrderService;
import com.jd.jtf.toc.plugin.TocService;
import org.eclipse.core.internal.runtime.AdapterManager;
import org.eclipse.core.runtime.IAdapterFactory;
import org.eclipse.core.runtime.IAdapterManager;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
//实现一个TocAdapterFactory工厂类，用来向平台注册IOrder的TOC扩展
//这个类会将Toc接口注册到AdapterManger里，这样IOrder就可以通过getAdapter方法得到toc相关的功能。
@Service
public class TocAdapterFactory implements IAdapterFactory {

    @Resource
    public com.jd.jtf.toc.helper.TocHelper tocHelper;


    @PostConstruct
    public void init() {

        IAdapterManager manager = AdapterManager.getDefault();
        manager.registerAdapters(this, IOrderService.class);
    }


    @Override
    public Object getAdapter(Object adaptableObject, Class adapterType) {
        if (adapterType == TocService.class) {
            IOrderService orderService = (IOrderService) adaptableObject;
            TocService tocService = tocHelper.toc(orderService.getBusinessType());
            if (tocService== null) {
                tocService = tocHelper.toc("general");
            }
            return tocService;
        }
        return null;
    }

    @Override
    public Class[] getAdapterList() {
        return new Class[] { TocService.class };
    }

}
