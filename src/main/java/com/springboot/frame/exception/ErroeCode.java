package com.springboot.frame.exception;


/**
 * Created by jack rose on 2017/11/30.
 */
public enum  ErroeCode {

    FAILE("-1","FAILE"),
    SUCCESS("0","SUCCESS");

    private String code;
    private String message;

    ErroeCode(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "[" + this.code + "]" + this.message;
    }

}
