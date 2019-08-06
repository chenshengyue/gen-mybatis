package com.csy.mybatis;

import com.csy.mybatis.bean.Config;
import com.csy.mybatis.bean.TableInfo;
import com.csy.mybatis.creator.FileCreator;
import com.csy.mybatis.utils.DbUtils;
import freemarker.template.TemplateException;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

@Slf4j
public class CodeGenerator {


    public void doGenerator(Config config) throws SQLException, ClassNotFoundException, IOException, TemplateException {
        List<TableInfo> tableInfos = getTableInfos(config);
        log.info("tableInfos ==>" + tableInfos);
        generatorFile(config, tableInfos);
    }

    private List<TableInfo> getTableInfos(Config config) throws ClassNotFoundException, SQLException {
        boolean mapUnderscoreToCamelCase = config.isMapUnderscoreToCamelCase();
        Connection connection = DbUtils.getInstance().getConnection(config.getDriverClassName(), config.getUrl(), config.getUsername(), config.getPassword());
        DatabaseMetaData metaData = DbUtils.getInstance().getMetaData(connection);
        List<String> tableNames = Arrays.asList(config.getTables().split(","));
        List<TableInfo> result = DbUtils.getInstance().getAllTables(metaData, tableNames, mapUnderscoreToCamelCase, config.getColumnOverrides());
        return result;
    }

    private void generatorFile(Config config, List<TableInfo> tableInfos) throws IOException, TemplateException, ClassNotFoundException {
        List<String> modules = config.getModules();
        FileCreator creator = null;
        for (TableInfo tableInfo : tableInfos) {
            for (String module : modules) {
                creator = SimpleFactory.create(module, config);
                if (creator == null) {
                    System.out.println(module + config);
                }
                log.info("generatorFile module = " + module);
                creator.createFile(tableInfo);

            }
        }
    }

    public static void main(String[] args) throws ClassNotFoundException, SQLException, TemplateException, IOException {

        CodeGenerator generator = new CodeGenerator();
        Config config = new Config();
        config.setDriverClassName("com.mysql.jdbc.Driver");
        config.setUrl("jdbc:mysql://192.168.32.3:3306/haidai_activity?useUnicode=yes&amp;characterEncoding=utf-8&amp;allowMultiQueries=true");
        config.setUsername("activity");
        config.setPassword("16ef76854d3f4a85a68ed360287cbd5d");

        config.setBasePackage("com.seatent.uranus");
        config.setBean("entity.b2c");
//        config.setDomain("domain");
        config.setDao("dao.b2c");
        config.setMapper("mapper");
        config.setQuery("query");
        config.setUpdate("update");
        config.setManager("biz.dubbo.manager.b2c");
        config.setManagerImpl("biz.dubbo.manager.impl.b2c");
        config.setMapUnderscoreToCamelCase(true);

        config.setTables("hd_b2c_bargain_info");

        generator.doGenerator(config);
    }

}
