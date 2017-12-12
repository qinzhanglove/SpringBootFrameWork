package com.springboot.frame.common;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class PageResultBean<T> implements Serializable{

    private static final long serialVersionUID = 1L;

    public static final int FAIL = -1;

    public static final int SUCCESS = 0;

    public static final int NO_LOGIN = 1;

    public static final int NO_PERMISSION = 2;

    private String msg = "success";

    private int code = SUCCESS;

    private List<T> data;

    private Long total;

    private int pages;

    //接口相应时间毫秒单位
    private long time;

    public PageResultBean(){
        super();
    }
    public PageResultBean(List<T> data,Long total,int pages){
        super();
        this.data = data;
        this.total = total;
        this.pages = pages;
        this.time = System.currentTimeMillis();
    }

    public PageResultBean(Throwable e) {
        super();
        this.msg = e.toString();
        this.code = FAIL;
    }

}
