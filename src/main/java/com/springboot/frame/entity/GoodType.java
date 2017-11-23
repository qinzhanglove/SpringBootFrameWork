package com.springboot.frame.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by jack rose on 2017/11/23.
 */
@Entity
@Table(name = "t_good_type")
@Data
public class GoodType implements Serializable {

    @Id
    @GeneratedValue
    @Column(name = "t_id")
    private Long id;

    //类型名称
    @Column(name = "tgt_name")
    private String name;
    //是否显示
    @Column(name = "tgt_is_show")
    private int isShow;
    //排序
    @Column(name = "tgt_order")
    private int order;


}
