package com.yang.oa.handler;

import com.yang.oa.dao.SignInDao;
import com.yang.oa.exceptions.OaException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @author :[yang]
 * @version :1.0
 * @description : [判断员工是否是本公司员工]
 * @createTime :[2022/4/1 20:52]
 */
@Component
public class UserHandler extends SignInHandler{
    @Autowired
    private SignInDao dao;

    @Override
    public void checkSignIn(Map<String, String> map){
        int userNum = dao.queryIsExist(map.get("userId"));
        if(userNum<0){
            throw new OaException(500,"抱歉，你不是本公司员工");
        }

    }
}
