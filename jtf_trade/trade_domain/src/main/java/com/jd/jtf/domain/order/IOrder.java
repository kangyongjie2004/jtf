package com.jd.jtf.domain.order;
import org.eclipse.core.runtime.IAdaptable;

import java.util.List;


public interface IOrder extends IAdaptable {
    public void addItem(DrinkType drinkType, int shots, boolean iced);
    public List<OrderItem> getItems();
    public void putAttribute(String key, Object value);
    public String getType();
    public Object getAttribute(String key);
}
