package com.jd.jtf.platform.test;

import com.jd.jtf.common.adaptable.Assert;
import com.jd.jtf.common.utils.JaxbUtil;
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
        System.out.println(plugin.getId());
        System.out.println(plugin.getExtension_point().get(0).getExtensions().get(0));
        System.out.println(plugin.getExtension_point().get(0).getAuthor());
        System.out.println(plugin.getOrder());
    }

}
