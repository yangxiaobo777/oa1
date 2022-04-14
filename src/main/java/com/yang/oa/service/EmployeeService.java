package com.yang.oa.service;


import com.yang.oa.analy.EmployeeAnalysisEvent;
import com.yang.oa.dao.EmployeeDao;

import com.yang.oa.entity.Employee;
import com.yang.oa.entity.PageHelper;

import com.yang.oa.exceptions.OaException;
import com.yang.oa.utils.ExcelUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;


import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * @author :[yang]
 * @version :1.0
 * @description : [员工维护]
 * @createTime :[2022/3/28 21:32]
 */
@Slf4j
@Service
public class EmployeeService {

    @Resource
    private EmployeeDao dao;



    /**@Title
    *@Description 员工信息查询
    *@Param [post]
    *@return com.yang.oa.entity.PageHelper<com.yang.oa.entity.Post>
    *@Author yang
    *@Date  2022/3/29
    */
    @Transactional(readOnly = true)
    public PageHelper<Employee> queryEmployee(Employee employee){
        try{
            PageHelper<Employee> postPageHelper = new PageHelper<>();
            List<Employee> posts = dao.queryEmployee(employee);
            Integer total = dao.queryEmployeeNum(employee);
            postPageHelper.setRows(posts);
            postPageHelper.setTotal(total);
            return postPageHelper;
        }catch (Exception e){
            throw new OaException(500,"查询员工信息报错!");
        }

    }


    @Transactional(readOnly = true)
    public void queryEmployeeToExcel(Employee employee, HttpServletResponse response){
        try{
            List<Employee> employees = dao.queryEmployeeToExcel(employee);
            ExcelUtil.downLoad("员工信息",Employee.class,response,employees);
        }catch (Exception e){
            throw new OaException(500,"导出员工信息报错!");
        }

    }

    @Transactional
    public void branchAddEmployee(MultipartFile file){
        try{
            List<Employee> employees = ExcelUtil.upLoad(file, Employee.class, new EmployeeAnalysisEvent());
            dao.branchAddEmployee(employees);
        }catch (Exception e){
            throw new OaException(500,"导入员工信息报错!");
        }

    }

    @Transactional
    public void addEmployee(Employee employee){
        try{
            dao.addEmployee(employee);
        }catch (Exception e){
            throw new OaException(500,"新增员工信息报错!");
        }

    }

    @Transactional
    public void updateEmployee(String oldUserId,Employee employee){
        try{
            dao.updateEmployee(oldUserId,employee);
        }catch (Exception e){
            throw new OaException(500,"修改员工信息报错!");
        }

    }

    @Transactional
    public void deleteEmployee(String userId){
        try{
            dao.deleteEmployee(userId);
        }catch (Exception e){
            throw new OaException(500,"删除员工信息报错!");
        }

    }

    @Transactional
    public void branchDeleteEmployee(List<String> userIds){
        try{
            dao.branchDeleteEmployee(userIds);
        }catch (Exception e){
            throw new OaException(500,"批量删除员工信息报错!");
        }

    }

    @Transactional(readOnly = true)
    public boolean queryIsExistEmployee(String userId){
        try{
            Integer flag = dao.queryIsExistEmployee(userId);
            return 0 < flag;
        }catch (Exception e){
            throw new OaException(500,"判断员工是否存在报错!");
        }

    }
}
