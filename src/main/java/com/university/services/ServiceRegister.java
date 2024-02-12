package com.university.services;

import java.util.List;

import com.university.exceptions.registerexceptions.RegisterException;
import com.university.repository.models.Register;

public interface ServiceRegister {

    List<Register> toList();

    Register findById(int register_id) throws RegisterException;

    List<Register> listByStudentId(int student_id);

    void create(Register register);

    void update(Register register);

}