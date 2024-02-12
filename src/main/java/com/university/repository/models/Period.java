package com.university.repository.models;

import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Period {
    
    private int id;
    private String year;
    private String semester;
    private String code;

    public Period(String year, String semester, String code) {
        this.year = year;
        this.semester = semester;
        this.code = code;
    }

    public void print(){
        System.out.println("-".repeat(30));
        System.out.println("\t       ID: " + getId());
        System.out.println("\t     Year: " + getYear());
        System.out.println("\t Semester: " + getSemester());
        System.out.println("\t     Code: " + getCode());
        System.out.println("-".repeat(30));
    }

}
