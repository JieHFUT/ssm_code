package com.jiehfut.essmwebmvc.controller;


import com.jiehfut.essmwebmvc.pojo.Person;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RequestTest {


    /**
     * 要求变量名和参数名称保持一致
     * 包装类型不携带的封装为 null，基本类型不携带数据的为默认值
     * @param username
     * @param password
     * @param cellphone
     * @param agreement
     * @return
     */
    @RequestMapping("/handle01")
    public String handle01(String username,
                           String password,
                           String cellphone,
                           boolean agreement) {
        return "ok";
    }

    /**
     * 如果后端接收参数名称和前端传递参数不一致，可以使用注解声明
     * 但是一但某个参数使用注解，请求中这个参数就必需要携带
     * @RequestParam 可以获取请求体中和 url 后面所有的请求参数
     * @param name
     * @param pwd
     * @param phone
     * @param isAgree
     * @return
     */
    @RequestMapping("/handle02")
    public String handle02(@RequestParam("username") String name,
                           @RequestParam("password")String pwd,
                           @RequestParam("cellphone")String phone,
                           @RequestParam("agreement")boolean isAgree) {
        return "ok";
    }


    /**
     * 如果后端接收参数名称和前端传递参数不一致，可以使用注解声明
     * 但是一但某个参数使用注解，请求中这个参数就必需要携带
     * 如果想让这个参数在请求中可以不携带，可以使用属性进行声明（required = false 声明其为非必需携带）
     * @param name
     * @param pwd
     * @param phone
     * @param isAgree
     * @return
     */
    @RequestMapping("/nucessery")
    public String nucessery(@RequestParam(value = "username", required = false) String name,
                           @RequestParam(value = "password", required = false)String pwd,
                           @RequestParam("cellphone")String phone,
                           @RequestParam("agreement")boolean isAgree) {
        return "ok";
    }

    /**
     * 如果后端接收参数名称和前端传递参数不一致，可以使用注解声明
     * 但是一但某个参数使用注解，请求中这个参数就必需要携带
     * 如果想让这个参数在请求中可以不携带，可以使用属性进行声明（required = false 声明其为非必需携带）
     *
     * 如果声明了默认值 defaultValue，就不用写 required 属性，声明默认值，请求中可带可不带该参数
     * @param name
     * @param pwd
     * @param phone
     * @param isAgree
     * @return
     */
    @RequestMapping("/default")
    public String defaultValue(@RequestParam(value = "username", required = false) String name,
                               @RequestParam(value = "password", required = false)String pwd,
                               @RequestParam(value = "cellphone", defaultValue = "18888888888")String phone,
                               @RequestParam("agreement")boolean isAgree) {
        return "ok";
    }


    /**
     * 1.请求中的参数就会自动注入该对象的属性中，名称不匹配的属性为 null
     * 2.如果请求中没有携带某个属性，该对象中的该属性也为 null
     * 3.如果想让这个对象拥有默认值，可以直接在创建类的时候赋值
     * 原理是利用反射给对象赋值：request.getParameter("username")...
     * @param person
     * @return
     */
    @RequestMapping(value = "/handle03")
    public String handle03(Person person) {
        return "ok";
    }


    /**
     * 获取请求头，不区分大小写
     * @param person
     * @param host
     * @return
     */
    @RequestMapping("/handle04")
    public String handle04(Person person,
                           @RequestHeader(value = "host", required = false) String host,
                           @RequestHeader(value = "user-agent", defaultValue = "") String userAgent) {
        return "ok";
    }




















}
