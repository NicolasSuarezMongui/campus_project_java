package com.university.repository.models;

import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Register {
    
    private int id;
    private int studentId;
    private int periodId;
    private int signatureId;

    public Register(int studentId, int periodId, int signatureId) {
        this.studentId = studentId;
        this.periodId = periodId;
        this.signatureId = signatureId;
    }

    public void print() {
        System.out.println("-".repeat(30));
        System.out.println("\t    ID: " + getId());
        System.out.println("\t  Name: " + getStudentId());
        System.out.println("\t Level: " + getPeriodId());
        System.out.println("\t Level: " + getSignatureId());
        System.out.println("-".repeat(30));
    }

}
