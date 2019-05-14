package com.learn.springboot.restfulcrud.controller;

import com.learn.springboot.restfulcrud.dao.DepartmentDao;
import com.learn.springboot.restfulcrud.dao.EmployeeDao;
import com.learn.springboot.restfulcrud.entities.Department;
import com.learn.springboot.restfulcrud.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Collection;

@Controller
public class EmployeeController {

    @Autowired
    private EmployeeDao employeeDao;

    @Autowired
    private DepartmentDao departmentDao;

    //查询所有员工返回列表页面
    @GetMapping("/emps")
    public String list(Model model){
        Collection<Employee> employees = employeeDao.getAll();
        model.addAttribute("emps",employees);
        //thymeleaf默认就会拼串
        return "emp/list";
    }

    //来到员工添加页面
    @GetMapping("/emp")
    public String toAddPage(Model model){
        //返回到添加页面，先查找出所有的部门，然后在页面显示
        Collection<Department> departments = departmentDao.getDepartments();
        model.addAttribute("depts",departments);
        return "emp/add";
    }

    //添加员工
    //SpringMVC自动将请求参数和入参对象的属性进行一一绑定
    //要求请求参数的名字和Javabean入参的对象里面的属性名是一样的
    @PostMapping("/emp")
    public String addEmp(Employee employee){
        System.out.println("添加的员工"+employee);
        //保存员工
        employeeDao.save(employee);
        //来到员工列表页面
        //redirect:表示重定向到一个地址
        //forward：表示转发到一个地址
        return "redirect:/emps";
    }

}
