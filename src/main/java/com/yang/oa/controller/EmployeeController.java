package com.yang.oa.controller;

import com.yang.oa.annotations.ResultResponse;
import com.yang.oa.entity.Employee;
import com.yang.oa.entity.PageHelper;

import com.yang.oa.service.EmployeeService;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * @author :[yang]
 * @version :1.0
 * @description : [该类的功能]
 * @createTime :[2022/3/29 21:57]
 */
@Slf4j
@RestController
@ResultResponse
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService service;

    @PostMapping("/queryEmployee")
    public PageHelper<Employee> queryEmployee(@RequestBody Employee employee){
        return service.queryEmployee(employee);
    }

    @PostMapping("/queryEmployeeToExcel")
    public void queryEmployeeToExcel(@RequestBody Employee employee, HttpServletResponse response){
         service.queryEmployeeToExcel(employee,response);
    }

    @PostMapping("/addEmployee")
    public void addEmployee(@RequestBody Employee employee){
         service.addEmployee(employee);
    }

    @PostMapping("/branchAddEmployee")
    public void branchAddEmployee(MultipartFile file){
         service.branchAddEmployee(file);
    }

    @PostMapping("/updateEmployee")
    public void updateEmployee(@RequestBody Employee employee,String oldUserId){
         service.updateEmployee(oldUserId,employee);
    }

    @PostMapping("/deleteEmployee")
    public void deleteEmployee(String postId){
         service.deleteEmployee(postId);
    }

    @PostMapping("/branchDeleteEmployee")
    public void branchDeleteEmployee(List<String> postIds){
         service.branchDeleteEmployee(postIds);
    }

    @PostMapping("/queryIsExistEmployee")
    public boolean queryIsExistEmployee(String userId){
        return service.queryIsExistEmployee(userId);
    }


 }
