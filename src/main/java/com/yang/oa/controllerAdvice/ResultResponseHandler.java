package com.yang.oa.controllerAdvice;

import com.yang.oa.annotations.ResultResponse;
import com.yang.oa.exceptions.OaException;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import javax.servlet.http.HttpServletRequest;

/**
 * @author :[yang]
 * @version :1.0
 * @description : [设置统一返回类]
 * @createTime :[2022/4/5 19:55]
 */
@ControllerAdvice
public class ResultResponseHandler implements ResponseBodyAdvice<Object> {

    private static final String RESPONSE_RESULT_ANN = "RESPONSE_RESULT_ANN";

    @Override
    public boolean supports(MethodParameter returnType, Class<? extends HttpMessageConverter<?>> converterType) {
        ServletRequestAttributes sra = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = sra.getRequest();
        ResultResponse resultResponseAnn = (ResultResponse)request.getAttribute(RESPONSE_RESULT_ANN);
        return resultResponseAnn != null;
    }

    @Override
    public Object beforeBodyWrite(Object body, MethodParameter returnType, MediaType selectedContentType, Class<? extends HttpMessageConverter<?>> selectedConverterType, ServerHttpRequest request, ServerHttpResponse response) {

        if(body instanceof ResultAdvice){
            return body;
        }else {
            return ResultAdvice.success(body);
        }


    }
}
