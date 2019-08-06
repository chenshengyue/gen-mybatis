package com.csy.mybatis.creator;

import com.csy.mybatis.bean.Config;
import com.csy.mybatis.bean.TableInfo;
import freemarker.template.Template;
import freemarker.template.TemplateException;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;


public class ManagerCreator extends AbstractFileCreator {

    private static ManagerCreator creator;

    private ManagerCreator() {
        super();
    }

    private ManagerCreator(Config config) {
        super();
        init(config);
    }

    public static synchronized ManagerCreator getInstance(Config config) {
        if (null == creator) {
            creator = new ManagerCreator(config);
        }
        return creator;
    }

    @Override
    public void createFile(TableInfo tableInfo) throws IOException, TemplateException {

        String fileName = tableInfo.getBeanName() + "Manager.java";
        String selfPath = config.getManager();
        String filePath = javaPath + selfPath + separator + fileName;

        String ftl = "manager.ftl";

        Map<String, Object> root = new HashMap<String, Object>();
        root.put("user", user);
        root.put("table", tableInfo);
        root.put("config", config);
        Template template = cfg.getTemplate(ftl);

        createFile(filePath, root, template);

    }

}
