package com.university.services;

import java.util.List;

import com.university.exceptions.registerexceptions.RegisterNullException;
import com.university.repository.models.Register;

public interface ServiceRegister {

    List<Register> toList();

    Register findById(int register_id) throws RegisterNullException;

    List<Register> listByStudentId(int student_id);

    void create(Register register);

    void update(Register register);

}