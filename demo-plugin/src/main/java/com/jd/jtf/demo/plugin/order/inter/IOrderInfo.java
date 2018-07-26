package com.jd.jtf.demo.plugin.order.inter;

/**
 * =========================================================
 * 京东 - 技术拓展研发部 - 智能研发组
 * 类说明：
 *
 * @author kangyongjie E-mail: kangyongjie@jd.com
 * @version Created ：2018/7/19 9:55
 */
public interface IOrderInfo {
    void putAttribute(String key, Object value);

    Object getAttribute(String key);

    String getOrderId();

    void setOrderId(String orderId);

    Integer getNumber();

    void setNumber(Integer number);

    String getType();

    void setType(String type);

    Float getPrice();

    void setPrice(Float price);

    String getAddress();

    void setAddress(String address);

    Long getCreatedTime();

    void setCreatedTime(Long createdTime);

    long getRemainingTime();

    void setRemainingTime(long remainingTime);

    String getOrderStatus();

    void setOrderStatus(String orderStatus);
}
