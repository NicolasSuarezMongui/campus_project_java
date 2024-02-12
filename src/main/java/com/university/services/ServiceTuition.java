package com.university.services;

import java.util.List;

import com.university.exceptions.fareexceptions.FareNullException;
import com.university.repository.models.Tuition;

public interface ServiceTuition {
    
    List<Tuition> toList();

    Tuition findByPeriodIdAndProgram(int period_id, int program_id);

    Tuition findById(int tuiton_id) throws FareNullException;

    void create(Tuition tuiton);

    void delete(int tuiton_id);

    void update(Tuition tuiton);

}
