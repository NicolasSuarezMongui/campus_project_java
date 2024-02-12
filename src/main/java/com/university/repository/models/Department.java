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

    public void print() {
        System.out.println("-".repeat(30));
        System.out.println("\t    Department ID: " + id);
        System.out.println("\t  Department Name: " + name);
        System.out.println("-".repeat(30));
    }

}
