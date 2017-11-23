package com.springboot.frame.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by jack rose on 2017/11/21.
 */
@Entity
@Table(name = "t_user")
@Data
public class User implements Serializable {

    @Id
    @GeneratedValue
    @Column(name = "t_id")
    private Long id;

    @Column(name = "t_name")
    private String name;

    @Column(name = "t_age")
    private int age;

    @Column(name = "t_address")
    private String address;


}