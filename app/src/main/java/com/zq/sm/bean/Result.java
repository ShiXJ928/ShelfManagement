package com.zq.sm.bean;

/**
 * Created by sxj on 2016/9/29.
 */
public class Result {
    private int Code;
    private Object Value;
    private String msg;

    public int getCode() {
        return Code;
    }

    public void setCode(int code) {
        Code = code;
    }

    public Object getValue() {
        return Value;
    }

    public void setValue(Object value) {
        Value = value;
    }

    public String getMsg() {
        if (msg == null) {
            return "暂无数据";
        }
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
