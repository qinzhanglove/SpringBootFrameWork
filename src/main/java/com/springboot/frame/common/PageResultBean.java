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

    private Long total;

    private List<T> data;

    private int pages;

    public PageResultBean(){
        super();
    }

    public PageResultBean(Long total, List<T> data, int pages) {
        this.total = total;
        this.data = data;
        this.pages = pages;
    }
}
