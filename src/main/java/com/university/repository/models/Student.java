package com.university.repository.models;

import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student{
    
    private int id;
    private int programId;
    private int personId;
    

    public Student(int programId, int personId) {
        this.programId = programId;
        this.personId = personId;
    }

}
