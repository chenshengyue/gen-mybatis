package com.csy.mybatis.creator;

import com.csy.mybatis.Column;
import com.csy.mybatis.bean.ConditionInfo;
import com.csy.mybatis.bean.Config;
import com.csy.mybatis.bean.TableInfo;
import freemarker.template.Template;
import freemarker.template.TemplateException;

import java.io.IOException;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;


public class QueryCreator extends AbstractFileCreator {

    private static QueryCreator creator;

    private QueryCreator() {
        super();
    }

    private QueryCreator(Config config) {
        super();
        init(config);
    }

    public static synchronized QueryCreator getInstance(Config config) {
        if (null == creator) {
            creator = new QueryCreator(config);
        }
        return creator;
    }

    @Override
    public void createFile(TableInfo tableInfo) throws IOException, TemplateException, ClassNotFoundException {

        String fileName = tableInfo.getBeanName() + "Query.java";
        String selfPath = config.getQuery();
        String filePath = javaPath + selfPath + separator + fileName;

        boolean flag = true;
        Class<?> clazz = null;
        try {
            clazz = Class.forName(config.getBasePackage() + "." + config.getQuery() + "." + tableInfo.getBeanName() + "Query");
        }catch (Exception e) {
            flag = false;
        }

        if (flag) {

            for(Field field : clazz.getDeclaredFields()) {
                Column column = field.getAnnotation(Column.class);
                if (column == null) {
                    continue;
                }

                ConditionInfo queryCondition = new ConditionInfo();
                queryCondition.setColumnName(column.column());
                queryCondition.setPropertyName(field.getName());
                queryCondition.setAction(column.action().getAction());
                setQueryXmlSql(queryCondition);
                tableInfo.getQueryConditionInfos().add(queryCondition);

                ConditionInfo pageCondition = new ConditionInfo();
                pageCondition.setColumnName(column.column());
                pageCondition.setAction(column.action().getAction());
                pageCondition.setPropertyName(field.getName());
                setPageXmlSql(pageCondition);
                tableInfo.getPageConditionInfos().add(pageCondition);
            }
            return;
        }

        String ftl = "query.ftl";

        Map<String, Object> root = new HashMap<String, Object>();
        root.put("user", user);
        root.put("table", tableInfo);
        root.put("config", config);
        Template template = cfg.getTemplate(ftl);

        createFile(filePath, root, template);

    }

}
