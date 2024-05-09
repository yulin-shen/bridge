package com.example.springboot.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class User {
    private Integer admin_id;
    private String admin_name;
    private String admin_account;
    private String admin_pd;
    private String admin_sex;
    private String admin_phone;
    private String admin_email;


}
