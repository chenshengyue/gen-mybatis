package com.csy.mybatis.utils;

import com.csy.mybatis.bean.BeanInfo;
import com.csy.mybatis.bean.ColumnInfo;
import com.csy.mybatis.bean.TableInfo;
import lombok.extern.slf4j.Slf4j;

import java.sql.*;
import java.util.*;


@Slf4j
public class DbUtils {

    private static DbUtils dbUtils = new DbUtils();

    private DbUtils() {
    }

    public static DbUtils getInstance() {
        return dbUtils;
    }

    public Connection getConnection(String driverClass, String url, String user, String password) throws ClassNotFoundException {
        Connection connection = null;
        try {
            Class.forName(driverClass);
            Properties props = new Properties();
            props.setProperty("user", user);
            props.setProperty("password", password);
            props.setProperty("remarks", "true");
            props.setProperty("useInformationSchema", "true");
            connection = DriverManager.getConnection(url, props);
        } catch (SQLException e) {
            log.error(e.getMessage());
        }
        return connection;
    }

    public String primaryKeyColumnName(DatabaseMetaData metaData, String tableName) throws SQLException {
        String primaryKeyColumnName = null;
        ResultSet primaryKeyResultSet = metaData.getPrimaryKeys(null, null, tableName);
        while (primaryKeyResultSet.next()) {
            primaryKeyColumnName = primaryKeyResultSet.getString("COLUMN_NAME");
            break;
        }
        if (primaryKeyColumnName == null) {
            primaryKeyColumnName = "id";
        }
        return primaryKeyColumnName;
    }

    public List<TableInfo> getAllTables(DatabaseMetaData metaData, List<String> tableNames, boolean mapUnderscoreToCamelCase, Map<String, String> columnOverrides)
            throws SQLException {
        List<TableInfo> tables = new ArrayList<TableInfo>();
        ResultSet tableRet = getTableResultSet(metaData);
        while (tableRet.next()) {
            TableInfo tableInfo = new TableInfo();
            String dbTableName = tableRet.getString("TABLE_NAME");
            String dbTableDesc = tableRet.getString("REMARKS");
            log.info("tableName:" + dbTableName + " tableDesc:" + dbTableDesc);
            for (String tableName : tableNames) {
                if (tableName.equals("all") || dbTableName.trim().equals(tableName)) {
                    List<ColumnInfo> tableColumns = getTableColumns(metaData, dbTableName);
                    TreeSet<String> packages = new TreeSet<String>();
                    LinkedHashMap<String, Object> columnsWarp = columnsWarp(tableColumns, packages, mapUnderscoreToCamelCase, columnOverrides);
                    LinkedHashMap<String, String> properties = (LinkedHashMap<String, String>) columnsWarp.get("properties");
                    LinkedHashMap<String, BeanInfo> beanInfos = (LinkedHashMap<String, BeanInfo>) columnsWarp.get("beanInfos");
                    LinkedHashMap<String, String> propertiesToColumns = (LinkedHashMap<String, String>) columnsWarp.get("propertiesToColumns");
                    String primaryKey = primaryKeyColumnName(metaData, dbTableName);
                    String primaryKeyProperty = primaryKey;
                    if (columnOverrides.get("column") != null && columnOverrides.get("column").contains(primaryKey)) {
                        List overridesColumn = Arrays.asList(columnOverrides.get("column").split(","));
                        int pos = overridesColumn.indexOf(primaryKey);
                        if (-1 != pos) {
                            List overridesProperty = Arrays.asList(columnOverrides.get("property").split(","));
                            primaryKeyProperty = (String) overridesProperty.get(pos);
                        }
                    } else if (mapUnderscoreToCamelCase) {
                        primaryKeyProperty = StringUtils.underline2Camel2(primaryKey);
                    }
                    LinkedHashMap<String, BeanInfo> primaryKeyMap = new LinkedHashMap<String, BeanInfo>();
                    for (BeanInfo beanInfo : beanInfos.values()) {
                        if (beanInfo.getPropertyName().equals(primaryKeyProperty)) {
                            primaryKeyMap.put(primaryKeyProperty, beanInfo);
                            break;
                        }
                    }
                    String beanName = getClassName(dbTableName, mapUnderscoreToCamelCase);
                    tableInfo.setRefBeanName(toLowerCaseFirstOne(beanName));
                    tableInfo.setTableName(dbTableName);
                    tableInfo.setTableDesc(dbTableDesc);
                    tableInfo.setColumns(tableColumns);
                    tableInfo.setBeanName(beanName);
                    tableInfo.setDomain(beanName + "Vo");
                    tableInfo.setProperties(properties);
                    tableInfo.setBeanInfos(beanInfos);
                    tableInfo.setPrimaryKey(primaryKeyMap);
                    tableInfo.setPackages(packages);
                    tableInfo.setPropertiesToColumns(propertiesToColumns);
                    tables.add(tableInfo);
                }
            }
        }
        return tables;
    }

