package com.csy.mybatis.creator;

import com.csy.mybatis.bean.BeanInfo;
import com.csy.mybatis.bean.Config;
import com.csy.mybatis.bean.TableInfo;
import freemarker.template.Template;
import freemarker.template.TemplateException;

import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;


public class BeanCreator extends AbstractFileCreator {

    private static BeanCreator creator;

    private BeanCreator() {
        super();
    }

    private BeanCreator(Config config) {
        super();
        init(config);
    }

    public static synchronized BeanCreator getInstance(Config config) {
        if (null == creator) {
            creator = new BeanCreator(config);
        }
        return creator;
    }

    @Override
    public void createFile(TableInfo tableInfo) throws IOException, TemplateException {

        TableInfo tableInfoClone = tableInfo.clone();
        LinkedHashMap<String, BeanInfo> beanInfos = (LinkedHashMap<String, BeanInfo>) tableInfoClone.getBeanInfos().clone();
        LinkedHashMap<String, String> properties = (LinkedHashMap<String, String>) tableInfoClone.getProperties().clone();
//        for (String key : beDelProperties) {
//            properties.remove(key);
//            beanInfos.remove(key);
//        }

        tableInfoClone.setProperties(properties);
        tableInfoClone.setBeanInfos(beanInfos);
        String ftl = "bean.ftl";
        String fileName = tableInfoClone.getBeanName() + ".java";
        String selfPath = config.getBean();
        config.setForceReCreate(true);
        Map<String, Object> root = new HashMap<String, Object>();
        root.put("user", user);
        root.put("table", tableInfoClone);
        root.put("config", config);
        Template template = cfg.getTemplate(ftl);
        fileName = javaPath + selfPath + separator + fileName;
        createFile(fileName, root, template);

    }

}
