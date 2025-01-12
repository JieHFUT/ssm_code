package com.jiehfut.hssmwebmvcpractice.advice;


import com.jiehfut.hssmwebmvcpractice.common.R;
import com.jiehfut.hssmwebmvcpractice.exception.BizException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 对控制层利用切面机制进行增强 - 从而统一处理异常行为
 * @ResponseBody + @ControllerAdvice = @RestControllerAdvice
 *
 * 1.优先本类中异常处理
 * 2.再者优先全局异常处理
 * 3.如果本类中和全局异常处理类中都没有处理某异常的能力，springboot 提供了默认的兜底机制（自适应处理-浏览器响应白页）
 *
 * 前端关心异常状态，后端关心业务流程处理
 * 推荐：后端只要编写正确的业务逻辑，如果出现业务逻辑，后端通过抛出异常的方式提前中断业务逻辑，让前端感知异常
 */

// @ResponseBody
// @ControllerAdvice // 告诉 springmvc 这是全局处理异常的类
@RestControllerAdvice
public class GlobalExceptionHandler {


    @ExceptionHandler(value = Exception.class)
    public R exceptionHandler(Exception e) {
        return R.error("GlobalExceptionHandler：" + e.getMessage());
    }


    @ExceptionHandler(value = BizException.class)
    public R bizExceptionHandler(BizException e) {
        Integer code = e.getCode();
        String msg = e.getMsg();
        return R.error(code, msg);
    }


}
