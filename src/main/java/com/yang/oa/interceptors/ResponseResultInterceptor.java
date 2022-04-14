package com.yang.oa.interceptors;

import com.yang.oa.annotations.ResultResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;

/**
 * @author :[yang]
 * @version :1.0
 * @description : [拦截请求，设置标志]
 * @createTime :[2022/4/5 19:42]
 */
@Component
public class ResponseResultInterceptor implements HandlerInterceptor {

    private static final String RESPONSE_RESULT_ANN = "RESPONSE_RESULT_ANN";
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if(handler instanceof HandlerMethod){
            final HandlerMethod handlerMethod = (HandlerMethod) handler;
            final Class<?> clazz = handlerMethod.getBeanType();
            final Method method = handlerMethod.getMethod();

            if(clazz.isAnnotationPresent(ResultResponse.class)){
                request.setAttribute(RESPONSE_RESULT_ANN,clazz.getAnnotation(ResultResponse.class));
            }else if(method.isAnnotationPresent(ResultResponse.class)){
                request.setAttribute(RESPONSE_RESULT_ANN,method.getAnnotation(ResultResponse.class));
            }
        }

        return true;
    }
}
