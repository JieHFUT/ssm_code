package com.jiehfut.bssmaop.calculator.impl;

import com.jiehfut.bssmaop.calculator.Calculator;

// 静态代理类
public class CalculatorImplStaticProxy implements Calculator {
    /**
     * 对需要被代理的类，将被代理目标的对象传递过来（即为目标）
     * 代理 CalculatorImpl 类
     */
    private CalculatorImpl calculator;

    public CalculatorImplStaticProxy(CalculatorImpl calculator) {
        this.calculator = calculator;
    }



    @Override
    public int add(int i, int j) {
        // 附加功能由代理类中的代理方法来实现
        System.out.println("[日志] add 方法开始了，参数是：" + i + "," + j);

        // 通过目标对象来实现核心业务逻辑
        int addResult = calculator.add(i, j);

        System.out.println("[日志] add 方法结束了，结果是：" + addResult);

        return addResult;
    }

    @Override
    public int sub(int i, int j) {
        return 0;
    }

    @Override
    public int mul(int i, int j) {
        return 0;
    }

    @Override
    public int div(int i, int j) {
        return 0;
    }
}
