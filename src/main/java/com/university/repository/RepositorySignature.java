package com.university.repository;

import java.util.List;

import com.university.repository.models.Signature;

public interface RepositorySignature {
    
    public List<Signature> toList();

    public Signature findById(int signature_id);

    public Signature findByName(String signature_name);

    public void create(Signature signature);

    public void delete(int signature_id);

    public void update(Signature signature);

}
