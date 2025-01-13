package com.jiehfut.issmmybatisexample.mapper;

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

    /**
     * 添加一条员工记录
     * @param emp
     */
    void insertEmp(Emp emp);

    /**
     * 修改一条员工信息
     * @param emp
     */
    void updateEmp(Emp emp);


    /**
     * 根据员工 ID 来删除一条员工记录
     * @param id
     */
    void deleteEmp(Integer id);
}
