package com.university.repository.models;

import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Period {
    
    private int id;
    private int year;
    private String semester;
    private String code;

    public Period(int year, String semester, String code) {
        this.year = year;
        this.semester = semester;
        this.code = code;
    }

}
