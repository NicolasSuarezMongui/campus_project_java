package com.university.repository.models;

import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Classroom {
    
    private int id;
    private int capacity;
    private int level;
    private String name;
    private int buildingId;

    public Classroom(int capacity, int level, String name, int buildingId) {
        this.capacity = capacity;
        this.level = level;
        this.name = name;
        this.buildingId = buildingId;
    }

}
