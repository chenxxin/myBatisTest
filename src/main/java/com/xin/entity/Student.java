package com.xin.entity;

import com.xin.domain.PhoneNumber;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by CHENXINXIN on 2016/8/5.
 */

//@Alias("student")  // 使用注解的方式创建别名，将覆盖mybatis-config.xml 中的定义
@Data
public class Student implements Serializable {
    private static final long serialVersionUID = -529115609486550314L;

    private Integer studId;
    private String name;
    private String email;
    private Date dob;
    private PhoneNumber phone;
    private Address address;
}
