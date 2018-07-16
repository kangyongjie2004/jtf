package com.jd.jtf.demo.plugin;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * =========================================================
 * 京东 - 技术拓展研发部 - 智能研发组
 * 类说明：
 *
 * @author kangyongjie E-mail: kangyongjie@jd.com
 * @version Created ：2018/7/16 9:48
 */
public class PluginTest {

    @Autowired
    private PrintService printService;

    public void print(){
        System.out.println("Hello world,I'm a plugin ... ...");

        printService.print();
    }
}
