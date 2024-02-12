package com.university.services.impl;

import java.util.List;

import com.university.exceptions.registerexceptions.RegisterException;
import com.university.repository.RepositoryRegister;
import com.university.repository.models.Register;
import com.university.services.ServiceRegister;

public class ServiceRegisterImpl implements ServiceRegister{

    private final RepositoryRegister crudRepositoryRegister;

    public ServiceRegisterImpl(RepositoryRegister crudRepositoryRegister) {
        this.crudRepositoryRegister = crudRepositoryRegister;
    }

    public List<Register> toList(){
        return crudRepositoryRegister.toList();
    }

    public Register findById(int register_id) throws RegisterException{
        Register register = crudRepositoryRegister.findById(register_id);
        if(register == null){
            throw new RegisterException("Register not found");
        } else {
            return register;
        }
    }

    public List<Register> listByStudentId(int student_id){
        return crudRepositoryRegister.listByStudentId(student_id);
    }

    public void create(Register register){
        crudRepositoryRegister.create(register);
    }

    public void update(Register register){
        crudRepositoryRegister.update(register);
    }

}