package com.springboot.frame.exception;

import com.springboot.frame.common.ResultBean;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;


/**
 * Created by jack rose on 2017/11/30.
 */

@ResponseBody
@ControllerAdvice
public class GlobalExceptionHandler {
    public static final String DEFAULT_ERROR_VIEW = "error";
    /**
     * 全局异常捕捉处理
     * @param e
     * @return
     */
    /*@ExceptionHandler(value=Exception.class)
    @ResponseStatus
    public ResultBean runtimeExceptionHandler(Exception e) {
        return ResultBean(e);
    }*/

    /**
     * 自定义异常捕捉处理 JSON
     * @param e
     * @return
     */
    /*@ExceptionHandler(value = BusinessException.class)
    public ApiResult JsonErrorHandler(BusinessException e) {
        return ApiResultGenerator.errorResult(e.getMessage(),e);
    }*/

    /**
     * 自定义异常捕捉处理 page
     * @param req
     * @param e
     * @return
     * @throws Exception
     */
    @ExceptionHandler(value = BusinessException.class)
    public ModelAndView pageExceptionHandler(HttpServletRequest req, Exception e) throws Exception {
        ModelAndView mav = new ModelAndView();
        mav.addObject("message", e.getMessage());
        mav.setViewName(DEFAULT_ERROR_VIEW);
        return mav;
    }

}
