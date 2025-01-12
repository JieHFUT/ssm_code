package com.jiehfut.hssmwebmvcpractice.dao;



import com.jiehfut.hssmwebmvcpractice.bean.Employee;

import java.util.List;

public interface EmployeeDao {

    /**
     * 根据员工的 ID 来查询员工信息
     * @param id
     * @return
     */
    Employee getEmployeeById(Long id);

    /**
     * 新增员工
     * @param employee
     */
    int addEmployee(Employee employee);

    /**
     * 修改员工信息
     * @param employee
     */
    int updateEmployee(Employee employee);

    /**
     * 删除员工信息
     * @param id
     */
    int deleteEmployee(Long id);


    /**
     * 查询所有员工信息
     * @return
     */
    List<Employee> getAllEmployee();
}
