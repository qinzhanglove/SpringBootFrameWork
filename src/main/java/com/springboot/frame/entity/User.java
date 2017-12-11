package com.springboot.frame.entity;

import lombok.Data;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "t_user")
public class User implements Serializable {
    @Id
    @GeneratedValue
    @Column(name = "t_id")
    private Long id;
    @Column(name = "t_address")
    private String address;
    @Column(name = "t_age")
    private Integer age;
    @Column(name = "t_name")
    private String name;
    @NotBlank(message = "邮箱地址不能为空")
    @Email
    @Column(name = "t_email")
    private String email;


}

