package test;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

/**
 * =========================================================
 * 京东 - 技术拓展研发部 - 智能研发组
 * 类说明：
 *
 * @author kangyongjie E-mail: kangyongjie@jd.com
 * @version Created ：2018/7/13 16:13
 *
 *
<plugin>
<id>com.jd.jtf.demo</id>
<extension-point id="de.vogella.extensionpoint.greeters"
name="Greeters"
desc="test"
author="kangyj">
<extensions>
<extension>com.jd.jtf.order.OrderInfo</extension>
<extension>com.jd.jtf.order.TopLifeOrderInfo</extension>
</extensions>
</extension-point>
</plugin>
 */
@XmlRootElement(name="plugin")
public class Plugin {
    /**
     * 身份标志
     */
    private String id;
    /**
     * 加载顺序
     */
    private int order;
    /**
     * 扩展点
     */
    private List<PluginPoint> extension_point;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }

    public List<PluginPoint> getExtension_point() {
        return extension_point;
    }
    @XmlElement(name = "extension-point")
    public void setExtension_point(List<PluginPoint> extension_point) {
        this.extension_point = extension_point;
    }
}
