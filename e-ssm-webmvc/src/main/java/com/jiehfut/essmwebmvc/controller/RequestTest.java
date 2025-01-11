package com.jiehfut.essmwebmvc.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RequestTest {


    /**
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







}
