package com.jd.jtf.platform.integration.plugin.elements;

import javax.xml.bind.annotation.XmlAttribute;

/**
 * =========================================================
 * 京东 - 技术拓展研发部 - 智能研发组
 * 类说明：
 *
 * <extension-point id="tocService" name="TocService" interfaze="com.jd.jtf.demo.plugin.order.inter.ITocService"/>
 *
 * @author kangyongjie E-mail: kangyongjie@jd.com
 * @version Created ：2018/7/18 17:52
 */
public class ExtensionPoint {

    private String id;
    private String name;
    private String interfaze;
    @XmlAttribute
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    @XmlAttribute
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    @XmlAttribute(name = "interface")
    public String getInterfaze() {
        return interfaze;
    }

    public void setInterfaze(String interfaze) {
        this.interfaze = interfaze;
    }
}
