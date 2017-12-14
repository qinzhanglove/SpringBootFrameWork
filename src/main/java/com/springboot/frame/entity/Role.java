package com.springboot.frame.entity;

import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by jack rose on 2017/12/14.
 */
@Data
@Entity
@Table(name = "t_roles")
public class Role implements Serializable {

    @Id
    @GeneratedValue
    @Column(name = "role_id")
    private Long roleId;


    @NotBlank
    @Column(name = "t_name")
    private String name;
    @Column(name = "t_code")
    private String code;
    @Column(name = "create_time")
    private Date createTime;



}
