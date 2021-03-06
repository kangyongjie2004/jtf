package com.jd.jtf.demo.plugin.order;

import com.google.common.collect.Maps;
import com.jd.jtf.common.adaptable.PlatformObject;
import com.jd.jtf.demo.plugin.order.inter.IOrderInfo;
import com.jd.jtf.platform.integration.identifier.BusinessType;

import java.util.Map;

public class OrderInfo extends PlatformObject implements BusinessType, IOrderInfo {

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


    @Override
    public void putAttribute(String key, Object value) {
        this.attributes.put(key, value);
    }

    @Override
    public Object getAttribute(String key) {
        return this.attributes.get(key);
    }


    @Override
    public String getOrderId() {
        return orderId;
    }

    @Override
    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    @Override
    public Integer getNumber() {
        return number;
    }

    @Override
    public void setNumber(Integer number) {
        this.number = number;
    }

    @Override
    public String getType() {
        return type;
    }

    @Override
    public void setType(String type) {
        this.type = type;
    }

    @Override
    public Float getPrice() {
        return price;
    }

    @Override
    public void setPrice(Float price) {
        this.price = price;
    }

    @Override
    public String getAddress() {
        return address;
    }

    @Override
    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public Long getCreatedTime() {
        return createdTime;
    }

    @Override
    public void setCreatedTime(Long createdTime) {
        this.createdTime = createdTime;
    }

    @Override
    public long getRemainingTime() {
        return remainingTime;
    }

    @Override
    public void setRemainingTime(long remainingTime) {
        this.remainingTime = remainingTime;
    }

    @Override
    public String getOrderStatus() {
        return orderStatus;
    }

    @Override
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
