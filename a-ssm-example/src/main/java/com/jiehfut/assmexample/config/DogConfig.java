package com.jiehfut.assmexample.config;

import com.jiehfut.assmexample.bean.Dog;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class DogConfig {

    @Bean("dog")
    public Dog dogBean() {
        System.out.println("正在创建 Dog 组件...");
        Dog dog = new Dog();
        dog.setName("dog");
        return dog;
    }
}
