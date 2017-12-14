package com.springboot.frame.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by jack rose on 2017/12/14.
 */
@Data
@Entity
@Table(name = "t_UserRole")
public class UserRole implements Serializable {

    @Id
    @GeneratedValue
    @Column(name = "t_id")
    private Long id;
    @Column(name = "create_time")
    private Date createTime;
    @Column(name = "role_id")
    private Long roleId;
    @Column(name = "user_id")
    private Long userId;

}
