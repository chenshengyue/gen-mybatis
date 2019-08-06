package com.csy.mybatis;

import com.csy.mybatis.bean.Config;
import com.csy.mybatis.creator.*;

public class SimpleFactory {
    private SimpleFactory() {
        super();
    }

    public static FileCreator create(String module, Config config) {

        FileCreator creator = null;
        if (module.equals("bean")) {
            creator = BeanCreator.getInstance(config);
        } else if (module.equals("query")) {
            creator = QueryCreator.getInstance(config);
        } else if (module.equals("update")) {
            creator = UpdateCreator.getInstance(config);
        } else if (module.equals("dao")) {
            creator = DaoCreator.getInstance(config);
        } else if (module.equals("mapper")) {
            creator = MapperCreator.getInstance(config);
        } else if (module.equals("manager")) {
            creator = ManagerCreator.getInstance(config);
        } else if (module.equals("managerImpl")) {
            creator = ManagerImplCreator.getInstance(config);
        }
        return creator;
    }

    public static void main(String[] args) {
        
    }
}
