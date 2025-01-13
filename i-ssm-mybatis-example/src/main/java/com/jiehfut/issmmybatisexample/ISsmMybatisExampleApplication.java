package com.jiehfut.issmmybatisexample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 1.导入 mybatis 的依赖
 * 2.配置数据源信息
 * 3.编写一个 javaBean 对应数据库模型
 * 4.Dao接口 => DaoImpl实现 - @Repository 注解
 *   Mapper接口 => Mapper.xml - @Mapper注解
 * 5.在 application.properties 配置 .xml 路径
 *
 *
 */
@SpringBootApplication
public class ISsmMybatisExampleApplication {

    public static void main(String[] args) {
        SpringApplication.run(ISsmMybatisExampleApplication.class, args);
    }



}
