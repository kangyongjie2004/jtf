package com.jd.jtf.platform.integration.plugin.elements;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

/**
 * =========================================================
 * 京东 - 技术拓展研发部 - 智能研发组
 * 类说明：
 * <extension pluginid="order" point="tocService">
 *
 * @author kangyongjie E-mail: kangyongjie@jd.com
 * @version Created ：2018/7/18 17:55
 */
public class Extension {
    private String pluginid;
    private String point;

    private Adapter adapter;

    @XmlAttribute
    public String getPluginid() {
        return pluginid;
    }

    public void setPluginid(String pluginid) {
        this.pluginid = pluginid;
    }
    @XmlAttribute
    public String getPoint() {
        return point;
    }

    public void setPoint(String point) {
        this.point = point;
    }
    @XmlElement
    public Adapter getAdapter() {
        return adapter;
    }

    public void setAdapter(Adapter adapter) {
        this.adapter = adapter;
    }
}
