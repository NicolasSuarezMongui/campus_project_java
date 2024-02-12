package com.university.services;

import java.util.List;

import com.university.exceptions.programexceptions.ProgramException;
import com.university.exceptions.programexceptions.ProgramNullException;
import com.university.repository.models.Program;

public interface ServiceProgram {
        
    List<Program> toList();

    Program findById(int program_id) throws ProgramNullException;

    Program findByName(String program_name) throws ProgramException;

    void create(Program program);

    void update(Program program);
        
}
