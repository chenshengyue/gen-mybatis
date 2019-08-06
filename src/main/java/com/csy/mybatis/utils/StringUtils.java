package com.csy.mybatis.utils;

public class StringUtils extends org.apache.commons.lang3.StringUtils {

    static String underlineStr = "_";

    public static String underline2Camel2(String column) {
        StringBuilder result = new StringBuilder();
        if (column == null || column.isEmpty()) {
            return "";
        } else if (!column.contains(underlineStr)) {
            return column.substring(0, 1).toLowerCase() + column.substring(1);
        } else {
            String[] columns = column.split(underlineStr);
            for (String columnSplit : columns) {
                if (columnSplit.isEmpty()) {
                    continue;
                }
                if (result.length() == 0) {
                    result.append(columnSplit.substring(0, 1).toLowerCase()).append(columnSplit.substring(1));
                } else {
                    result.append(columnSplit.substring(0, 1).toUpperCase())
                            .append(columnSplit.substring(1));
                }
            }
            return result.toString();
        }
    }

}
