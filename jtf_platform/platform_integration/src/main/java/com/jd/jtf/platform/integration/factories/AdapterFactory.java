package com.jd.jtf.platform.integration.factories;

import com.jd.jtf.common.adaptable.IAdapterFactory;
import com.jd.jtf.platform.integration.identifier.BusinessType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * 实现一个AdapterFactory工厂类，用来向平台注册领域或业务的扩展<br>
 *     这个类会将扩展接口注册到AdapterManger里，这样领域或业务就可以通过getAdapter方法得到扩展的相关功能。
 */
//@Service
//@Scope("singleton")
public class AdapterFactory implements IAdapterFactory {

    private static final Logger log = LoggerFactory.getLogger(AdapterFactoryService.class);

    private List<Class> classes = new ArrayList<Class>();


    @Override
    public <T> T getAdapter(Object adaptableObject, Class<T> adapterType) {
//                if (adapterType == (T)) {//做一个判断，适配器类型是否相同

//            OrderInfo orderInfo = (OrderInfo) adaptableObject;

        BusinessType business = (BusinessType) adaptableObject;
        String businessType = business.getBusinessType();

        String impl = AdapterFactoryService.getBusinessTypeByFactory(this, adapterType.getName() + businessType);

        //TODO 真正的执行类是根据配置文件中的业务身份从spring容器中取相应的bean
//        TocService tocService = tocHelper.toc(orderInfo.getType());
//        if (tocService == null) {
//            tocService = tocHelper.toc("general");
//        }

        T implObj = null;
        try {
            implObj = (T) Class.forName(impl).newInstance();
        } catch (Exception e) {
            e.printStackTrace();
            log.error("### init impl Object failure! adaptableObject type is:{}" +
                    ",adapterType type is:{}",
                    adaptableObject.getClass(),adapterType.getClass());
        }

        return implObj;

    }

    @Override
    public Class[] getAdapterList() {
        return (Class[])this.classes.toArray();
    }

    /**
     * 添加适配类型
     *
     * @param clazz
     * @return
     */
    public boolean addClass(Class<?> clazz) {
        return classes.add(clazz);
    }

}
