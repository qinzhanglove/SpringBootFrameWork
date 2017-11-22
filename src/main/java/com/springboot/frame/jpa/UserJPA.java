package com.springboot.frame.jpa;

import com.springboot.frame.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.io.Serializable;

/**
 * Created by jack rose on 2017/11/21.
 */
public interface UserJPA extends
        JpaRepository<User, Long>,
        JpaSpecificationExecutor<User>,
        Serializable{
}
