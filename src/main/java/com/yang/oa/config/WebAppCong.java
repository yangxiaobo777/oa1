package com.yang.oa.config;

import com.yang.oa.interceptors.ResponseResultInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author :[yang]
 * @version :1.0
 * @description : [注册拦截器]
 * @createTime :[2022/4/5 23:05]
 */
@Configuration
public class WebAppCong implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new ResponseResultInterceptor()).addPathPatterns("/**");
    }
}
