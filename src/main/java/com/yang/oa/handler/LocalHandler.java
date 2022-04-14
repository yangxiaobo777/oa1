package com.yang.oa.handler;

import com.yang.oa.dao.SignInDao;
import com.yang.oa.exceptions.OaException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @author :[yang]
 * @version :1.0
 * @description : [判断员工是否在公司特定区域]
 * @createTime :[2022/4/1 20:52]
 */
@Component
public class LocalHandler extends SignInHandler{
    @Autowired
    private RedisTemplate redisTemplate;

    @Override
    public void checkSignIn(Map<String, String> map){


    }
}
