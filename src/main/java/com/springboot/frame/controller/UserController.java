package com.springboot.frame.controller;

import com.springboot.frame.entity.User;
import com.springboot.frame.jpa.UserJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by jack rose on 2017/11/21.
 */
@RestController
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    private UserJPA userJPA;

        /**
         * 查询用户列表方法
         * @return
         */
        @RequestMapping(value ="/list" ,method = RequestMethod.GET)
        public List<User> list(){
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


}
