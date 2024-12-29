package com.jiehfut.bssmaop.log;

import java.lang.reflect.Method;
import java.util.Arrays;

public class LogUtils {


    public static void logStart(Method method, Object[] args) {
        System.out.println("[动态代理][日志] "+method.getName()+"，参数："+ Arrays.toString(args));
    }


}
