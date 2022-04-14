package com.yang.oa.enums;

public enum ResultEnum {

    SUCCESS(200,"数据获取成功"),

    FAIL(500,"数据获取失败");

    ResultEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    };

    private Integer code;

    private String msg;

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
