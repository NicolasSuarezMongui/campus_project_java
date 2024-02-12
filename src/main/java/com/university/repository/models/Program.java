package com.university.repository.models;

import lombok.Data;
import lombok.AllArgsConstructor;

@Data
@AllArgsConstructor
public class Program {
    
    private int id;
    private String name;
    private String level;

    public Program(String name) {
        this.name = name;
    }

    public Program(String name, String level) {
        this.name = name;
        this.level = level;
    }

    public void print() {
        System.out.println("-".repeat(30));
        System.out.println("\t    ID: " + getId());
        System.out.println("\t  Name: " + getName());
        System.out.println("\t Level: " + getLevel());
        System.out.println("-".repeat(30));
    }

}
