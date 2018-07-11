package com.jd.jtf.toc.factory;

import com.jd.jtf.domain.order.IOrder;
import com.jd.jtf.toc.Toc;
import com.jd.jtf.toc.service.TocsService;
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
    public TocsService tocsService;


    @PostConstruct
    public void init() {

        IAdapterManager manager = AdapterManager.getDefault();
        manager.registerAdapters(this, IOrder.class);
    }


    @Override
    public Object getAdapter(Object adaptableObject, Class adapterType) {
        if (adapterType == Toc.class) {
            IOrder order = (IOrder) adaptableObject;
            Toc toc = tocsService.toc(order.getType());
            if (toc== null) {
                toc = tocsService.toc("general");
            }
            return toc;
        }
        return null;
    }

    @Override
    public Class[] getAdapterList() {
        return new Class[] { Toc.class };
    }

}
