package com.yang.oa.controllerAdvice;

import com.yang.oa.enums.ResultEnum;
import org.springframework.stereotype.Component;

import java.io.Serializable;

/**
 * @author :[yang]
 * @version :1.0
 * @description : [包装为统一的返回类来返回]
 * @createTime :[2022/4/5 19:38]
 */
@Component
public class ResultAdvice implements Serializable {

    private Integer code;

    private String msg;

    private Object data;

    public ResultAdvice(){}

    public ResultAdvice(ResultEnum resultEnum,Object data) {
        this.code = resultEnum.getCode();
        this.msg = resultEnum.getMsg();
        this.data = data;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public static ResultAdvice success(Object data){
        ResultAdvice resultAdvice = new ResultAdvice();
        resultAdvice.setCode(ResultEnum.SUCCESS.getCode());
        resultAdvice.setMsg(ResultEnum.SUCCESS.getMsg());
        resultAdvice.setData(data);
        return resultAdvice;
    }

    public static ResultAdvice fail(){
        ResultAdvice resultAdvice = new ResultAdvice();
        resultAdvice.setCode(ResultEnum.FAIL.getCode());
        resultAdvice.setMsg(ResultEnum.FAIL.getMsg());
        return resultAdvice;
    }

}
