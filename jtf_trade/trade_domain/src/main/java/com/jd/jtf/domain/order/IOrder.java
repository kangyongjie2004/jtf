package com.jd.jtf.domain.order;

import org.eclipse.core.runtime.IAdaptable;


public interface IOrder extends IAdaptable {
    public void putAttribute(String key, Object value);

    public String getType();

    public Object getAttribute(String key);

    void setType(String type);

}
