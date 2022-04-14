package com.yang.oa.exceptions;

/**
 * @author :[yang]
 * @version :1.0
 * @description : [异常类]
 * @createTime :[2022/4/4 15:51]
 */
public class OaException extends RuntimeException{

    private Integer code;

    private String msg;

    public OaException(Integer code,String msg){
        this.code = code;
        this.msg = msg;
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
}
