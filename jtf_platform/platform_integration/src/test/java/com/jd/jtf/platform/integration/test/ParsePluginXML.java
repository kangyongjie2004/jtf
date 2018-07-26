package com.jd.jtf.platform.integration.test;

import com.jd.jtf.common.adaptable.Assert;
import com.jd.jtf.common.utils.JaxbUtil;
import com.jd.jtf.platform.integration.plugin.elements.Plugin;
import org.junit.Test;

/**
 * =========================================================
 * 京东 - 技术拓展研发部 - 智能研发组
 * 类说明：
 *
 * @author kangyongjie E-mail: kangyongjie@jd.com
 * @version Created ：2018/7/13 15:52
 */
public class ParsePluginXML {

    @Test
    public void parse(){
        System.out.println("=====================");
        Plugin plugin = JaxbUtil.converyToJavaBean("src\\test\\resources\\plugin.xml",Plugin.class);
        Assert.isNotNull(plugin);
        System.out.println(plugin.getGroupId());
        System.out.println(plugin.getExtensionPoint().size());
        System.out.println(plugin.getExtensionImpl().size());
        System.out.println(plugin.getExtensionImpl().get(0).getBussinessType());
    }

}