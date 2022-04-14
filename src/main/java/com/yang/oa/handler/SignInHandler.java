package com.yang.oa.handler;

import com.yang.oa.exceptions.OaException;

import java.util.Map;

/**
 * @author :[yang]
 * @version :1.0
 * @description : [签到拦截类]
 * @createTime :[2022/4/1 20:48]
 */
public abstract class SignInHandler {

    public SignInHandler handler;

    public void setHandler(SignInHandler handler){
        this.handler = handler;
    }

    public abstract void checkSignIn(Map<String,String> map);
}
