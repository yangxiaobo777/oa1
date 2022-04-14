package com.yang.oa.controller;

import com.yang.oa.annotations.ResultResponse;
import com.yang.oa.entity.PageHelper;

import com.yang.oa.entity.SignIn;

import com.yang.oa.service.SignInService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import javax.servlet.http.HttpServletResponse;


/**
 * @author :[yang]
 * @version :1.0
 * @description : [该类的功能]
 * @createTime :[2022/3/29 21:57]
 */
@Slf4j
@RestController
@ResultResponse
@RequestMapping("/signIn")
public class SignInController {

    @Autowired
    private SignInService service;

    @PostMapping("/querySignIn")
    public PageHelper<SignIn> querySignIn(@RequestBody SignIn signIn){
        return service.querySignIn(signIn);
    }

    @PostMapping("/querySignInToExcel")
    public void querySignInToExcel(@RequestBody SignIn signIn, HttpServletResponse response){
         service.querySignInToExcel(signIn,response);
    }



 }
