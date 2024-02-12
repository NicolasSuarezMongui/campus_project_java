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

    public void print(){
        System.out.println("-".repeat(30));
        System.out.println("\t     Course's ID: " + id);
        System.out.println("\t   Course's Name: " + name);
        System.out.println("\t  Course's Guide: " + guide);
        System.out.println("-".repeat(30));
    }


}
