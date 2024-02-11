package com.university.repository.models;

import lombok.Data;
import lombok.AllArgsConstructor;

@Data
@AllArgsConstructor
public class Building {
    
    private int id;
    private String name;
    private int levels;

    public Building(String name, int levels) {
        this.name = name;
        this.levels = levels;
    }

}
