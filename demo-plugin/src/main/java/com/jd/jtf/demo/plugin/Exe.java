package com.jd.jtf.demo.plugin;

import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;

import java.io.IOException;

/**
 * =========================================================
 * 京东 - 技术拓展研发部 - 智能研发组
 * 类说明：
 *
 * @author kangyongjie E-mail: kangyongjie@jd.com
 * @version Created ：2018/7/18 15:16
 */
public class Exe {
    public static void main(String[] args) throws IOException {
//        System.out.println(Thread.currentThread().getContextClassLoader());
//        URL r = Thread.currentThread().getContextClassLoader().getResource("**/plugin.xml");
//        System.out.println(r.getFile());
//        Enumeration<URL> r = Thread.currentThread().getContextClassLoader().getResource("plugin.xml");
//        System.out.println(r.hasMoreElements());
//        while(r.hasMoreElements()){
//            System.out.println(r.nextElement().getFile());
//        }
//
//        System.out.println(r.toString());

        ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        //将加载多个绝对匹配的所有Resource
        //将首先通过ClassLoader.getResources("META-INF")加载非模式路径部分
        //然后进行遍历模式匹配
        Resource[] resources=resolver.getResources("classpath*:**/plugin.xml");

        for (Resource resource : resources){
            System.out.println(resource.getURL());
        }

    }
}
