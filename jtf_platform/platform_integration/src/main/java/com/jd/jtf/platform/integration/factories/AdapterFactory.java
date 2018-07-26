package com.jd.jtf.platform.integration.factories;

import com.jd.jtf.common.adaptable.IAdapterFactory;
import com.jd.jtf.platform.integration.identifier.BusinessType;
import com.jd.jtf.platform.integration.plugin.PluginService;
import com.jd.jtf.toc.plugin.TocService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

//实现一个TocAdapterFactory工厂类，用来向平台注册IOrder的TOC扩展
//这个类会将Toc接口注册到AdapterManger里，这样IOrder就可以通过getAdapter方法得到toc相关的功能。

/**
 * 实现一个AdapterFactory工厂类，用来向平台注册领域或业务的扩展<br>
 *     这个类会将扩展接口注册到AdapterManger里，这样领域或业务就可以通过getAdapter方法得到扩展的相关功能。
 */
//@Service
//@Scope("singleton")
public class AdapterFactory implements IAdapterFactory {

    private static final Logger log = LoggerFactory.getLogger(AdapterFactoryService.class);

    private Class[] classes;


//    @PostConstruct
//    public void init() {
//
//        System.out.println("AdapterFactory.........");
//        IAdapterManager manager = AdapterManager.getDefault();
//        manager.registerAdapters(this, OrderInfo.class);
//    }

//
//    @Override
//    public TocService  getAdapter(Object adaptableObject, Class adapterType) {
//        if (adapterType == TocService.class) {
//            OrderInfo orderInfo = (OrderInfo) adaptableObject;
//            TocService tocService = tocHelper.toc(orderInfo.getType());
//            if (tocService== null) {
//                tocService = tocHelper.toc("general");
//            }
//            return tocService;
//        }
//        return null;
//    }

    @Override
    public <T> T getAdapter(Object adaptableObject, Class<T> adapterType) {
//                if (adapterType == (T)) {//做一个判断，适配器类型是否相同

//            OrderInfo orderInfo = (OrderInfo) adaptableObject;

        BusinessType business = (BusinessType) adaptableObject;
        String businessType = business.getBusinessType();

        //TODO 真正的执行类是根据配置文件中的业务身份从spring容器中取相应的bean
        TocService tocService = tocHelper.toc(orderInfo.getType());
        if (tocService == null) {
            tocService = tocHelper.toc("general");
        }
        return tocService;
//        }
        return null;
    }

    @Override
    public Class[] getAdapterList() {
        return this.classes;
    }

    /**
     * 初始化的时候，根据配置文件设置需要的适配器类型
     *
     * @param classes
     * @return
     */
    public boolean setAdapterList(Class[] classes){
        this.classes = classes;
        return true;
    }
}
