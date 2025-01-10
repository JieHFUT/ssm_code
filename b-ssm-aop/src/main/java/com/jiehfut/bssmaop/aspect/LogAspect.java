package com.jiehfut.bssmaop.aspect;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Arrays;

    /**
     * AOP 简化代理
     *     切面类
     *     通知
     *     横切关注点 * 方法个数 = 连接点
     *     连接点：JoinPoint
     *     连接点真正去感兴趣的点叫做切入点：PointCut
     *     切入点表达式
     *
     *
     * 下面是四个通知方法
     * 通过写切入表达式来说明通知方法什么时候执行
     * 1.todo:在什么时候运行
     *     @Before          方法执行之前执行（前置通知）
     *     @AfterReturning  方法执行正常返回结果后执行（返回通知）
     *     @AfterThrowing   方法执行出现异常执行（异常通知）
     *     @After           方法执行之后执行（后置通知）
     *     @Around          环绕通知（环绕通知）
     * 2.在哪一个方法执行
     *  切入点表达式
     *  设置切入点和通知类型：value：切入点表达式配置切入点：即对哪个目标方法进行前置通知
     *     "execution(public int com.jiehfut.aop.annotationaop.CalculatorImpl.add(int, int))"
     *     "访问修饰符 增强方法返回类型 增强方法所在类全路径.方法名称（方法参数）是否抛异常"
     *     [public] int [com.jiehfut.aop.annotationaop.CalculatorImpl].add(int, int ) throws Exception
     *
     *     省略写法：int add(int i, int j)
     *             * com.jiehfut*.*(..)
     *
     *     通配符号
     *     *   ：表示任意字符
     *     ..  ：如果在参数位置，代表多个参数，任意类型
     *           如果在类型位置，代表多个层级
     *     最省略；* *(..)
     *
     *
     *
     * execution：执行什么方法的时候切
     *
     * within(type-pattern)：如果目标对象是什么类型的时候切
     *     within(全类名)
     * this(type-pattern)：代理对象是什么类型就切入
     *     切面类时，注入容器的组件是代理类 CGLIB
     * target(type-pattern)：目标对象是什么类型就切入
     *     切面类时，注入容器的组件是代理类 CGLIB，目标类型才是自己写的
     *
     * args(param-pattern)：参数是什么类型就切入
     *     args(int, int)
     *     只要参数是双 int 就切入
     * bean(bean-id-or-name-pattern)：只要是某个名称的组件就切
     *     bean(zhangsan)
     *     只要是 zhangsan这个组件就切
     * @target(annotation-type)：标注了什么注解的就切
     *     @target(注解全类名)
     * @args(annotation-type)：参数上有没有标注注解
     *     public void test(Myan myan)
     *     @args(注解全类名...)
     * @annotation(annotation-type)：方法上有没有标注注解
     *
     *
     *
     */

// 切面类
@Aspect // 表示是一个切面类
@Component // 表示在 ioc 容器中进行管理
public class LogAspect {
    // 1.设置切入点和通知类型：value：切入点表达式配置切入点：即对哪个目标方法进行前置通知
    // "execution(public int com.jiehfut.aop.annotationaop.CalculatorImpl.add(int, int ))"
    // "访问修饰符 增强方法返回类型 增强方法所在类全路径.方法名称（方法参数）"

    // 前置 @Before(value = "切入点表达式配置切入点")、
    // 返回 @AfterReturning、
    // 异常 @AfterThrowing、
    // 后置 @After()、
    // 环绕 @Around()、


    // 1.前置 @Before(value = "切入点表达式配置切入点")、
    @Before(value = "execution(public int com.jiehfut.bssmaop.calculator.impl.CalculatorImpl.add(int, int ))")
    public void beforeMethod(JoinPoint joinPoint) {
        // 使用 joinPoint 可以获得增强方法的相关信息
        String name = joinPoint.getSignature().getName();
        Object[] args = joinPoint.getArgs();
        System.out.println("Logger-->前置通知，方法名称是：" + name + "，参数是：" + Arrays.toString(args));
    }


    // 2.后置 @After()、
    // @After("args(int, int)")：只要参数是两个 int 就切
    // @After("args(org.springframework.beans.factory.annotation.Qualifier)") 有这个注解就切
    // @After("args(com.jiehfut.bssmaop.service.impl.UserServiceImpl)") 是这个类就切
    // @After(value = "pointCut()")
    // @After(value = "com.jiehfut.aop.annotationaop.LogAspect.pointCut()")
    // @After(value = "execution(* com.jiehfut.aop.annotationaop.CalculatorImpl.*(..))")
    //
    @After(value = "pointCut()")
    public void afterMethod(JoinPoint joinPoint) {
        // 使用 joinPoint 可以获得增强方法的相关信息
        String name = joinPoint.getSignature().getName();
        System.out.println("Logger-->后置通知，方法名称是：" + name);
    }


    // 3.返回 @AfterReturning、增强方法可以得到目标方法的返回值：returning = "result"
    @AfterReturning(value = "execution(* com.jiehfut.bssmaop.calculator.impl.CalculatorImpl.*(..))", returning = "result")
    public void afterReturning(JoinPoint joinPoint, Object result) {
        // 使用 joinPoint 可以获得增强方法的相关信息
        String name = joinPoint.getSignature().getName();
        System.out.println("Logger-->返回通知，方法名称是：" + name + "，目标方法的返回结果是：" + result);
    }


    // 4.异常 @AfterThrowing、如果你的目标方法执行过程中出现了异常就会执行，否则不会执行
    @AfterThrowing(value = "execution(* com.jiehfut.bssmaop.calculator.impl.CalculatorImpl.*(..))", throwing = "ex")
    public void afterThrowing(JoinPoint joinPoint, Exception ex) {
        // 使用 joinPoint 可以获得增强方法的相关信息
        String name = joinPoint.getSignature().getName();
        System.out.println("Logger-->异常通知，方法名称是：" + name + "，异常信息是：" + ex);
    }


    // 5.环绕 @Around()、针对 try-catch
    @Around(value = "execution(* com.jiehfut.bssmaop.calculator.impl.CalculatorImpl.*(..))")
    public Object afterAround(ProceedingJoinPoint joinPoint) {
        // 使用 joinPoint 可以获得增强方法的相关信息
        String name = joinPoint.getSignature().getName();
        Object[] args = joinPoint.getArgs();
        String argsStr = Arrays.toString(args);
        Object result = null;
        try{
            System.out.println("环绕通知 => 目标方法之前执行");
            // 通过 ProceedingJoinPoint 调用目标方法
            result = joinPoint.proceed();

            System.out.println("环绕通知 => 目标方法返回值之后执行");
        } catch (Throwable throwable) {
            System.out.println("环绕通知 => 目标方法出现异常执行");
        } finally {
            System.out.println("环绕通知 => 目标方法执行完毕后执行");
        }
        return result;
    }


    // 重用切入点表达式
    @Pointcut(value = "execution(* com.jiehfut.bssmaop.calculator.impl.CalculatorImpl.*(..))")
    public void pointCut() {}


}

// 切面的优先级 @Order() 来控制
