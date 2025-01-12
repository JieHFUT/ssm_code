package com.jiehfut.gssmwebmvcrestful.controller;


import com.jiehfut.gssmwebmvcrestful.bean.Employee;
import com.jiehfut.gssmwebmvcrestful.common.R;
import com.jiehfut.gssmwebmvcrestful.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
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
     */

    @Autowired
    private EmployeeService employeeService;


    /**
     * 新增员工信息
     * 前端发送请求，将员工信息以 json 字符串传递过来
     * @param employee
     * @return
     */
    @PostMapping("/")
    public R<Boolean> create(@RequestBody Employee employee) {
        int i = employeeService.addEmployee(employee);
        R r = new R<>(200, "ok", true);
        return i == 1 ? r : new R<Boolean>(i, "error", false);
    }

    /**
     * 查询某个员工信息
     * "/employee/id" get
     * @param id
     * @return
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Employee get(@PathVariable("id") Long id) {
        return employeeService.getEmployeeById(id);
    }


    /**
     * 删除某个员工信息
     * @param id
     * @return
     */
    @DeleteMapping("/{id}")
    public R<Boolean> delete(@PathVariable("id") Long id) {
        int i = employeeService.deleteEmployee(id);
        R r = new R<>(200, "ok", true);
        return i == 1 ? r : new R<Boolean>(i, "error", false);
    }

    /**
     * 修改某个员工信息
     * @param employee
     * @return
     */
    @PutMapping("/")
    public R<Boolean> update(@RequestBody Employee employee) {
        int i = employeeService.updateEmployee(employee);
        R r = new R<>(200, "ok", true);
        return i == 1 ? r : new R<Boolean>(i, "error", false);
    }


    /**
     * 查询全部员工信息
     * @return
     */
    @GetMapping("/")
    public List<Employee> getAll() {
        return null;
    }






}
