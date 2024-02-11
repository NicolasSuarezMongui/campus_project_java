package com.university.repository.models;

import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Tuition {
    
    private int id;
    private int creditValue;
    private int programId;
    private int periodId;

    public Tuition(int creditValue, int programId, int periodId) {
        this.creditValue = creditValue;
        this.programId = programId;
        this.periodId = periodId;
    }

}
