package com.csy.mybatis.creator;

import com.csy.mybatis.ColumnAction;
import com.csy.mybatis.bean.ConditionInfo;
import com.csy.mybatis.bean.Config;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import freemarker.template.TemplateExceptionHandler;
import lombok.extern.slf4j.Slf4j;

import java.io.*;
import java.util.Map;

@Slf4j
public abstract class AbstractFileCreator implements FileCreator {

    protected static Configuration cfg;
    protected static String javabasePath = new StringBuilder().append(System.getProperty("user.dir")).append(separator).append("src").append(separator).append("main").append(separator).append("java").append(separator).toString();
    protected static String user = new StringBuilder().append(System.getProperty("user.name")).toString();

    protected static String javaPath;
    protected static Config config = null;

    static {
        cfg = new Configuration(Configuration.VERSION_2_3_22);
        cfg.setClassLoaderForTemplateLoading(AbstractFileCreator.class.getClassLoader(), "templates");
        cfg.setDefaultEncoding("UTF-8");
        cfg.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);

    }

    protected boolean exitFile(String filePath) {
        String subPath = filePath.substring(0, filePath.lastIndexOf(separator));
        File file = new File(subPath);
        return file.exists();
    }

    protected void createFile(String filePath, Map<String, Object> root, Template template) throws IOException, TemplateException {

        boolean force = config.isForceReCreate();
        String subPath = filePath.substring(0, filePath.lastIndexOf(separator));;

        File directory = new File(subPath);
        if (!directory.exists()) {
            directory.mkdirs();
        }

        File file = new File(filePath);
        log.info(" file path =" + filePath);
        boolean needCreatFile = false;
        if (!file.exists()) {
            file.createNewFile();
            needCreatFile = true;
        } else {
            if (force) {
                file.delete();
//                file.createNewFile();
                needCreatFile = true;
            }
        }
        if (needCreatFile) {
            OutputStream os = new FileOutputStream(file);
            Writer out = new OutputStreamWriter(os);
            template.process(root, out);
        }
    }

    protected void setQueryXmlSql(ConditionInfo condition) {
        this.setXmlSql(condition, "query");
    }

    protected void setPageXmlSql(ConditionInfo condition) {
        this.setXmlSql(condition, "param1");
    }

    protected void setUpdateXmlSql(ConditionInfo condition) {
        this.setXmlSql(condition, "condition");
    }

    protected void setXmlSql(ConditionInfo condition, String type) {
        type = type + ".";
        String xmlSql = "";
        if (ColumnAction.IN.getAction().equals(condition.getAction())) {
            xmlSql = "and "+ condition.getColumnName() + " in\n" +
                     "                <foreach item=\"item\" collection=\""+ type + condition.getPropertyName() +"\" open=\"(\" separator=\",\" close=\")\">\n" +
                     "                    #{item}\n" +
                     "                </foreach>";
        }
        if (ColumnAction.NOT_IN.getAction().equals(condition.getAction())) {
            xmlSql = "and "+ condition.getColumnName() + " not in\n" +
                     "                <foreach item=\"item\" collection=\""+ type + condition.getPropertyName() +"\" open=\"(\" separator=\",\" close=\")\">\n" +
                     "                    #{item}\n" +
                     "                </foreach>";
        }
        if (ColumnAction.IS_NULL.getAction().equals(condition.getAction())) {
            xmlSql = "and "+ condition.getColumnName() + " is null";
        }
        if (ColumnAction.IS_NOT_NUll.getAction().equals(condition.getAction())) {
            xmlSql = "and "+ condition.getColumnName() + " is not null";
        }
        if (ColumnAction.NOT_EQUAL_TO.getAction().equals(condition.getAction())) {
            xmlSql = "and "+ condition.getColumnName() + " != #{" + type + condition.getPropertyName() + "}";
        }
        if (ColumnAction.EQUAL_TO.getAction().equals(condition.getAction())) {
            xmlSql = "and "+ condition.getColumnName() + " = #{" + type + condition.getPropertyName() + "}";
        }
        if (ColumnAction.GREATER_THAN.getAction().equals(condition.getAction())) {
            xmlSql = "and "+ condition.getColumnName() + " &gt; #{" + type + condition.getPropertyName() + "}";
        }
        if (ColumnAction.GREATER_THAN_OR_EQUAL_TO.getAction().equals(condition.getAction())) {
            xmlSql = "and "+ condition.getColumnName() + " &gt;= #{" + type + condition.getPropertyName() + "}";
        }
        if (ColumnAction.LESS_THAN.getAction().equals(condition.getAction())) {
            xmlSql = "and "+ condition.getColumnName() + " &lt; #{" + type + condition.getPropertyName() + "}";
        }
        if (ColumnAction.LESS_THAN_OR_EQUAL_TO.getAction().equals(condition.getAction())) {
            xmlSql = "and "+ condition.getColumnName() + " &lt;= #{" + type + condition.getPropertyName() + "}";
        }
        if (ColumnAction.Like.getAction().equals(condition.getAction())) {
            xmlSql = "and "+ condition.getColumnName() + " like concat('%',#{" + type + condition.getPropertyName() + "},'%')";
        }

        condition.setXmlSql(xmlSql);
    }

    public static void init(Config _config) {
        if (config == null) {
            config = _config;
            javaPath = javabasePath + config.getBasePackage().replace(".", separator) + separator;
        }
    }
}
