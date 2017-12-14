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
    @Column(name = "t_user_id")
    private Long userId;

    @NotBlank
    @Column(name = "t_address")
    private String address;

    @NotBlank
    @Column(name = "t_age")
    private Integer age;

    @NotBlank
    @Column(name = "t_name")
    private String name;

    @NotBlank
    @Column(name = "t_password")
    private String password;


    @NotBlank
    @Email
    @Column(name = "t_email")
    private String email;


}

