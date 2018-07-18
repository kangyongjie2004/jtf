package com.jd.jtf.platform.integration.plugin;

import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;

import java.io.IOException;

/**
 * =========================================================
 * 京东 - 技术拓展研发部 - 智能研发组
 * 类说明：插件服务，解析plugin.xml文件、建立插件之间的依赖关系
 *
 * @author kangyongjie E-mail: kangyongjie@jd.com
 * @version Created ：2018/7/18 17:15
 */
//TODO
public class PluginService {
    /**
     * 拿到类路径下所有的plugin.xml文件，并解析
     */
    public void parsePlugins(){

    }

    /**
     * 建立插件的依赖关系
     */
    public void buildDependencies(){

    }

    /**
     * 获取所有的plugin.xml文件
     */
    public Resource[] getPluginFiles() throws IOException {

        ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        Resource[] resources = resolver.getResources("classpath*:**/plugin.xml");

        return resources;
//
//        for (Resource resource : resources) {
//            System.out.println(resource.getURL());
//        }
    }
}
