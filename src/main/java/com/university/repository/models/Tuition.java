package com.university.repository.models;

import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Tuition {
    
    private int id;
    private double creditValue;
    private int programId;
    private int periodId;

    public Tuition(double creditValue, int programId, int periodId) {
        this.creditValue = creditValue;
        this.programId = programId;
        this.periodId = periodId;
    }

    public void print(){
        System.out.println("-".repeat(30));
        System.out.println("\t          Tuition's ID: " + id);
        System.out.println("\tTuition's Credit Value: " + creditValue);
        System.out.println("\t  Tuition's Program ID: " + programId);
        System.out.println("\t   Tuition's Period ID: " + periodId);
        System.out.println("-".repeat(30));
    }

}
