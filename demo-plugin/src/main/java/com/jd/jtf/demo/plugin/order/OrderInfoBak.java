package com.jd.jtf.demo.plugin.order;

import com.google.common.collect.Maps;
import com.jd.jtf.common.adaptable.PlatformObject;
import com.jd.jtf.platform.integration.identifier.BusinessType;

import java.util.Map;

public class OrderInfoBak extends PlatformObject implements BusinessType{

    private String businessType;

    private String orderId;//订单编号
    private Integer number;
    private String type;
    private Float price;//订单金额
    private String address;
    private Long createdTime;
    private long remainingTime;//剩余支付时间
    private String orderStatus;//订单状态
    private final Map<String, Object> attributes = Maps.newHashMap();


    public void putAttribute(String key, Object value) {
        this.attributes.put(key, value);
    }

    public Object getAttribute(String key) {
        return this.attributes.get(key);
    }


    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Long getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Long createdTime) {
        this.createdTime = createdTime;
    }

    public long getRemainingTime() {
        return remainingTime;
    }

    public void setRemainingTime(long remainingTime) {
        this.remainingTime = remainingTime;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    @Override
    public boolean setBusinessType(String businessType) {
        this.businessType = businessType;
        return true;
    }

    @Override
    public String getBusinessType() {
        return this.businessType;
    }
}