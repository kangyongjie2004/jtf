package com.jd.jtf.platform.integration.plugin.elements;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import java.util.List;

/**
 * =========================================================
 * 京东 - 技术拓展研发部 - 智能研发组
 * 类说明：
 <extension-point
 id="priceService"
 interface="com.jd.jtf.point.IPriceService"
 desc="test test"
 author="kyj"/>
 *
 *
 * @author kangyongjie E-mail: kangyongjie@jd.com
 * @version Created ：2018/7/18 17:52
 */
public class ExtensionPoint {

    private String desc;
    private String interfaze;
    private String author;

    private List<ExtensionImpl> extensionImpl;

    @XmlAttribute(name = "interface")
    public String getInterfaze() {
        return interfaze;
    }

    public void setInterfaze(String interfaze) {
        this.interfaze = interfaze;
    }
    @XmlAttribute
    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
    @XmlAttribute
    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @XmlElement(name = "extensionImpl-impl")
    public List<ExtensionImpl> getExtensionImpl() {
        return extensionImpl;
    }

    public void setExtensionImpl(List<ExtensionImpl> extensionImpl) {
        this.extensionImpl = extensionImpl;
    }
}
