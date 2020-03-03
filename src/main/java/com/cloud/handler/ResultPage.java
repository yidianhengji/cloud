package com.cloud.handler;

import com.github.pagehelper.PageInfo;

public class ResultPage<T> {
    private Integer code;
    private String msg;
    private com.github.pagehelper.PageInfo<T> data;

    public ResultPage(BusinessStatus businessStatus, com.github.pagehelper.PageInfo<T> pageInfo) {
        this.code = businessStatus.getCode();
        this.msg = businessStatus.getMsg();
        this.data = pageInfo;
    }

    public ResultPage(BusinessStatus businessStatus) {
        this.code = businessStatus.getCode();
        this.msg = businessStatus.getMsg();
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

    public PageInfo<T> getData() {
        return data;
    }

    public void setData(PageInfo<T> data) {
        this.data = data;
    }
}
