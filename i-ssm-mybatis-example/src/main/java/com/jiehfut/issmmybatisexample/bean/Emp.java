package com.jiehfut.issmmybatisexample.bean;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Emp {

    private Integer id;
    private String empName;
    private Integer age;
    private Double empSalary;

}
