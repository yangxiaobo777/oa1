package com.yang.oa.controller;

import com.yang.oa.annotations.ResultResponse;
import com.yang.oa.entity.Employee;
import com.yang.oa.entity.Examine;
import com.yang.oa.entity.PageHelper;
import com.yang.oa.service.EmployeeService;
import com.yang.oa.service.ExamineService;
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
@RequestMapping("/exmain")
public class ExamineController {

    @Autowired
    private ExamineService service;

    @PostMapping("/queryExamine")
    public PageHelper<Examine> queryExamine(@RequestBody Examine examine,String staDt,String endDt){
        return service.queryExamine(examine,staDt,endDt);
    }

    @PostMapping("/queryExamineToExcel")
    public void queryExamineToExcel(@RequestBody Examine examine,String staDt,String endDt, HttpServletResponse response){
         service.queryExamineToExcel(examine,staDt,endDt,response);
    }

    @PostMapping("/addExamine")
    public void addExamine(@RequestBody Examine examine){
         service.addExamine(examine);
    }



 }
