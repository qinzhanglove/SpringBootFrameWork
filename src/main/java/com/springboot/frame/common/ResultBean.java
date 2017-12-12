package com.springboot.frame.common;

import java.io.Serializable;

import lombok.Data;

@Data
public class ResultBean<T> implements Serializable {

	private static final long serialVersionUID = 1L;

	public static final int FAIL = -1;

	public static final int SUCCESS = 0;

	public static final int NO_LOGIN = 1;

	public static final int NO_PERMISSION = 2;


	private String msg = "success";

	private int status;

	private int code = SUCCESS;

	private T data;
	//接口相应时间毫秒单位
	private long time;

	private String url;

	public ResultBean() {
		super();
	}

	public ResultBean(T data) {
		super();
		this.data = data;
		this.time = System.currentTimeMillis();
	}

	public ResultBean(int status,int code,String msg) {
		this.status = status;
		this.code = code;
		this.msg = msg;
	}

	public ResultBean(Throwable e) {
		super();
		this.msg = e.toString();
		this.code = FAIL;
	}
}
