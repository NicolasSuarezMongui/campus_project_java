package com.university.repository.models;

import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Schedule {
    
    private int id;
    private String day;
    private String start;
    private String end;
    private int classroomId;
    private int signatureId;

    public Schedule(String day, String start, String end, int classroomId, int signatureId) {
        this.day = day;
        this.start = start;
        this.end = end;
        this.classroomId = classroomId;
        this.signatureId = signatureId;
    }

    public void print(){
        System.out.println("-".repeat(30));
        System.out.println("\t          Schedule's ID: " + id);
        System.out.println("\t         Schedule's Day: " + day);
        System.out.println("\t       Schedule's Start: " + start);
        System.out.println("\t         Schedule's End: " + end);
        System.out.println("\tSchedule's Classroom ID: " + classroomId);
        System.out.println("\tSchedule's Signature ID: " + signatureId);
        System.out.println("-".repeat(30));
    }

}
