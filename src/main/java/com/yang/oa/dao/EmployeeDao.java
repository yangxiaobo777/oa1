package com.yang.oa.dao;



import com.yang.oa.entity.Employee;

import java.util.List;


public interface EmployeeDao {

    List<Employee> queryEmployee(Employee employee);

    Integer queryEmployeeNum(Employee employee);

    List<Employee> queryEmployeeToExcel(Employee employee);

    int addEmployee(Employee employee);

    int branchAddEmployee(List<Employee> employees);

    int updateEmployee(String oldUserId,Employee employee);

    int deleteEmployee(String userId);

    int branchDeleteEmployee(List<String> userIds);

    int queryIsExistEmployee(String userId);

    List<String> queryAllEmployee();



}
