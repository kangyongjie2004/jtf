package test;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import java.util.List;

/**
 * =========================================================
 * 京东 - 技术拓展研发部 - 智能研发组
 * 类说明：
 *
 * @author kangyongjie E-mail: kangyongjie@jd.com
 * @version Created ：2018/7/13 17:38
 */
public class PluginPoint {

    /**
     *
     */
    private String id;
    /**
     *
     */
    private String name;
    /**
     *
     */
    private String desc;
    /**
     *
     */
    private String author;

    /**
     * 扩展
     */
    private List<String> extensions;

    public String getId() {
        return id;
    }
    @XmlAttribute(name="id")
    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }
    @XmlAttribute(name="name")
    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }
    @XmlAttribute(name="desc")
    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getAuthor() {
        return author;
    }
    @XmlAttribute(name="author")
    public void setAuthor(String author) {
        this.author = author;
    }

    @XmlElementWrapper(name="extensions")
    @XmlElement(name = "extension")
    public List<String> getExtensions() {
        return extensions;
    }

    public void setExtensions(List<String> extensions) {
        this.extensions = extensions;
    }
}
