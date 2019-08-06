package com.csy.mybatis.bean;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ConditionInfo {

    private String propertyName;

    private String columnName;

    private String action;

    private String xmlSql;
}
