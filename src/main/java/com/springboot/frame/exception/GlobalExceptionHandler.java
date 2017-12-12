package com.springboot.frame.exception;

import com.springboot.frame.common.ResultBean;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.NoHandlerFoundException;

import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintViolationException;


/**
 * Created by jack rose on 2017/11/30.
 */


@ControllerAdvice
public class GlobalExceptionHandler {

    public static final String DEFAULT_ERROR_VIEW = "error";

    /**
     * 自定义异常捕捉处理 JSON
     * @param req
     * @param e
     * @return
     * @throws Exception
     */
    @ResponseBody
    @ExceptionHandler(value = BusinessException.class)
    public ResultBean<String> jsonErrorHandler(HttpServletRequest req, BusinessException e) throws Exception {
        ResultBean<String> resultBean = new ResultBean<>();
        resultBean.setMsg(e.getMessage());
        resultBean.setUrl(req.getRequestURL().toString());
        return resultBean;
    }


    /**
     * 自定义异常捕捉处理 page
     * @param req
     * @param e
     * @return
     * @throws Exception
     */
    @ExceptionHandler(value = Exception.class)
    public ModelAndView defaultErrorHandler(HttpServletRequest req, Exception e) throws Exception {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("message", e.getMessage());
        modelAndView.addObject("url", req.getRequestURL());
        modelAndView.setViewName(DEFAULT_ERROR_VIEW);
        return modelAndView;
    }

    @ExceptionHandler(value = { ConstraintViolationException.class })
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResultBean constraintViolationException(ConstraintViolationException ex) {
        return new ResultBean(500, 5001, ex.getMessage());
    }

    @ExceptionHandler(value = { IllegalArgumentException.class })
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResultBean IllegalArgumentException(IllegalArgumentException ex) {
        return new ResultBean(501, 5002, ex.getMessage());
    }

    @ExceptionHandler(value = { NoHandlerFoundException.class })
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResultBean noHandlerFoundException(Exception ex) {
        return new ResultBean(404, 4041, ex.getMessage());
    }


    @ExceptionHandler(value = { Exception.class })
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResultBean unknownException(Exception ex) {
        return new ResultBean(500, 5002, ex.getMessage());
    }

}
