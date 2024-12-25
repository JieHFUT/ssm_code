package com.jiehfut.assmexample.bean;


import lombok.Data;

@Data
public class SpringLifeCycle {

    private int id;
    private String name;


    public SpringLifeCycle() {
        System.out.println("SpringLifeCycle 的无参构造器方法...");
    }


    // 该组件 s-lifecycle 的初始化方法
    public void initLifeCycle() {
        System.out.println("@bean 创建的 s-lifecycle 组件的初始化方法");

    }

    // 该组件 s-lifecycle 的销毁方法
    public void destroyLifeCycle() {
        System.out.println("@bean 创建的 s-lifecycle 组件的销毁方法");

    }





}
