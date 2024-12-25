package com.jiehfut.assmexample.config;

import com.jiehfut.assmexample.bean.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration   // 告诉 spring 这是一个配置类
public class PersonConfig {

    /**
     3.在容器中注册自己的组件
     容器中的每一个组件都有自己的名字，方法名字就是组件的名字（注解的 value 值会覆盖方法名）
     */
    @Bean("person")
    public Person personBean() {
        Person person = new Person();
        person.setName("person");
        person.setAge(0);
        person.setGender("男");
        return person;
    }
    @Bean("zhangsan")
    public Person zhangsanBean() {
        Person person = new Person();
        person.setName("zhangsan");
        person.setAge(0);
        person.setGender("男");
        return person;
    }
    @Bean("lisi")
    public Person lisiBean() {
        Person person = new Person();
        person.setName("lisi");
        person.setAge(0);
        person.setGender("男");
        return person;
    }



}
