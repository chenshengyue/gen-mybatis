package com.csy.mybatis;

public enum ColumnAction {

    IN("in", "s or es"),
    NOT_IN("not in", "excludeXXX(前缀)"),
    IS_NULL("is null", "IsNull"),
    IS_NOT_NUll("is not null", "IsNotNull"),
    NOT_EQUAL_TO("!=", "NotEqualTo"),
    EQUAL_TO("=", "EqualTo"),
    GREATER_THAN(">", "GreaterThan"),
    GREATER_THAN_OR_EQUAL_TO(">=", "GreaterThanOrEqualTo"),
    LESS_THAN("<", "LessThan"),
    LESS_THAN_OR_EQUAL_TO("<=", "LessThanOrEqualTo"),
    ;

    private String action;

    //建议命名后缀
    private String suffix;

    ColumnAction(String action, String suffix) {
        this.action = action;
        this.suffix = suffix;
    }

    public String getAction() {
        return action;
    }

}
