package com.university.repository.models;

import lombok.Data;
import lombok.AllArgsConstructor;

@Data
@AllArgsConstructor
public class Course {
    
    private int id;
    private String name;
    private String guide;

    public Course(String name, String guide) {
        this.name = name;
        this.guide = guide;
    }

}
