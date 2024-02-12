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

    public void print() {
        System.out.println("-".repeat(30));
        System.out.println("\t    ID: " + getId());
        System.out.println("\t  Name: " + getName());
        System.out.println("\tLevel: " + getLevel());
        System.out.println("\t  Cap: " + getCapacity());
        System.out.println("\t  BID: " + getBuildingId());
        System.out.println("-".repeat(30));
    }

}
