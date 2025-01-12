package com.jiehfut.hssmwebmvcpractice.bean;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employee {

    /**
     * 数据校验
     * 1.导入校验包：spring-boot-starter-validation
     * 2.编写校验注解
     * 3.需要校验的地方需要对 springmvc 声明 @Valid
     *   如果校验不通过，目标方法不执行，直接响应异常
     * 4.使用在目标属性后面跟着注解：使用 BindingResult 接收校验出错的信息（封装校验结果）
     *   使用该注解，校验不通过也会继续执行控制器方法
     * 5.可以不写 BindingResult 接收出错信息，让其校验错误通过全局处理器捕获异常
     *
     *
     *
     */

    private Long id;

    @NotEmpty(message = "姓名不能为空") // 不能是空串，否则给前端提示信息：姓名不能为空
    private String name;

    @NotNull(message = "年龄不能为空")
    @Max(value = 0, message = "年龄最小是0岁")
    @Max(value = 120, message = "年龄最大是120岁")
    private Integer age;

    @Email(message = "邮箱格式不正确")
    private String email;
    private String gender;
    private String address;
    private BigDecimal salary;

}
