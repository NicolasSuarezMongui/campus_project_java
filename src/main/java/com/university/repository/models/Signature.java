package com.university.repository.models;

import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Signature {
    
    private int id;
    private int credits;
    private int capacity;
    private int duration;
    private String name;
    private int teacherId;
    private int courseId;
    private int periodId;

    public Signature(int credits, int capacity, int duration, String name, int teacherId, int courseId, int periodId) {
        this.credits = credits;
        this.capacity = capacity;
        this.duration = duration;
        this.name = name;
        this.teacherId = teacherId;
        this.courseId = courseId;
        this.periodId = periodId;
    }

    public void print(){
        System.out.println("-".repeat(30));
        System.out.println("\t       Signature's ID: " + id);
        System.out.println("\t    Signature's Name: " + name);
        System.out.println("\tSignature's Credits: " + credits);
        System.out.println("\tSignature's Capacity: " + capacity);
        System.out.println("\tSignature's Duration: " + duration);
        System.out.println("\tSignature's Teacher ID: " + teacherId);
        System.out.println("\t  Signature's Course ID: " + courseId);
        System.out.println("\t Signature's Period ID: " + periodId);
        System.out.println("-".repeat(30));
    }

}
