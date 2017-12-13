package com.springboot.frame.exception;

import lombok.Data;

@Data
public class ArgumentInvalidResult {

    private String field;
    private Object rejectedValue;
    private String defaultMessage;

}
