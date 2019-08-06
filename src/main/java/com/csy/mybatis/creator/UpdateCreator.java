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


public class UpdateCreator extends AbstractFileCreator {

    private static UpdateCreator creator;

    private UpdateCreator() {
        super();
    }

    private UpdateCreator(Config config) {
        super();
        init(config);
    }

    public static synchronized UpdateCreator getInstance(Config config) {
        if (null == creator) {
            creator = new UpdateCreator(config);
        }
        return creator;
    }

    @Override
    public void createFile(TableInfo tableInfo) throws IOException, TemplateException, ClassNotFoundException {

        String fileName = tableInfo.getBeanName() + "Update.java";
        String selfPath = config.getUpdate();
        String filePath = javaPath + selfPath + separator + fileName;

        boolean flag = true;
        Class<?> clazz = null;
        try {
            clazz = Class.forName(config.getBasePackage() + "." + config.getUpdate() + "." + tableInfo.getBeanName() + "Update");
        }catch (Exception e) {
            flag = false;
        }
        if (flag) {

            for(Field field : clazz.getDeclaredFields()) {
                Column column = field.getAnnotation(Column.class);
                if (column == null) {
                    continue;
                }

                ConditionInfo update = new ConditionInfo();
                update.setAction(column.action().getAction());
                update.setPropertyName(field.getName());
                update.setColumnName(column.column());
                setUpdateXmlSql(update);
                tableInfo.getUpdateConditionInfos().add(update);

            }
            return;
        }

        String ftl = "update.ftl";

        Map<String, Object> root = new HashMap<String, Object>();
        root.put("user", user);
        root.put("table", tableInfo);
        root.put("config", config);
        Template template = cfg.getTemplate(ftl);

        createFile(filePath, root, template);
    }
}
