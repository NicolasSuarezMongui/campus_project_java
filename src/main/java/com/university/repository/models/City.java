package com.university.repository.models;

import lombok.Data;
import lombok.AllArgsConstructor;

@Data
@AllArgsConstructor
public class City {
    
    private int id;
    private String name;

    public City(String name) {
        this.name = name;
    }

}
