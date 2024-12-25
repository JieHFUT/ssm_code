package com.jiehfut.assmexample.config;


import com.jiehfut.assmexample.bean.SpringLifeCycle;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringLifeCycleConfig {


    /**
     * 声明组件的生命周期
     * @return
     */
    @Bean(value = "s-lifecycle", initMethod = "initLifeCycle", destroyMethod = "destroyLifeCycle")
    public SpringLifeCycle springLifeCycle() {
        return new SpringLifeCycle();
    }




}
