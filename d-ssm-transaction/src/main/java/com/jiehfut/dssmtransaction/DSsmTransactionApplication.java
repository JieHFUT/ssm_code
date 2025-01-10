package com.jiehfut.dssmtransaction;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


/**
 * 1.导入包 spring-boot-starter-jdbc && mysql-connector-j
 * 2.配置数据库连接信息 application.properties
 * 3.容器中即可使用组件 DataSource && JdbcTemplate
 *
 *
 */
@SpringBootApplication
public class DSsmTransactionApplication {

    public static void main(String[] args) {
        SpringApplication.run(DSsmTransactionApplication.class, args);
    }

}
