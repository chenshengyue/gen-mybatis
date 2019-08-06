package com.csy.mybatis.bean;

import lombok.Getter;
import lombok.Setter;

import java.util.*;

@Getter
@Setter
public class Config {

    private static List allModules = Arrays.asList("bean", "query", "update", "dao", "mapper", "manager", "managerImpl");

    private String driverClassName;
    private String url;
    private String username;
    private String password;

    private String basePackage;
    private String bean;
    private String query;
    private String update;
    private String domain;
    private String dao;
    private String daoImpl;
    private String mapper;
    private String service;
    private String serviceImpl;
    private String controller;
    private String manager;
    private String managerImpl;
    private String tables;
    private String generatorModules;
    private List<String> modules;
    boolean forceReCreate;
    boolean mapUnderscoreToCamelCase;
    private Map columnOverrides = new HashMap();

    public List<String> getModules() {
        List<String> modules;
        String generatorModules = getGeneratorModules();
        if (null == generatorModules || generatorModules.equals("all")) {
            modules = allModules;
        } else {
            modules = Arrays.asList(generatorModules.split(","));
        }
        return modules;
    }

}
