package com.csy.mybatis;

import java.lang.annotation.*;

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
public @interface Column {

    String column();

    ColumnAction action();

}
