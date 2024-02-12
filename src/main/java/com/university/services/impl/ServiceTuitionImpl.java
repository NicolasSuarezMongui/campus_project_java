package com.university.services.impl;

import java.util.List;

import com.university.exceptions.fareexceptions.FareException;
import com.university.repository.RepositoryTuition;
import com.university.repository.models.Tuition;
import com.university.services.ServiceTuition;

public class ServiceTuitionImpl implements ServiceTuition{

    private final RepositoryTuition crudRepositoryTuition;

    public ServiceTuitionImpl(RepositoryTuition crudRepositoryTuition) {
        this.crudRepositoryTuition = crudRepositoryTuition;
    }
    
    public List<Tuition> toList() {
        return crudRepositoryTuition.toList();
    }

    public Tuition findById(int tuiton_id) throws FareException{
        Tuition tuiton = crudRepositoryTuition.findById(tuiton_id);
        if(tuiton == null){
            throw new FareException("Tuition not found");
        } else {
            return tuiton;
        }
    }

    public void create(Tuition tuiton){
        crudRepositoryTuition.create(tuiton);
    }

    public void delete(int tuiton_id){
        crudRepositoryTuition.delete(tuiton_id);
    }

    public void update(Tuition tuiton){
        crudRepositoryTuition.update(tuiton);
    }

}
