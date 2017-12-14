package com.springboot.frame.controller;

import com.springboot.frame.common.ResultBean;
import com.springboot.frame.common.aop.ControllerAOP;
import com.springboot.frame.config.QueryFactory;
import com.springboot.frame.entity.User;
import com.springboot.frame.exception.BusinessException;
import com.springboot.frame.exception.ErrorCode;
import com.springboot.frame.jpa.UserJPA;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * Created by jack rose on 2017/11/21.
 */
@Controller
@RequestMapping(value = "/user")
public class UserController {

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserJPA userJPA;
    @Autowired
    private QueryFactory queryFactory;
    @ResponseBody
    @GetMapping(value = "/find")
    public ResultBean<List<User>> find(){
        logger.info("获取数据");
        return new ResultBean(userJPA.findAll());
    }

    @ResponseBody
    @RequestMapping("/hello1")
    public String hello1() {
        logger.info("获取数据");
        int i = 1 / 0;
        return "hello";
    }
    @RequestMapping("/hello2")
    public String hello2() {
        logger.info("获取数据");
        String string = null;
        string.length();
        return "hello";
    }
    @ResponseBody
    @RequestMapping("/hello3")
    public List<String> hello3() {
        throw new BusinessException(ErrorCode.PARAMETER_ERROR);
    }

}
