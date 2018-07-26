package com.jd.jtf.platform.integration.plugin;

import com.jd.jtf.common.utils.JaxbUtil;
import com.jd.jtf.platform.integration.plugin.elements.ExtensionImpl;
import com.jd.jtf.platform.integration.plugin.elements.ExtensionPoint;
import com.jd.jtf.platform.integration.plugin.elements.Plugin;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * =========================================================
 * 京东 - 技术拓展研发部 - 智能研发组
 * 类说明：插件服务，解析plugin.xml文件、建立插件之间的依赖关系
 *
 * @author kangyongjie E-mail: kangyongjie@jd.com
 * @version Created ：2018/7/18 17:15
 */
@Service
public class PluginService {

    private static final Logger log = LoggerFactory.getLogger(PluginService.class);

    /**
     * 拿到类路径下所有的plugin.xml文件，并解析
     */
    public List<Plugin> parsePlugins() {

        List<Plugin> plugins = new ArrayList<Plugin>();

        Resource[] resources = this.getPluginFiles();

        if (resources == null || resources.length == 0) {
            log.warn("### file plugin.xml not found.");
            return plugins;
        }

        for (Resource resource : resources) {

            try {
                Plugin plugin = JaxbUtil.convertToJavaBean(resource.getURL(), Plugin.class);
                log.info("### plugin.xml file path:{}", resource.getURL().toString());
                plugins.add(plugin);
            } catch (IOException e) {
                e.printStackTrace();
                continue;
            }

        }

        return plugins;
    }

    /**
     * 建立插件的依赖关系
     */
    public Map<String, Map<String, List<ExtensionImpl>>> buildDependencies() {

        //key:被扩展的业务
        //value:Map-key 扩展点接口；Map-value 扩展点实现的list
        Map<String, Map<String, List<ExtensionImpl>>> dependencies = new HashMap<String, Map<String, List<ExtensionImpl>>>();

        List<Plugin> pluginList = this.parsePlugins();

        for (Plugin p : pluginList) {
            String isExtended = p.getIsExtended();

            if (StringUtils.isEmpty(isExtended)) continue;

            if (dependencies.containsKey(isExtended)) {//存在
                //判断扩展点是否存在
                for (ExtensionPoint ep : p.getExtensionPoint()) {
                    if (dependencies.get(isExtended).containsKey(ep.getInterfaze())) {
                        dependencies.get(isExtended).get(ep.getInterfaze()).addAll(ep.getExtensionImpl());
                    } else {
                        Map<String, List<ExtensionImpl>> vm = new HashMap<String, List<ExtensionImpl>>();
                        vm.put(ep.getInterfaze(), ep.getExtensionImpl());
                    }
                }

            } else {//不存在,增加被扩展的、扩展点、扩展
                Map<String, List<ExtensionImpl>> vm = new HashMap<String, List<ExtensionImpl>>();

                for (ExtensionPoint ep : p.getExtensionPoint()) {
                    if (ep.getExtensionImpl() != null && ep.getExtensionImpl().size() > 0)
                        vm.put(ep.getInterfaze(), ep.getExtensionImpl());
                }

                dependencies.put(isExtended, vm);

            }

        }

        return dependencies;
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
