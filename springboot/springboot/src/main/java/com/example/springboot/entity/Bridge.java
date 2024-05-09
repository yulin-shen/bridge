package com.example.springboot.entity;

import lombok.Data;

import java.sql.Date;

@Data
public class Bridge {
    private Integer bridge_id;
    private String bridge_name;
    private String bridge_address;
    private Date create_date;
    private Integer bridge_type;
    private Double bridge_length;
    private Double bridge_width;
    private String design_life;
    private String design_load;
    private Integer direct_inspector;

}
