package com.springboot.frame.exception;


/**
 * Created by jack rose on 2017/11/30.
 */
public class BusinessException extends RuntimeException {

    public BusinessException(Object Obj) {
        super(Obj.toString());
    }

}
