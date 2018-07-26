package com.jd.jtf.platform.integration.plugin.elements;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

/**
 * =========================================================
 * 京东 - 技术拓展研发部 - 智能研发组
 * 类说明：
 * groupId="com.jd.jpf"
 * artifactId="order_plugin"
 * version="1.0"
 * desc="test"
 * author="kyj"
 *
 * @author kangyongjie E-mail: kangyongjie@jd.com
 * @version Created ：2018/7/18 17:51
 */
@XmlRootElement(name = "plugin")
public class Plugin {
    private String groupId;
    private String artifactId;
    private String version;
    private String desc;
    private String author;

    private List<ExtensionImpl> extensionImpl;

    private List<ExtensionPoint> extensionPoint;


    @XmlAttribute
    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    @XmlAttribute
    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    @XmlAttribute
    public String getArtifactId() {
        return artifactId;
    }

    public void setArtifactId(String artifactId) {
        this.artifactId = artifactId;
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

    @XmlElement(name = "extensionImpl-point")
    public List<ExtensionPoint> getExtensionPoint() {
        return extensionPoint;
    }

    public void setExtensionPoint(List<ExtensionPoint> extensionPoint) {
        this.extensionPoint = extensionPoint;
    }
}