    private LinkedHashMap<String, Object> columnsWarp(List<ColumnInfo> columns, Set<String> packages, boolean mapUnderscoreToCamelCase, Map<String, String> columnOverrides) {
        LinkedHashMap<String, String> properties = new LinkedHashMap<String, String>();
        LinkedHashMap<String, BeanInfo> beanInfos = new LinkedHashMap<String, BeanInfo>();
        LinkedHashMap<String, String> propertiesToColumns = new LinkedHashMap<String, String>();

        for (ColumnInfo entry : columns) {
            String columnName = entry.getColumnName();
            String columnType = entry.getColumnType();
            String columnRemarks = entry.getColumnRemarks();
            String propertyName = columnName;
            if (columnOverrides.get("column") != null && columnOverrides.get("column").contains(columnName)) {
                List overridesColumn = Arrays.asList(columnOverrides.get("column").split(","));
                int pos = overridesColumn.indexOf(columnName);
                if (-1 != pos) {
                    List overridesProperty = Arrays.asList(columnOverrides.get("property").split(","));
                    propertyName = (String) overridesProperty.get(pos);
                }
            } else if (mapUnderscoreToCamelCase) {
                propertyName = StringUtils.underline2Camel2(columnName);
            }
            String propertyType = getFieldType(columnType, packages);
            properties.put(propertyName, propertyType);
            BeanInfo beanInfo = new BeanInfo();
            beanInfo.setColumnName(columnName);
            beanInfo.setColumnType(columnType);
            beanInfo.setPropertyName(propertyName);
            beanInfo.setPropertyType(propertyType);
            beanInfo.setPropertyDesc(columnRemarks);
            beanInfos.put(beanInfo.getPropertyName(), beanInfo);
            propertiesToColumns.put(propertyName, columnName);
        }

        LinkedHashMap<String, Object> columnsWarp = new LinkedHashMap<String, Object>();
        columnsWarp.put("properties", properties);
        columnsWarp.put("beanInfos", beanInfos);
        columnsWarp.put("propertiesToColumns", propertiesToColumns);
        return columnsWarp;
    }

    public List<ColumnInfo> getTableColumns(DatabaseMetaData metaData, String tableName) throws SQLException {
        String columnName;
        String columnType;
        String remarks;
        ResultSet colRet = metaData.getColumns(null, null, tableName, null);
        List<ColumnInfo> columns = new ArrayList<ColumnInfo>();
        while (colRet.next()) {
            columnName = colRet.getString("COLUMN_NAME");
            columnType = colRet.getString("TYPE_NAME");
            int datasize = colRet.getInt("COLUMN_SIZE");
            int digits = colRet.getInt("DECIMAL_DIGITS");
            int nullable = colRet.getInt("NULLABLE");
            remarks = colRet.getString("remarks");
            ColumnInfo columnInfo = new ColumnInfo();
            columnInfo.setColumnName(columnName);
            columnInfo.setColumnType(columnTypeNameConvert(columnType));
            columnInfo.setColumnRemarks(remarks);
            columns.add(columnInfo);
            log.info(columnInfo.toString());
        }
        return columns;
    }

