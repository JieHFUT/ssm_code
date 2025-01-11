package com.jiehfut.essmwebmvc.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RequestMappingLimitController {


    /**
      @Target({ElementType.TYPE, ElementType.METHOD})
      @Retention(RetentionPolicy.RUNTIME)
      @Documented
      @Mapping
      @Reflective(ControllerMappingReflectiveProcessor.class)
      public @interface RequestMapping {
      String name() default "";
      @AliasFor("path")
      String[] value() default {};
      @AliasFor("value")
      String[] path() default {};
      RequestMethod[] method() default {};
      String[] params() default {};
      String[] headers() default {};
      String[] consumes() default {};
      String[] produces() default {};
      }

      路径变量：@PathVariable
      请求限定:
      请求方式：method => GET, HEAD, POST, PUT, PATCH, DELETE, OPTIONS, TRACE;
      请求参数：params
      请求头：headers
      请求内容类型：consumes
      响应内容类型：produces
     */

    @RequestMapping(value = "/limit-method", method = RequestMethod.GET)
    public String limitMethod() {
        return "limit-method";
    }




}
