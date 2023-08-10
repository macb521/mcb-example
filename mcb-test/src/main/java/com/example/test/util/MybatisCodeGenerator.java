package com.example.test.util;

import cn.hutool.core.collection.ListUtil;
import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.OutputFile;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;
import com.example.test.base.BaseModel;

import java.util.Collections;
import java.util.List;

/**
 * @author chunbo.ma.o
 * @since 2023/8/10
 */
public class MybatisCodeGenerator {


    public static void main(String[] args) {
        //db
        String dbUrl = "jdbc:mysql://dd-mysql-01-dev.nioint.com:3306/ndplm_vts_dev?useUnicode=true&characterEncoding=UTF-8&zeroDateTimeBehavior=convertToNull&allowMultiQueries=true";
        String account = "ndplm_vts_dev_rw";
        String pwd = "ph7eHUxrGSp9RQAkXVdJ";
        String author = "chunbo.ma";
        //项目路径
        String projectPath = System.getProperty("user.dir");
        //basePage
        String basePage = "com.example.test";
        //模块名，必填
        String moduleName = "mcb-test";
        //需要生成的表名，必填
        List<String> tables = ListUtil.toList("ps_vts_attachment");
        //去除表前缀，非必填
        String offSetTablePrefix = "ps_";
        FastAutoGenerator.create(dbUrl, account, pwd)
                .globalConfig(builder -> builder
                        .author(author)
                        .outputDir(projectPath.concat("/")
                                .concat(moduleName) + "/src/main/java"))
                .packageConfig(builder -> builder
                        .parent(basePage)
                        .controller("controller")
                        .service("service")
                        .serviceImpl("service.impl")
                        .entity("domain.entity")
                        .mapper("domain.mapper")
                        .xml("mapper")
                        .pathInfo(Collections.singletonMap(OutputFile.xml, projectPath + "/" + moduleName + "/src/main/resources/mapper/"))
                        .build())
                .strategyConfig(builder -> builder
                        .addInclude(tables)
                        .addTablePrefix(offSetTablePrefix)
                        .entityBuilder()
                        .enableTableFieldAnnotation()
                        .disableSerialVersionUID()
                        .enableLombok()
                        .enableChainModel()
                        .superClass(BaseModel.class)
                        .addIgnoreColumns("id", "delete_status", "create_time", "create_account", "update_account", "update_time", "lessee_code")
                        .controllerBuilder()
                        .enableRestStyle()
                        .serviceBuilder()
                        .formatServiceImplFileName("%sServiceImpl")
                        .formatServiceFileName("%sService")
                        .mapperBuilder()
                        .enableBaseColumnList()
                        .enableBaseResultMap())
                .templateEngine(new FreemarkerTemplateEngine())
                .execute();
    }
}
