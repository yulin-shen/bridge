package com.example.springboot.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

@Data
public class Inspector {
    private Integer inspector_id;
    private String inspector_name;
    private String inspector_account;
    private String inspector_pd;
    private String inspector_sex;
    private String inspector_phone;
    private String inspector_email;
}
