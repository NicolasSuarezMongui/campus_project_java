package com.university.services;

import java.util.List;

import com.university.exceptions.fareexceptions.FareException;
import com.university.repository.models.Tuition;

public interface ServiceTuition {
    
    List<Tuition> toList();

    Tuition findById(int tuiton_id) throws FareException;

    void create(Tuition tuiton);

    void delete(int tuiton_id);

    void update(Tuition tuiton);

}
