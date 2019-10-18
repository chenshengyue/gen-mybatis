package com.csy.mybatis.bean;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PrimaryKeyInfo implements Cloneable {

    private boolean pkAutoIncrement;

    private String primaryKeyType;

}
