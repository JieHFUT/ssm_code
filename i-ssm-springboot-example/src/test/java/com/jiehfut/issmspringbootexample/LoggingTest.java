package com.jiehfut.issmspringbootexample;


import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;



@Slf4j
@SpringBootTest
public class LoggingTest {

    // 1.获取一个日志记录器（指定哪个类的）
    Logger logger = LoggerFactory.getLogger(LoggingTest.class);

    @Test
    public void testLogging(){
        /** 2.记录日志
        System.out.println("=========== 日志 =========");
        logger.trace("这是一个日志：Trace");
        logger.debug("这是一个日志：Debug");
        logger.info("这是一个日志：Info");
        logger.warn("这是一个日志：Warn");
        logger.error("这是一个日志：Error"); */

        log.trace("这是一个日志：Trace");
        log.debug("这是一个日志：Debug");
        log.info("这是一个日志：Info");
        log.warn("这是一个日志：Warn");
        log.error("这是一个日志：Error");

        /**
         ****** 日志级别：all trace debug info warn error off ******
         ****** 默认日志基本是 info，只会打印默认级别及其之上的所有信息
         ****** 默认日志级别需要在全局配置里面调整根级别：logging.level.root=
         ****** 如果哪个类或者包不说日志级别，就会使用默认的根级别
         *
         2025-01-15T12:07:41.127+08:00  WARN 14652 --- [i-ssm-springboot-example] [           main] ion$DefaultTemplateResolverConfiguration : Cannot find template location: classpath:/templates/ (please add some templates, check your Thymeleaf configuration, or set spring.thymeleaf.check-template-location=false)
         2025-01-15T12:07:41.428+08:00  INFO 14652 --- [i-ssm-springboot-example] [           main] c.j.issmspringbootexample.LoggingTest    : Started LoggingTest in 2.593 seconds (process running for 3.933)
         Java HotSpot(TM) 64-Bit Server VM warning: Sharing is only supported for boot loader classes because bootstrap classpath has been appended
         =========== 日志 =========
         2025-01-15T12:07:42.439+08:00  INFO 14652 --- [i-ssm-springboot-example] [           main] c.j.issmspringbootexample.LoggingTest    : 这是一个日志：Info
         2025-01-15T12:07:42.439+08:00  WARN 14652 --- [i-ssm-springboot-example] [           main] c.j.issmspringbootexample.LoggingTest    : 这是一个日志：Warn
         2025-01-15T12:07:42.439+08:00 ERROR 14652 --- [i-ssm-springboot-example] [           main] c.j.issmspringbootexample.LoggingTest    : 这是一个日志：Error
         2025-01-15T12:07:42.469+08:00  INFO 14652 --- [i-ssm-springboot-example] [ionShutdownHook] com.alibaba.druid.pool.DruidDataSource   : {dataSource-0} closing ...

         */
    }
}
