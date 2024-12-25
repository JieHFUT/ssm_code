package com.jiehfut.assmexample.bean;


import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Data
@Component
@PropertySource("classpath:conf/horse.properties") // 声明配置数据来源
                                              // @PropertySource 的意思就是把指定的文件导入容器中，可以将注解放在 app.config 中
public class Horse {

    /**
     * 使用 ":" 是取不到使用默认值
     */
    @Value("${horse.id:888}")
    private int id;

    @Value("${horse.name:tiaotiao}")
    private String name;

    @Value("${horse.age:6}")
    private int age;

    /**
     * 1.classpath:horse.properties 是从自己的项目类路径中去找
     * 2.classpath*:Log4j-charsets.properties 是从所有包的类路径下找
     */


}
