package com.jd.jtf.domain.order.impl;

import java.util.Map;

import com.google.common.collect.Maps;
import com.jd.jtf.domain.order.IOrder;
import org.eclipse.core.runtime.PlatformObject;
import org.springframework.stereotype.Service;

@Service
public class Order extends PlatformObject implements IOrder {

    private int number;

    private String type;

    private float price;

    private final Map<String, Object> attributes = Maps.newHashMap();


    public void putAttribute(String key, Object value) {
        this.attributes.put(key, value);
    }

    public Object getAttribute(String key) {
        return this.attributes.get(key);
    }


    public void setNumber(int number) {
        this.number = number;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }


    public int getNumber() {
        return number;
    }


    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    private void writeXML() {
    }


}
