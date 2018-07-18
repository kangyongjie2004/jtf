package com.jd.jtf.platform.integration.plugin.elements;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

/**
 * =========================================================
 * 京东 - 技术拓展研发部 - 智能研发组
 * 类说明：
 * <plugin id="order" name="order plugin" version="1.0">

 <!-- 暴露扩展点,可插入点-->
 <extension-point id="tocService" name="TocService" interface="com.jd.jtf.demo.plugin.order.inter.ITocService"/>
 <extension-point id="couponService" name="CoupService" interface="com.jd.jtf.demo.plugin.order.inter.ICouponService"/>

 <!-- 扩展点实现-->
 <extension pluginid="order" point="tocService">
 <adapter bussinessType="general" impl="com.jd.jtf.demo.plugin.order.GeneraTocService"/>
 </extension>
 <extension pluginid="order" point="couponService">
 <adapter bussinessType="general" impl="com.jd.jtf.demo.plugin.order.GeneralCouponService"/>
 </extension>
 </plugin>
 *
 * @author kangyongjie E-mail: kangyongjie@jd.com
 * @version Created ：2018/7/18 17:51
 */
@XmlRootElement(name="plugin")
public class Plugin {
    private String id;
    private String name;
    private String version;

    private List<Extension> extension;

    private List<ExtensionPoint> extensionPoint;
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
    @XmlAttribute
    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    @XmlElement(name = "extension")
    public List<Extension> getExtension() {
        return extension;
    }

    public void setExtension(List<Extension> extension) {
        this.extension = extension;
    }

    @XmlElement(name = "extension-point")
    public List<ExtensionPoint> getExtensionPoint() {
        return extensionPoint;
    }

    public void setExtensionPoint(List<ExtensionPoint> extensionPoint) {
        this.extensionPoint = extensionPoint;
    }
}
