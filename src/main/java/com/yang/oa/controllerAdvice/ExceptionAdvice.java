package com.yang.oa.controllerAdvice;

import com.yang.oa.exceptions.OaException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author :[yang]
 * @version :1.0
 * @description : [异常处理类]
 * @createTime :[2022/4/5 22:04]
 */
@ControllerAdvice
public class ExceptionAdvice {

    @ExceptionHandler({OaException.class})
    @ResponseBody
    public ResultAdvice fail(OaException e){
        ResultAdvice resultAdvice = new ResultAdvice();
        resultAdvice.setCode(e.getCode());
        resultAdvice.setMsg(e.getMsg());
        return resultAdvice;
    }

}
