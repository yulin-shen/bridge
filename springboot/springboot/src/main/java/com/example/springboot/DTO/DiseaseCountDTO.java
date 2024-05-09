package com.example.springboot.DTO;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author 23092
 */
@Data
public class DiseaseCountDTO {
    private Integer count;
    private LocalDateTime date;

    public void setCount(Integer i) {
        this.count = i;
    }

}
