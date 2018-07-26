package com.jd.jtf.platform.integration.factories;

import com.jd.jtf.common.adaptable.AdapterManager;
import com.jd.jtf.common.adaptable.IAdapterFactory;
import com.jd.jtf.common.adaptable.IAdapterManager;
import com.jd.jtf.platform.integration.plugin.PluginService;
import com.jd.jtf.platform.integration.plugin.elements.ExtensionImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//实现一个TocAdapterFactory工厂类，用来向平台注册IOrder的TOC扩展
//这个类会将Toc接口注册到AdapterManger里，这样IOrder就可以通过getAdapter方法得到toc相关的功能。

/**
 * 适配器的工厂<br/>
 * 该类用来根据配置文件装配插件、构建插件之间的依赖关系。
 */
@Service
public class AdapterFactoryService {

    private static final Logger log = LoggerFactory.getLogger(AdapterFactoryService.class);

    @Resource
    private PluginService pluginService;

    @PostConstruct
    public void init() {

        log.info("### AdapterFactories  initializing .........");
        buildFactories();
        log.info("### AdapterFactories  initialized .........");
    }

//    /**
//     * 装配插件、建立插件之间的依赖关系
//     * @param adaptableObject
//     * @param adapterType
//     * @return
//     */
//    public boolean assemblePlugins () {
//
//    }


    /**
     * 构建所有扩展的工厂：每个被扩展的业务定义为一个工厂；多个扩展点共享一个工厂。
     *
     * @return
     */
    public boolean buildFactories() {

        Map<String, Map<String, List<ExtensionImpl>>> dependencies = pluginService.buildDependencies();

        log.info("### AdapterFactories  initializing .........");
        IAdapterManager manager = AdapterManager.getDefault();

        for (Map.Entry<String, Map<String, List<ExtensionImpl>>> entry : dependencies.entrySet()) {

            AdapterFactory adapterFactory = new AdapterFactory();

            Map<String, String> bussinessTypeMapping = new HashMap<String, String>();

            try {
                String isExtended = entry.getKey();
                Class isExtendedClazz = Class.forName(isExtended);

                for (Map.Entry<String, List<ExtensionImpl>> subEntry : entry.getValue().entrySet()) {

                    String extendPointInterface = subEntry.getKey();
                    Class extendPointInterfaceClazz = Class.forName(extendPointInterface);

                    adapterFactory.addClass(extendPointInterfaceClazz);

                    //注册业务身份
                    for (ExtensionImpl extensionImpl : subEntry.getValue()) {
                        bussinessTypeMapping.put(subEntry.getKey() + extensionImpl.getBussinessType(), extensionImpl.getImpl());
                    }


                    log.info("### AdapterFactories  " +
                                    "initialized,isExtended class is:{},extendPointInterface is:{}",
                            isExtended, extendPointInterface);
                }

                manager.registerAdapters(adapterFactory, isExtendedClazz);

                this.m.put(adapterFactory, bussinessTypeMapping);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
                throw new RuntimeException("### init class failure !!! please check !");
            }

        }

        log.info("### AdapterFactories  initialized successfully .........");

        return true;
    }

    private static final Map<IAdapterFactory, Map<String, String>> m = new HashMap<IAdapterFactory, Map<String, String>>();

    /**
     * 根据工厂对象 和 接口全称+业务身份 获取具体的实现类字符串。
     *
     * @param factory
     * @param interfazeBussinessType
     * @return
     */
    public static String getBusinessTypeByFactory(IAdapterFactory factory, String interfazeBussinessType) {
        String impl = m.get(factory).get(interfazeBussinessType);
        return impl == null ? "" : impl;
    }
}
