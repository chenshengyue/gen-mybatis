package com.csy.mybatis.creator;

import com.csy.mybatis.bean.Config;
import com.csy.mybatis.bean.TableInfo;
import freemarker.template.Template;
import freemarker.template.TemplateException;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;


public class MapperCreator extends AbstractFileCreator {

    private static MapperCreator creator;

    private MapperCreator() {
        super();
    }

    private MapperCreator(Config config) {
        super();
        init(config);
    }

    public static synchronized MapperCreator getInstance(Config config) {
        if (null == creator) {
            creator = new MapperCreator(config);
        }
        return creator;
    }

    @Override
    public void createFile(TableInfo tableInfo) throws IOException, TemplateException {
        String ftl = "mapper.ftl";
        String fileName = tableInfo.getBeanName() + "Dao.xml";
        String selfPath = config.getMapper();
        config.setForceReCreate(true);
        Map<String, Object> root = new HashMap<String, Object>();
        root.put("user", user);
        root.put("table", tableInfo);
        root.put("config", config);
        Template template = cfg.getTemplate(ftl);
        fileName = javaPath + selfPath + separator + fileName;
        createFile(fileName, root, template);
    }

}
