package com.university.services;

import java.util.List;

import com.university.exceptions.registerexceptions.RegisterException;
import com.university.repository.models.Register;

public interface ServiceRegister {

    List<Register> toList();

    Register findById(int register_id) throws RegisterException;

    Register findByStudentId(int student_id) throws RegisterException;

    void create(Register register);

    void update(Register register);

}