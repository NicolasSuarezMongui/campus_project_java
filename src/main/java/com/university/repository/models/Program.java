package com.university.repository.models;

import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Program {
    
    private int id;
    private String name;
    private String level;

    public Program(String name, String level) {
        this.name = name;
        this.level = level;
    }

}
