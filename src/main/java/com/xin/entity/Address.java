package com.xin.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * Created by CHENXINXIN on 2016/8/7.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Address implements Serializable {
    private static final long serialVersionUID = 9200446032617378689L;

    private Integer addrId;
    private String street;
    private String city;
    private String state;
    private String zip;
    private String country;

    public Address(Integer addrId){
        this.addrId = addrId;
    }
}
