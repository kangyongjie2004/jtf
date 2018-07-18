package com.jd.jtf.platform.integration.plugin;

import com.jd.jtf.common.utils.JaxbUtil;
import com.jd.jtf.platform.integration.plugin.elements.Plugin;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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

    private static final Logger log = LoggerFactory.getLogger(PluginService.class);

    /**
     * 拿到类路径下所有的plugin.xml文件，并解析
     */
    public List<Plugin> parsePlugins() throws IOException {

        List<Plugin> plugins = new ArrayList<Plugin>();

        Resource[] resources = this.getPluginFiles();

        if (resources == null || resources.length == 0) {
            log.warn("### file plugin.xml not found.");
            return plugins;
        }

        for (Resource resource : resources) {
            Plugin plugin = JaxbUtil.convertToJavaBean(resource.getURL(), Plugin.class);
            log.info("### plugin.xml file path:{}", resource.getURL().toString());
            plugins.add(plugin);
        }

        return plugins;
    }

    /**
     * 建立插件的依赖关系
     */
    public void buildDependencies() {
        //TODO

    }

    /**
     * 获取所有的plugin.xml文件
     */
    public Resource[] getPluginFiles() {

        ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        Resource[] resources = new Resource[0];
        try {
            resources = resolver.getResources("classpath*:**/plugin.xml");
        } catch (IOException e) {
            e.printStackTrace();
            log.error("### parse plugin.xml error.");
        }

        return resources;
    }
}
