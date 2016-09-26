package com.xin.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Data
public class Course implements Serializable {
    private static final long serialVersionUID = -5150587416160285197L;

    private Integer courseId;
    private String name;
    private String description;
    private Date startDate;
    private Date endDate;
    private Tutor tutor;
    private List<Student> students;

}
