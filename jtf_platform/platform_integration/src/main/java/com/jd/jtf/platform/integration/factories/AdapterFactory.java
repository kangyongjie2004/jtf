//package com.jd.jtf.platform.integration.factories;
//
//import com.jd.jtf.common.adaptable.AdapterManager;
//import com.jd.jtf.common.adaptable.IAdapterFactory;
//import com.jd.jtf.common.adaptable.IAdapterManager;
//import com.jd.jtf.domain.bean.OrderInfo;
//import com.jd.jtf.platform.integration.identifier.BusinessType;
//import com.jd.jtf.toc.plugin.TocService;
//import org.springframework.stereotype.Service;
//
//import javax.annotation.PostConstruct;
//
////实现一个TocAdapterFactory工厂类，用来向平台注册IOrder的TOC扩展
////这个类会将Toc接口注册到AdapterManger里，这样IOrder就可以通过getAdapter方法得到toc相关的功能。
//
//@Service
//public class AdapterFactory implements IAdapterFactory {
//
////    @Resource
////    public com.jd.jtf.toc.helepr.TocHelper tocHelper;
//
//    private Class[] classes;
//
//
//    @PostConstruct
//    public void init() {
//
//        System.out.println("AdapterFactory.........");
//        IAdapterManager manager = AdapterManager.getDefault();
//        manager.registerAdapters(this, OrderInfo.class);
//    }
//
////
////    @Override
////    public TocService  getAdapter(Object adaptableObject, Class adapterType) {
////        if (adapterType == TocService.class) {
////            OrderInfo orderInfo = (OrderInfo) adaptableObject;
////            TocService tocService = tocHelper.toc(orderInfo.getType());
////            if (tocService== null) {
////                tocService = tocHelper.toc("general");
////            }
////            return tocService;
////        }
////        return null;
////    }
//
//    @Override
//    public <T> T getAdapter(Object adaptableObject, Class<T> adapterType) {
////                if (adapterType == (T)) {//做一个判断，适配器类型是否相同
//
////            OrderInfo orderInfo = (OrderInfo) adaptableObject;
//
//        BusinessType business = (BusinessType) adaptableObject;
//        String businessType = business.getBusinessType();
//
//        //TODO 真正的执行类是根据配置文件中的业务身份从spring容器中取相应的bean
//        TocService tocService = tocHelper.toc(orderInfo.getType());
//        if (tocService == null) {
//            tocService = tocHelper.toc("general");
//        }
//        return tocService;
////        }
//        return null;
//    }
//
//    @Override
//    public Class[] getAdapterList() {
//        return this.classes;
//    }
//
//    /**
//     * 初始化的时候，根据配置文件设置需要的适配器类型
//     *
//     * @param classes
//     * @return
//     */
//    public boolean setAdapterList(Class[] classes){
//        this.classes = classes;
//        return true;
//    }
//}
