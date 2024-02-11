package com.university.repository.models;

import lombok.Data;
import lombok.AllArgsConstructor;

@Data
@AllArgsConstructor
public class Department {
    
    private int id;
    private String name;

    public Department(String name) {
        this.name = name;
    }

}