    private String columnTypeNameConvert(String columnType) {
        if (columnType.toLowerCase().equals("int") || columnType.toLowerCase().equals("int unsigned")) {
            return "INTEGER";

        } else if (columnType.toLowerCase().equals("tinyint unsigned")) {
            return "TINYINT";
        } else if (columnType.toLowerCase().equals("smallint unsigned")) {
            return "SMALLINT";
        } else if (columnType.toLowerCase().equals("mediumint unsigned")) {
            return "BIGINT";
        } else if (columnType.toLowerCase().equals("bigint unsigned")) {
            return "BIGINT";
        } else if (columnType.toLowerCase().equals("text") || columnType.toLowerCase().equals("tinytext") || columnType.toLowerCase().equals("mediumtext") || columnType.toLowerCase().equals("longtext")) {
            return "LONGVARCHAR";
        } else if (columnType.toLowerCase().equals("datetime")) {
            return "TIMESTAMP";
        }
        return columnType;
    }

    public ResultSet getTableResultSet(DatabaseMetaData metaData) throws SQLException {
        return getTableResultSet(metaData, "%");

    }

    public ResultSet getTableResultSet(DatabaseMetaData metaData, String tableName) throws SQLException {
        ResultSet tableRet = metaData.getTables(null, null, tableName, new String[]{"TABLE"});
        return tableRet;
    }

    public DatabaseMetaData getMetaData(Connection connection) throws SQLException {
        DatabaseMetaData metaData = connection.getMetaData();
        return metaData;
    }

    public static String getClassName(String tableName, boolean underline2Camel) {
        String res = removePrefix(tableName);

        if (underline2Camel) {
            res = StringUtils.underline2Camel2(res);
        }
        res = res.substring(0, 1).toUpperCase() + res.substring(1);
        return res;
    }

    private static String removePrefix(String tableName){
        String str = org.apache.commons.lang3.StringUtils.EMPTY;
        if(tableName.startsWith("hd_")){
            str = tableName.substring(3,tableName.length());
        }
        return str;
    }

    public static String toLowerCaseFirstOne(String s){
        if(Character.isLowerCase(s.charAt(0)))
            return s;
        else
            return (new StringBuilder()).append(Character.toLowerCase(s.charAt(0))).append(s.substring(1)).toString();
    }


    public static String getFieldType(String columnType, Set<String> packages) {

        columnType = columnType.toLowerCase();
        if (columnType.equals("varchar") || columnType.equals("nvarchar") || columnType.equals("char")
                || columnType.equals("text") || columnType.equals("mediumtext") || columnType.equals("tinytext") || columnType.equals("longtext") || columnType.equals("longvarchar")) {
            return "String";
        } else if (columnType.equals("tinyblob") || columnType.equals("blob") || columnType.equals("mediumblob")
                || columnType.equals("longblob")) {
            return "byte[]";
        } else if (columnType.equals("datetime") || columnType.equals("date") || columnType.equals("timestamp")
                || columnType.equals("time") || columnType.equals("year")) {
            packages.add("import java.util.Date;");
            return "Date";
        } else if (columnType.equals("int") || columnType.equals("tinyint") || columnType.equals("integer") || columnType.equals("smallint")) {
            return "Integer";
        } else if (columnType.equals("bit")) {
            return "Boolean";
        } else if (columnType.equals("int unsigned")) {
            return "Integer";
        } else if (columnType.equals("bigint unsigned")) {
            packages.add("import java.math.BigInteger;");
            return "BigInteger";
        } else if (columnType.equals("bigint")) {
            return "Long";
        } else if (columnType.equals("float")) {
            return "Float";
        } else if (columnType.equals("double")) {
            return "Double";
        } else if (columnType.equals("decimal")) {
            packages.add("import java.math.BigDecimal;");
            return "BigDecimal";
        }
        return "ErrorType";
    }

}
