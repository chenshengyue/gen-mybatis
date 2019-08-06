package com.csy.mybatis.bean;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BeanInfo implements Cloneable {

    private String propertyName;

    private String propertyType;

    private String columnName;

    private String columnType;

    private String propertyDesc;

    @Override
    public BeanInfo clone() {
        BeanInfo beanInfo = null;
        try {
            beanInfo = (BeanInfo) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return beanInfo;
    }
}
