package com.xin.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * Created by CHENXINXIN on 2016/8/6.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PhoneNumber implements Serializable {
    private static final long serialVersionUID = -7329045436515813391L;

    private String countryCode;
    private String stateCode;
    private String number;

    public PhoneNumber(String string){
        if (string!=null){
            String[] parts = string.split("-");
            if (parts.length>0){
                this.countryCode = parts[0];
            }
            if (parts.length>1){
                this.stateCode = parts[1];
            }
            if (parts.length>2){
                this.number = parts[2];
            }
        }
    }

    public String getAsString(){
        return countryCode+"-"+stateCode+"-"+number;
    }
}
