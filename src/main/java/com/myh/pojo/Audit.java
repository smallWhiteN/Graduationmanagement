package com.myh.pojo;

import java.util.Date;

public class Audit extends Graduate{

    private String msg;

    private Integer state;


    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg == null ? null : msg.trim();
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }
}