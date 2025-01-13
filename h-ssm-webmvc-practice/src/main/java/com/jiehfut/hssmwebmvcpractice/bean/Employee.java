package com.jiehfut.hssmwebmvcpractice.bean;


import com.jiehfut.hssmwebmvcpractice.annotation.Address;
import jakarta.validation.constraints.*;
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
     *   使用该注解，校验不通过也会继续执行控制器方法（不过后期这种方法不推荐使用，推荐使用第五步）
     * 5.可以不写 BindingResult 接收出错信息，让其校验错误通过全局处理器捕获异常（MethodArgumentNotValidException）
     *  （这样的话在控制层就只需要开启数据校验即可，校验失败全局异常处理会把所有的校验错误细节交给前端 code,msg,data）
     *
     */

    private Long id;

    @NotEmpty(message = "姓名不能为空") // 不能是 null，空串，否则给前端提示信息：姓名不能为空
    private String name;

    @NotNull(message = "年龄不能为空")
    @Min(value = 0, message = "年龄最小是0岁")
    @Max(value = 120, message = "年龄最大是120岁")
    private Integer age;

    @Email(message = "邮箱格式不正确")
    private String email;

    // 想设置一个校验规则：gender 的值只能是"男" || "女" => 使用正则表达式
    @Pattern(regexp = "^男|女$", message = "性别属性只能是男或者女")
    private String gender;

    /**
     * 如果想要开启一个自定义的校验注解
     * 1.创建一个注解类
     * 2.实现校验器（implements ConstraintValidator）
     * 3.将校验器类.Class写入注解类中
     * 4.使用注解
     *
     * 如果想让中文环境下响应 => message = "此地址信息只能是... 这三种的其中一个
     *       英文环境下响应 => message = "allows the three in (anhui-wuhu，shanghai，anhui-hefei)"
     *       俄语环境下响应 => message = "Информация об этом адресе может быть только... Один из трех."
     *       =============> 国际化（ internationalization - i18n）
     *       这个时候就不用把 message 信息写死，只需要写一个占位符即可 message = "{address.message}"，然后在 messages.properties 中进行配置
     */
    // @Address(message = "此地址信息只能是... 这三种的其中一个")
    @Address(message = "{address.message}")
    private String address;

    private BigDecimal salary;


}
