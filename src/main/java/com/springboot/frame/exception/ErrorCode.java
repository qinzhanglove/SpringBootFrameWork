package com.springboot.frame.exception;


import com.springboot.frame.utils.ErrorMessagePropertiesUtil;

/**
 * Created by jack rose on 2017/11/30.
 */
public enum ErrorCode {

    INTERNAL_ERROR(500, 1000, "Internal Server Error."),
    AUTHTOKEN_ERROR(401, 2000, "AuthToken Error or Expired."),
    CAPTCHA_ERROR(400, 2010, "CAPTCHA ERROR."),
    UNKNOW_ERROR(-1,"未知错误"),
    USER_NOT_FIND(-101,"user not exist"),
    NO_LOGIN(102,"user don't login"),
    PARAMETER_ERROR(3008,"parameter is error");

    private int httpStatusCode;
    private int errorCode;
    private String message;

    private static final int DEFAULT_STATUS_CODE = 400;

    private ErrorCode(int httpStatusCode, int errorCode, String message) {
        this.httpStatusCode = httpStatusCode;
        this.errorCode = errorCode;
        this.message = message;
    }

    private ErrorCode(int errorCode, String message) {
        this.httpStatusCode = DEFAULT_STATUS_CODE;
        this.errorCode = errorCode;
        this.message = message;
    }

    private ErrorCode(int errorCode) {
        this.httpStatusCode = DEFAULT_STATUS_CODE;
        this.errorCode = errorCode;
        this.message = "";
    }

    public int getHttpStatusCode() {
        return httpStatusCode;
    }

    public void setHttpStatusCode(int httpStatusCode) {
        this.httpStatusCode = httpStatusCode;
    }

    public int getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String toJson() {
        String msg = ErrorMessagePropertiesUtil.getInstance().getString(
                String.valueOf(errorCode), message);
        return new StringBuilder("{\"errorCode\":")//
                .append(errorCode)//
                .append(",\"message\":\"")//
                .append(msg)//
                .append("\" }")//
                .toString();
    }

    public String getCnMessage() {
        String msg = ErrorMessagePropertiesUtil.getInstance().getString(
                String.valueOf(errorCode));
        return msg;
    }

}
