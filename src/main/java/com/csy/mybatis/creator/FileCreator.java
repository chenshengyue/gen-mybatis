package com.csy.mybatis.creator;

import com.csy.mybatis.bean.TableInfo;
import freemarker.template.TemplateException;

import java.io.File;
import java.io.IOException;


public interface FileCreator {

    String separator = File.separator;

    void createFile(TableInfo tableInfo) throws IOException, TemplateException, ClassNotFoundException;

}
