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
     *
     * 如果校验不通过，目标方法不执行
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
