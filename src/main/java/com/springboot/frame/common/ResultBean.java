package com.springboot.frame.common;

import java.io.Serializable;

import com.springboot.frame.utils.ErrorMessagePropertiesUtil;
import lombok.Data;

@Data
public class ResultBean<T> implements Serializable {

	private static final long serialVersionUID = 1L;

	public static final int FAIL = -1;

	public static final int SUCCESS = 0;

	public static final int NO_LOGIN = 1;

	public static final int NO_PERMISSION = 2;

	private int code = SUCCESS;

	private String msg = "success";

	private T data;


	public ResultBean() {
		super();
	}

	public ResultBean(T data) {
		super();
		this.data = data;
	}

	public ResultBean(int code,String msg,T data) {
		this.code = code;
		this.msg = msg;
		this.data = data;
	}

}
