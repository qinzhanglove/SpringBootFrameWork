package com.springboot.frame.exception;

import com.springboot.frame.common.ResultBean;
import org.hibernate.service.spi.ServiceException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.NoHandlerFoundException;

import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.ValidationException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;


/**
 * Created by jack rose on 2017/11/30.
 */


@ControllerAdvice(annotations = Controller.class)
public class GlobalExceptionHandler {

    private static Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);


    /**
     * 自定义异常捕捉处理 JSON
     * @param request
     * @param e
     * @return
     * @throws Exception
     */
    @ResponseBody
    @ExceptionHandler(value = Exception.class)
    public ResultBean defaultExceptionHandler(HttpServletRequest request, Exception e){
        if(e instanceof BusinessException){
            BusinessException businessException = (BusinessException)e;
            ErrorCode errorCode = businessException.getErrorCode();
            String message = businessException.getMessage();
            return new ResultBean(errorCode.getErrorCode(),message,"");
        }
        return new ResultBean(ResultBean.FAIL,"Internal Server Error.","");
    }


}
