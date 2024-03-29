package com.university.repository;

import java.util.List;

import com.university.repository.models.Register;

public interface RepositoryRegister {
    
    List<Register> toList();

    Register findById(int register_id);

    List<Register> listByStudentId(int student_id);

    void create(Register register);

    void update(Register register);

}
