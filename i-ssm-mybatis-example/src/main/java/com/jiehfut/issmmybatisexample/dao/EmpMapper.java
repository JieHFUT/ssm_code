package com.jiehfut.issmmybatisexample.dao;

import com.jiehfut.issmmybatisexample.bean.Emp;
import org.apache.ibatis.annotations.Mapper;


@Mapper // 告诉 spring 这是 mybatis 操作数据库的接口 - 映射器
public interface EmpMapper {

    /**
     * 根据员工 ID获取员工信息
     * @param id
     * @return
     */
    Emp getEmpById(Integer id);
}
