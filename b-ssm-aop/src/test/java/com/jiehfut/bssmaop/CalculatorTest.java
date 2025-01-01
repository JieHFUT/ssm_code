package com.jiehfut.bssmaop;

import com.jiehfut.bssmaop.calculator.Calculator;
import com.jiehfut.bssmaop.calculator.impl.*;
import com.jiehfut.bssmaop.service.UserService;
import com.jiehfut.bssmaop.service.impl.UserServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Qualifier;

public class CalculatorTest {

    @Test
    public void testCalculator(){
        Calculator calculator1 = new CalculatorImpl();
        calculator1.add(2, 3);

        /**
         * 硬编码
         * 实现类在每一个接口上都进行日志的添加
         */
        Calculator calculator2 = new CalculatorImplHardCoding();
        calculator2.add(2, 3);

        /**
         * 静态代理
         * 在编码时期就确定了代理对象（关系）
         * 功能完善，但是范围太小了，只能负责部分接口代理功能
         */
        Calculator calculator3 = new CalculatorImplStaticProxy((CalculatorImpl) calculator1);
        calculator3.add(2, 3);

        /**
         * 动态代理
         * 在运行期间才确定代理对象（关系）
         * 拦截器思想，目标对象在执行期间会被动态拦截，进行动态代理
         * 强制要求目标对象必有接口，代理的也只是接口规定的方法
         */
        DynamicProxy dynamicProxy = new DynamicProxy(new CalculatorImpl());
        Calculator calculator4 = (Calculator) dynamicProxy.getProxy();
        calculator4.add(2, 3);


        CalculatorImpl calculator = (CalculatorImpl) DynamicProxyStatic.getProxyInstance(new CalculatorImpl());
        calculator.add(2, 3);
    }

    
    @Test
    public void testUserService(){
        DynamicProxy dynamicProxy = new DynamicProxy(new UserServiceImpl());
        UserService service = (UserService) dynamicProxy.getProxy();
        service.saveUser();
    }


}
