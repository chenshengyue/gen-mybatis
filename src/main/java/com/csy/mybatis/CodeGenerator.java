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
        List<TableInfo> result = DbUtils.getInstance().getAllTables(connection, metaData, tableNames, mapUnderscoreToCamelCase, config.getColumnOverrides());
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
        config.setBean("entity");
        config.setDao("dao");
        config.setMapper("mapper");
        config.setQuery("query");
        config.setUpdate("update");
        config.setManager("biz.manager");
        config.setManagerImpl("biz.manager.impl");
        config.setMapUnderscoreToCamelCase(true);

        config.setDriverClassName("com.mysql.jdbc.Driver");
        getOsirisOrderConfig(config);
        generator.doGenerator(config);
    }

    private static void getOsirisOrderConfig(Config config){
        config.setUrl("jdbc:mysql://192.168.32.3:3306/haidai_pos?useUnicode=yes&amp;characterEncoding=utf-8&amp;allowMultiQueries=true");
        config.setUsername("osiris");
        config.setPassword("e18e63uialaidai$cahaidai");

        config.setBasePackage("com.seatent.osiris");
        config.setBean("dal.order.entity");
        config.setDao("dal.order.dao");
        config.setManager("biz.order.manager");
        config.setManagerImpl("biz.order.manager.impl");
        config.setQuery("dal.order.query");
        config.setUpdate("dal.order.update");

        config.setTables("hd_pos_deal_record");
    }

    private static void getActivityConfig(Config config){
        config.setUrl("jdbc:mysql://192.168.32.3:3306/haidai_activity?useUnicode=yes&amp;characterEncoding=utf-8&amp;allowMultiQueries=true");
        config.setUsername("activity");
        config.setPassword("16ef76854d3f4a85a68ed360287cbd5d");

        config.setBasePackage("com.seatent.uranus");
        config.setBean("entity.b2c");
        config.setDao("dao.b2c");
        config.setManager("biz.dubbo.manager.b2c");
        config.setManagerImpl("biz.dubbo.manager.impl.b2c");
        config.setTables("hd_b2c_member_poster_goods_ref");
    }

    private static void getGoodsConfig(Config config){
        config.setUrl("jdbc:mysql://192.168.32.3:3306/haidai_goods?useUnicode=yes&amp;characterEncoding=utf-8&amp;allowMultiQueries=true");
        config.setUsername("goods");
        config.setPassword("9023b96cf57d4708b51bbb2fc6510268");

        config.setBasePackage("com.seatent.jupiter");

        config.setTables("hd_goods_word_sharing");
    }



    private static void getStatisticsConfig(Config config){
        config.setUrl("jdbc:mysql://192.168.32.3:3306/haidai_statistics?useUnicode=yes&amp;characterEncoding=utf-8&amp;allowMultiQueries=true");
        config.setUsername("statistics");
        config.setPassword("7ec8b95b25ba4167874ec7a6aa4e76b0");

        config.setBasePackage("com.seatent.statistics");

        config.setTables("hd_statistics_day_b2c_bargain");
    }

    private static void getNeptuneConfig(Config config){
        config.setUrl("jdbc:mysql://192.168.32.3:3306/haidai_member?useUnicode=yes&amp;characterEncoding=utf-8&amp;allowMultiQueries=true");
        config.setUsername("member");
        config.setPassword("6f808273744e4d5188488e1f0ad09ad9");

        config.setBasePackage("com.seatent.neptune");

        config.setTables("hd_b2c_shop_menu_auth");
    }

    private static void getJupiterConfig(Config config){
        config.setUrl("jdbc:mysql://192.168.32.3:3306/haidai_goods?useUnicode=yes&amp;characterEncoding=utf-8&amp;allowMultiQueries=true");
        config.setUsername("goods");
        config.setPassword("9023b96cf57d4708b51bbb2fc6510268");

        config.setBasePackage("com.seatent.jupiter");

        config.setTables("hd_brand");
    }

}
