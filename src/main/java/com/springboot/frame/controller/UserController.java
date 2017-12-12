package com.springboot.frame.controller;

import com.springboot.frame.common.ResultBean;
import com.springboot.frame.config.QueryFactory;
import com.springboot.frame.entity.User;
import com.springboot.frame.exception.BusinessException;
import com.springboot.frame.jpa.UserJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

/**
 * Created by jack rose on 2017/11/21.
 */
@Controller
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    private UserJPA userJPA;
    @Autowired
    private QueryFactory queryFactory;

    /**
     * 查询用户列表方法
     * @return
     */
    @RequestMapping(value ="/list" ,method = RequestMethod.GET)
    public ResultBean<List<User>> list(){
        List<User> userList = userJPA.findAll();
        ResultBean resultBean = new ResultBean();
        resultBean.setData(userList);
        return resultBean;
    }

    @RequestMapping(value ="/find" ,method = RequestMethod.GET)
    public List<User> find(@Valid User user){


        return userJPA.findAll();
    }

    /**
     * 添加、更新用户方法
     * @param entity
     * @return
     */
    @RequestMapping(value = "/save",method = RequestMethod.GET)
    public User save(User entity)
    {
        return userJPA.save(entity);
    }

    /**
     * 删除用户方法
     * @param id 用户编号
     * @return
     */
    @RequestMapping(value = "/delete",method = RequestMethod.GET)
    public List<User> delete(Long id)
    {
        userJPA.delete(id);
        return userJPA.findAll();
    }

    @RequestMapping("/hello")
    public String hello() throws Exception {
        throw new Exception("发生错误");
    }

    @RequestMapping("/json")
    public String json() throws BusinessException {
        throw new BusinessException("发生错误2");
    }

}
