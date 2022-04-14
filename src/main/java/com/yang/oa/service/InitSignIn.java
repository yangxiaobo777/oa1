package com.yang.oa.service;

import com.yang.oa.dao.EmployeeDao;
import com.yang.oa.dao.SignInDao;
import com.yang.oa.exceptions.OaException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author :[yang]
 * @version :1.0
 * @description : [定时任务初始化签到数据]
 * @createTime :[2022/3/30 22:56]
 */
@Slf4j
@Service
public class InitSignIn {

    @Resource
    private EmployeeDao employeeDao;

    @Autowired
    private SignInDao signInDao;

    @Scheduled(cron = "0 0 0 * * ?")
    @Transactional
    public void initSign(){
        try{
            List<String> userIds = employeeDao.queryAllEmployee();
            signInDao.initSignIn(userIds);
        }catch (Exception e){
            throw new OaException(500,"初始化签到状态报错");
        }

    }
}
