package com.csy.mybatis.bean;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.TreeSet;

@Getter
@Setter
public class TableInfo implements Cloneable {

    private String tableName;

    private String beanName;

    private String refBeanName;

    private String domain;

    private String tableDesc;

    private LinkedHashMap<String, BeanInfo> primaryKey;

    private List<ColumnInfo> columns;

    private LinkedHashMap<String, String> properties;

    private LinkedHashMap<String, BeanInfo> beanInfos;

    private List<ConditionInfo> queryConditionInfos = new ArrayList<>();

    private List<ConditionInfo> pageConditionInfos = new ArrayList<>();

    private List<ConditionInfo> updateConditionInfos = new ArrayList<>();

    private LinkedHashMap<String, String> propertiesToColumns;

    private TreeSet<String> packages;

    @Override
    public TableInfo clone() {
        TableInfo tableInfo = null;
        try {
            tableInfo = (TableInfo) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return tableInfo;
    }
}
