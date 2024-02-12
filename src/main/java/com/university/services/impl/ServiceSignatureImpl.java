package com.university.services.impl;

import java.util.List;

import com.university.exceptions.subjectexceptions.SubjectException;
import com.university.repository.RepositorySignature;
import com.university.repository.models.Signature;
import com.university.services.ServiceSignature;

public class ServiceSignatureImpl implements ServiceSignature{

    private final RepositorySignature crudRepositorySignature;

    public ServiceSignatureImpl(RepositorySignature crudRepositorySignature) {
        this.crudRepositorySignature = crudRepositorySignature;
    }

    public List<Signature> toList() {
        return crudRepositorySignature.toList();
    }

    public Signature findById(int signature_id) throws SubjectException{
        Signature signature = crudRepositorySignature.findById(signature_id);
        if(signature == null){
            throw new SubjectException("Signature not found");
        } else {
            return signature;
        }
    }

    public Signature findByName(String signature_name){
        return crudRepositorySignature.findByName(signature_name);
    }

    public void create(Signature signature) {
        crudRepositorySignature.create(signature);
    }

    public void delete(int signature_id) {
        crudRepositorySignature.delete(signature_id);
    }

    public void update(Signature signature){
        crudRepositorySignature.update(signature);
    }

}

