package com.jiehfut.assmexample.config;


import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Configuration
@Import({HashMap.class, ArrayList.class})
@ComponentScan(basePackages = "com.jiehfut")
public class AppConfig {

}
