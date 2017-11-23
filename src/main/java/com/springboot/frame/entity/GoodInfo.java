package com.springboot.frame.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by jack rose on 2017/11/23.
 */
@Entity
@Table(name = "t_good_info")
@Data
public class GoodInfo implements Serializable {

    @Id
    @GeneratedValue
    @Column(name = "t_id")
    private Long id;

    //商品标题
    @Column(name = "tg_title")
    private String title;
    //商品价格
    @Column(name = "tg_price")
    private double price;
    //商品单位
    @Column(name = "tg_unit")
    private String unit;
    //商品排序
    @Column(name = "tg_order")
    private int order;
    //类型外键
    @Column(name = "tg_type_id")
    private Long typeId;



}
