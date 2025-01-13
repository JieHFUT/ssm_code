package com.jiehfut.hssmwebmvcpractice.controller;


import com.jiehfut.hssmwebmvcpractice.bean.Employee;
import com.jiehfut.hssmwebmvcpractice.common.R;
import com.jiehfut.hssmwebmvcpractice.exception.BizExceptionEnume;
import com.jiehfut.hssmwebmvcpractice.service.EmployeeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * CORS policy：同源策略（限制ajax请求，图片，css，js）； 跨域问题
 * 跨源资源共享（CORS）（Cross-Origin Resource Sharing）
 *    浏览器为了安全，默认会遵循同源策略（请求要去的服务器和当前项目所在的服务器必须是同一个源[同一个服务器]），如果不是，请求就会被拦截
 *    复杂的跨域请求会发送2次：
 *    1、options 请求：预检请求。浏览器会先发送options请求，询问服务器是否允许当前域名进行跨域访问
 *    2、真正的请求：POST、DELETE、PUT等
 *
 *
 * 浏览器页面所在的：http://localhost   /employee/base
 * 页面上要发去的请求：http://localhost:8080   /api/v1/employees
 *  /以前的东西，必须完全一样，一个字母不一样都不行。浏览器才能把请求（ajax）发出去。
 *
 *  跨域问题：
 *    1、前端自己解决：
 *    2、后端解决：允许前端跨域即可（一个注解即可）
 *          原理：服务器给浏览器的响应头中添加字段：Access-Control-Allow-Origin = *
 *
 *
 */
@CrossOrigin  //允许跨域
@RestController
@RequestMapping("/api/v1")
public class EmployeeController {
    /**
     * "/employee/id" --- get ------ 查询某个员工信息 ------------ Employee-json
     * "/employee/id" --- delete --- 删除某个员工信息 ------------ boolean
     * "/employee" ------ get ------ 查询全部员工信息 ------------ List<Employee-json>
     * "/employee" ------ post ----- 新增某个员工信息 ------------ boolean
     * "/employee" ------ put ------ 修改某个员工信息 ------------ boolean
     * "employee/page" -- get ------ 查询所有员工信息（加分页） ---- pageList<Employee-json>
     *
     * GetMapping
     * PutMapping
     * DeleteMapping
     * PostMapping
     * PatchMapping
     *
     * 1.请求中有一个 id 属性
     * @RequestMapping(value = "/employee/{id}", method = RequestMethod.GET)
     * 2.加一个星号代表可以有多层路径，如 *id = /a/b/c/3/id  接收使用 String id
     * @RequestMapping(value = "/employee/{*id}", method = RequestMethod.GET)
     * 3.使用正则表达式，可以有多个表达式
     * @RequestMapping(value = "/employee/{id:\\d+}.test", method = RequestMethod.GET)
     */

    @Autowired
    private EmployeeService employeeService;


    /**
     * 新增员工信息
     * 前端发送请求，将员工信息以 json 字符串传递过来
     * 使用 @Valid 进行数据校验 - 校验失败业务就不会执行了 - 直接响应异常
     *
     * 要求：校验出错，在控制层方法体里响应错误信息（code，msg，data）
     *      使用 BindingResult 接收校验出错的信息（封装校验结果）- 进行判断
     *
     * 最终的处理方式是利用全局异常处理捕捉 MethodArgumentNotValidException（参数校验失败异常） 统一返回
     * @param employee
     * @return
     */
    @PostMapping("/employee")
    public R<Boolean> create(@RequestBody @Valid  Employee employee, BindingResult bindingResult) {
        if (!bindingResult.hasErrors()) {
            int i = employeeService.addEmployee(employee);
            R r = new R<>(200, "ok", true);
            return i == 1 ? r : new R<Boolean>(i, "error", false);
        }
        // 说明校验错误信息，拿到所有错误信息
        Map<String, String> errorMap = new HashMap<>();
        for (FieldError fieldError : bindingResult.getFieldErrors()) {
            // 1.拿到出错的属性名
            String fieldName = fieldError.getField();
            // 2.拿到默认出错消息
            String errorMessage = fieldError.getDefaultMessage();
            errorMap.put(fieldName, errorMessage);
        }
        return R.error(BizExceptionEnume.EMPLOYEE_DATA_VALID, errorMap);
    }

    /**
     * 查询某个员工信息
     * "/employee/id" get
     * @param id
     * @return
     */
    @RequestMapping(value = "/employee/{id}", method = RequestMethod.GET)
    public Employee get(@PathVariable("id") Long id) {
        return employeeService.getEmployeeById(id);
    }


    /**
     * 删除某个员工信息
     * @param id
     * @return
     */
    @DeleteMapping("/employee/{id}")
    public R<Boolean> delete(@PathVariable("id") Long id) {
        System.out.println("根据用户 ID 查询用户信息控制器已经执行...");
        int i = employeeService.deleteEmployee(id);
        R r = new R<>(200, "ok", true);
        return i == 1 ? r : new R<Boolean>(i, "error", false);
    }

    /**
     * 修改某个员工信息
     * @param employee
     * @return
     */
    @PutMapping("/employee")
    public R<Boolean> update(@RequestBody Employee employee) {
        int i = employeeService.updateEmployee(employee);
        R r = new R<>(200, "ok", true);
        return i == 1 ? r : new R<Boolean>(i, "error", false);
    }


    /**
     * 查询全部员工信息
     * @return
     */
    @GetMapping("/employees")
    public R<List<Employee>> getAll() {
        System.out.println("获取所有的用户信息...");
        List<Employee> employees = employeeService.getAllEmployee();
        return new R<>(200, "ok", employees);
    }


}
