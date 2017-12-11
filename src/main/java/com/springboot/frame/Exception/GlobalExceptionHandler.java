package com.springboot.frame.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;


/**
 * Created by jack rose on 2017/11/30.
 */

@ResponseBody
@ControllerAdvice
public class GlobalExceptionHandler {
    /**
     * 全局异常捕捉处理
     * @param e
     * @return
     */
    @ExceptionHandler(value=Exception.class)
    @ResponseStatus
    public ApiResult runtimeExceptionHandler(Exception e) {
        return ApiResultGenerator.errorResult(e.getMessage(),e);
    }

    /**
     * 自定义异常捕捉处理 JSON
     * @param e
     * @return
     */
    @ExceptionHandler(value = BusinessException.class)
    public ApiResult JsonErrorHandler(BusinessException e) {
        return ApiResultGenerator.errorResult(e.getMessage(),e);
    }


}
