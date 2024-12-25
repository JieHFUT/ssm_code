package com.jiehfut.assmexample.bean;


import lombok.Data;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;

@Data
public class SpringLifeCycle implements InitializingBean, DisposableBean {

    private int id;
    private String name;

    /**
     * 如果该组件中需要注入一些组件
     * 是什么时候进行依赖注入的呢？
     */
    public Car car;
    @Autowired
    public void setCar(Car car) {
        System.out.println("SpringLifeCycle 进行依赖注入" + car);
        this.car = car;
    }


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


    /**
     * InitializingBean 接口中的方法
     * 在属性设置之后进行调用，即在所有的 setter 方法赋值完成之后
     * @throws Exception
     */
    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("InitializingBean 接口中的方法，在所有的赋值完成之后执行：afterPropertiesSet ");
    }

    /**
     * DisposableBean 接口中的方法
     * 在组件被销毁之前被调用
     * @throws Exception
     */
    @Override
    public void destroy() throws Exception {
        System.out.println("DisposableBean 接口中的方法，在所有的赋值完成之后执行：destroy ");
    }
}
