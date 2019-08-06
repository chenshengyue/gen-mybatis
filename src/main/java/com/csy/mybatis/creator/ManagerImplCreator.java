package com.csy.mybatis.creator;

import com.csy.mybatis.bean.Config;
import com.csy.mybatis.bean.TableInfo;
import freemarker.template.Template;
import freemarker.template.TemplateException;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;


public class ManagerImplCreator extends AbstractFileCreator {

    private static ManagerImplCreator creator;

    private ManagerImplCreator() {
        super();
    }

    private ManagerImplCreator(Config config) {
        super();
        init(config);
    }

    public static synchronized ManagerImplCreator getInstance(Config config) {
        if (null == creator) {
            creator = new ManagerImplCreator(config);
        }
        return creator;
    }

    @Override
    public void createFile(TableInfo tableInfo) throws IOException, TemplateException {

        String fileName = tableInfo.getBeanName() + "ManagerImpl.java";
        String selfPath = config.getManagerImpl();
        String filePath = javaPath + selfPath + separator + fileName;

        String ftl = "managerImpl.ftl";

        Map<String, Object> root = new HashMap<String, Object>();
        root.put("user", user);
        root.put("table", tableInfo);
        root.put("config", config);
        Template template = cfg.getTemplate(ftl);

        createFile(filePath, root, template);

    }

}
