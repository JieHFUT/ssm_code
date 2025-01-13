package com.jiehfut.issmmybatisexample;

import com.jiehfut.issmmybatisexample.bean.Emp;
import com.jiehfut.issmmybatisexample.mapper.EmpMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ISsmMybatisExampleApplicationTests {

    @Autowired
    EmpMapper empMapper;

    @Test
    void contextLoads() {
        System.out.println("empMapper = " + empMapper); // empMapper = org.apache.ibatis.binding.MapperProxy@7d64a960
        /**
         * 很明显，容器中为每一个 mapper 接口创建了一个代理对象：MapperProxy
         *
         */
        Emp emp = empMapper.getEmpById(1);
        System.out.println(emp);

        empMapper.insertEmp(new Emp(null, "zhansgan", 19, 23.34));

        empMapper.updateEmp(new Emp(5, "lisi", 19, 23.34));

        empMapper.deleteEmp(5);
    }


    /**
     * 设置主键回显
     * .xml 文件设置
     */
    @Test
    public void testPrimaryIdFeedback(){
        Emp zhangsan = new Emp(null, "zhansgan", 19, 23.34);
        empMapper.insertEmp(zhangsan);
        System.out.println("id = " + zhangsan.getId()); // id = 5
    }




}
