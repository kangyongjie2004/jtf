package com.jd.jtf.demo.test;

import com.jd.jtf.common.utils.JaxbUtil;
import test.Plugin;

import java.io.File;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;

/**
 * =========================================================
 * 京东 - 技术拓展研发部 - 智能研发组
 * 类说明：
 *
 * @author kangyongjie E-mail: kangyongjie@jd.com
 * @version Created ：2018/7/16 9:59
 */
public class LoadPluginTest {

    public static void main(String[] args) throws Exception {
        String filePath = "D:/workspace_job_idea_java/jtf/demo/plugins/original-demo-plugin-1.0-SNAPSHOT.jar";

//        System.out.println(Thread.currentThread().getClass().getResource("/").getPath());

//        String filePath = System.getProperty("user.dir")+"/plugins/original-demo-plugin-1.0-SNAPSHOT.jar";
        System.out.println(filePath);

        File file = new File(filePath);
        URL url = file.toURI().toURL();
        URLClassLoader urlClassLoader = new URLClassLoader(new URL[]{url});

//        URL[] urls = {new URL("file://D:\\workspace_job_idea_java\\jtf\\demo\\plugins\\original-demo-plugin-1.0-SNAPSHOT.jar")};
//        URL[] urls = {new URL("file://"+filePath)};
//        URLClassLoader urlClassLoader = new URLClassLoader(urls);

        Class<?> clazz = urlClassLoader.loadClass("com.jd.jtf.demo.plugin.PluginTest");

        URL purl = urlClassLoader.findResource("plugin.xml");
//        java.util.Enumeration<java.net.URL> urls = urlClassLoader.findResources("plugin.xml");

//        Plugin plugin = JaxbUtil.converyToJavaBean(purl.getFile(),Plugin.class);
        Plugin plugin = JaxbUtil.convertToJavaBean(purl,Plugin.class);
        System.out.println(plugin.getId());
        System.out.println(plugin.getOrder());

        Method method = clazz.getMethod("print");
        Object instance = clazz.newInstance();
        method.invoke(instance);
    }
}
