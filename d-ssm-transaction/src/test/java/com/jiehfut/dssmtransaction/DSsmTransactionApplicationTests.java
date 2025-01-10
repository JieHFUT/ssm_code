package com.jiehfut.dssmtransaction;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

@SpringBootTest
class DSsmTransactionApplicationTests {

    @Autowired
    DataSource dataSource;

    @Autowired
    JdbcTemplate jdbcTemplate; // 就是 QueryRunner

    @Test
    void contextLoads() throws SQLException {
        // 测试数据连接
        Connection connection = dataSource.getConnection();
        System.out.println(connection);
        // HikariProxyConnection@267769073 wrapping com.mysql.cj.jdbc.ConnectionImpl@28ce75ec


    }

}
