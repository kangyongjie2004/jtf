package com.jd.jtf.domain.order.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.google.common.collect.Maps;
import com.jd.jtf.domain.order.DrinkType;
import com.jd.jtf.domain.order.IOrder;
import com.jd.jtf.domain.order.OrderItem;
import org.eclipse.core.runtime.PlatformObject;
import org.springframework.stereotype.Service;

@Service("order")
public class Order extends PlatformObject implements IOrder {

    private List<OrderItem> orderItems = new ArrayList<OrderItem>();

    private int number;

    private String type;

    private float price;

    private final Map<String, Object> attributes = Maps.newHashMap();

    public void setOrderItems(List<OrderItem> orderItems) {
        this.orderItems = orderItems;
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

    public void putAttribute(String key, Object value) {
        this.attributes.put(key, value);
    }

    public Object getAttribute(String key) {
        return this.attributes.get(key);
    }

    public void addItem(DrinkType drinkType, int shots, boolean iced) {
        this.orderItems.add(new OrderItem(this, drinkType, shots, iced));
    }

    public int getNumber() {
        return number;
    }

    public List<OrderItem> getItems() {
        return this.orderItems;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    private void writeXML() {}


}
