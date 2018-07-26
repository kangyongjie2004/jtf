package com.jd.jtf.platform.integration.plugin.elements;

import javax.xml.bind.annotation.XmlAttribute;

/**
 * =========================================================
 * 京东 - 技术拓展研发部 - 智能研发组
 * 类说明：
 <extension-impl

 refid="priceService"
 bussinessType="fresh"
 impl="com.jd.jtf.plugin.FreshPriceService"
 desc="test test"
 author="kyj"/>
 *
 * @author kangyongjie E-mail: kangyongjie@jd.com
 * @version Created ：2018/7/18 17:55
 */
public class ExtensionImpl {
    private String refid;
    private String bussinessType;
    private String impl;
    private String desc;
    private String author;

    @XmlAttribute
    public String getRefid() {
        return refid;
    }

    public void setRefid(String refid) {
        this.refid = refid;
    }
    @XmlAttribute
    public String getBussinessType() {
        return bussinessType;
    }

    public void setBussinessType(String bussinessType) {
        this.bussinessType = bussinessType;
    }
    @XmlAttribute
    public String getImpl() {
        return impl;
    }

    public void setImpl(String impl) {
        this.impl = impl;
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
}
