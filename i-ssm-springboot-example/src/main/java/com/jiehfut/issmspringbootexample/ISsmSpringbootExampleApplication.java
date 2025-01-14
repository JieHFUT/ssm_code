package com.jiehfut.issmspringbootexample;

import com.jiehfut.issmspringbootexample.properties.DogProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
// @EnableConfigurationProperties(DogProperties.class) 开始该类的属性绑定并且将其注入容器中
public class ISsmSpringbootExampleApplication {

    public static void main(String[] args) {
        SpringApplication.run(ISsmSpringbootExampleApplication.class, args);
    }
    
}
