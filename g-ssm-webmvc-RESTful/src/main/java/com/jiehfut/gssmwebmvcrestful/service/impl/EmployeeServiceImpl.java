package com.jiehfut.gssmwebmvcrestful.service.impl;

import com.jiehfut.gssmwebmvcrestful.bean.Employee;
import com.jiehfut.gssmwebmvcrestful.dao.EmployeeDao;
import com.jiehfut.gssmwebmvcrestful.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeDao employeeDao;

    @Override
    public Employee getEmployeeById(Long id) {
        return employeeDao.getEmployeeById(id);
    }

    @Override
    public int addEmployee(Employee employee) {
        return employeeDao.addEmployee(employee);
    }

    @Override
    public int updateEmployee(Employee employee) {
        return employeeDao.updateEmployee(employee);
    }

    @Override
    public int deleteEmployee(Long id) {
        return employeeDao.deleteEmployee(id);
    }

}
