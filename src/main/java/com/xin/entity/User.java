package com.xin.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * Created by CHENXINXIN on 2016/8/5.
 */
@Data
public class User implements Serializable {
    private static final long serialVersionUID = -1535567101025756310L;

    private int id;
    private String name;
    private int age;
}
