package com.university.services;

import java.util.List;

import com.university.exceptions.subjectexceptions.SubjectNullException;
import com.university.repository.models.Signature;

public interface ServiceSignature {

    List<Signature> toList();

    Signature findById(int signature_id) throws SubjectNullException;

    Signature findByName(String signature_name);

    void create(Signature signature);

    void delete(int signature_id);

    void update(Signature signature);

}

