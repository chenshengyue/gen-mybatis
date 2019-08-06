package com.csy.mybatis.creator;

import com.csy.mybatis.bean.Config;
import com.csy.mybatis.bean.TableInfo;
import freemarker.template.Template;
import freemarker.template.TemplateException;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;


public class DaoCreator extends AbstractFileCreator {

    private static DaoCreator creator;

    private DaoCreator() {
        super();
    }

    private DaoCreator(Config config) {
        super();
        init(config);
    }

    public static synchronized DaoCreator getInstance(Config config) {
        if (null == creator) {
            creator = new DaoCreator(config);
        }
        return creator;
    }

    @Override
    public void createFile(TableInfo tableInfo) throws IOException, TemplateException {

        String ftl = "Dao.ftl";
        String fileName = tableInfo.getBeanName() + "Dao.java";
        String selfPath = config.getDao();
        Map<String, Object> root = new HashMap<String, Object>();
        root.put("user", user);
        root.put("table", tableInfo);
        root.put("config", config);
        Template template = cfg.getTemplate(ftl);
        fileName = javaPath + selfPath + separator + fileName;
        createFile(fileName, root, template);


    }
}
