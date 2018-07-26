package com.jd.jtf.platform.integration.factories;

import com.jd.jtf.common.adaptable.AdapterManager;
import com.jd.jtf.common.adaptable.IAdapterFactory;
import com.jd.jtf.common.adaptable.IAdapterManager;
import com.jd.jtf.domain.bean.OrderInfo;
import com.jd.jtf.platform.integration.identifier.BusinessType;
import com.jd.jtf.platform.integration.plugin.PluginService;
import com.jd.jtf.toc.plugin.TocService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

import static javafx.scene.input.KeyCode.T;

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
        IAdapterManager manager = AdapterManager.getDefault();
        manager.registerAdapters(this, OrderInfo.class);
        log.info("### AdapterFactories  initialized .........");
    }

    /**
     * 装配插件、建立插件之间的依赖关系
     * @param adaptableObject
     * @param adapterType
     * @return
     */
    public boolean assemblePlugins () {

    }


    /**
     * 构建所有扩展的工厂
     *
     * @param classes
     * @return
     */
    public boolean buildFactories(Class[] classes){
        this.classes = classes;
        return true;
    }
}
