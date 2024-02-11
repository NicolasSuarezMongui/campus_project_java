package com.university.repository.models;

import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Teacher {
    
    private int id;
    private int personId;
    private int departmentId;

    public Teacher(int personId, int departmentId) {
        this.personId = personId;
        this.departmentId = departmentId;
    }

}
