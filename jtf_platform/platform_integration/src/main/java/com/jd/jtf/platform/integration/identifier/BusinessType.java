package com.jd.jtf.platform.integration.identifier;

/**
 * =========================================================
 * 京东 - 技术拓展研发部 - 智能研发组
 * 类说明：用来标识业务身份<br>
 *     进而根据业务身份获取适配器真正执行的类。
 *
 * @author kangyongjie E-mail: kangyongjie@jd.com
 * @version Created ：2018/7/17 14:47
 */
public interface BusinessType {
    /**
     * 设置业务身份
     * @return
     */
    String setBusinessType();

    /**
     * 获取业务身份
     * @return
     */
    String getBusinessType();
}
