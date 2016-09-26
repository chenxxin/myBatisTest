package com.xin.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
@NoArgsConstructor
public class Tutor implements Serializable {

    private static final long serialVersionUID = -3303441700132327161L;
    private Integer tutorId;
    private String name;
    private String email;
    private Address address;
    private List<Course> courses;

    public Tutor(Integer id) {
        this.tutorId = id;
    }

}
