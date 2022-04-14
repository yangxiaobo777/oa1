package com.yang.oa.service;

import com.yang.oa.dao.SignInDao;
import com.yang.oa.entity.PageHelper;
import com.yang.oa.entity.SignIn;
import com.yang.oa.exceptions.OaException;
import com.yang.oa.handler.UserHandler;
import com.yang.oa.utils.ExcelUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletResponse;
import java.util.*;

/**
 * @author :[yang]
 * @version :1.0
 * @description : [签到，申诉接口]
 * @createTime :[2022/4/1 19:25]
 */
@Slf4j
@Service
public class SignInService {

    @Autowired
    private SignInDao dao;

    @Autowired
    private UserHandler handler;

    @Transactional(readOnly = true)
    public PageHelper<SignIn> querySignIn(SignIn signIn){
        try{
            PageHelper<SignIn> postPageHelper = new PageHelper<>();
            List<SignIn> signIns = dao.querySignIn(signIn);
            Integer total = dao.querySignInNum(signIn);
            postPageHelper.setRows(signIns);
            postPageHelper.setTotal(total);
            return postPageHelper;
        }catch (Exception e){
            throw new OaException(500,"查询签到信息报错");
        }

    }


    @Transactional(readOnly = true)
    public void querySignInToExcel(SignIn signIn, HttpServletResponse response){
        try{
            List<SignIn> signIns = dao.querySignInToExcel(signIn);
            ExcelUtil.downLoad("员工岗位",SignIn.class,response,signIns);
        }catch (Exception e){
            throw new OaException(500,"导出签到信息报错");
        }

    }

    @Transactional
    public void signIn(String userId,String datadt,String status){
        try{
            //条件判断(是否是本公司员工，是否在公司附件)
            HashMap<String, String> param = new HashMap<>();
            param.put("userId",userId);
            handler.checkSignIn(param);

            dao.addSignIn(status);

            if("4".equals(status)){
                Map<String, String>  map= dao.queryIsSuccess(userId, datadt);
                dao.updateSignInStatus(userId,datadt,getStatus(map));
            }
        }catch (Exception e){
            throw new OaException(500,"签到报错");
        }


    }

    public String getStatus(Map<String,String> map){
        String status = "0";
        if(map!=null){
            List<String> list = Arrays.asList("", "", "", "");
            for (String key:list) {
                if(map.get(key)==null){
                    status = "5";
                    break;
                }
            }
        }else {
            status = "9";
        }

        return status;
    }

    @Transactional
    public void updateSignIn(String reason,String signinTm, String userId, String dataDt){
        try {
            dao.updateSignIn(reason,signinTm,userId,dataDt);
        }catch (Exception e){
            throw new OaException(500,"修改签到信息报错");
        }

    }



}
