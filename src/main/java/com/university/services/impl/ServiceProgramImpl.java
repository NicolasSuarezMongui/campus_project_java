package com.university.services.impl;

import java.util.List;

import com.university.exceptions.programexceptions.ProgramException;
import com.university.exceptions.programexceptions.ProgramNullException;
import com.university.repository.RepositoryProgram;
import com.university.repository.models.Program;
import com.university.services.ServiceProgram;

public class ServiceProgramImpl implements ServiceProgram{

    private final RepositoryProgram crudRepositoryProgram;

    public ServiceProgramImpl(RepositoryProgram crudRepositoryProgram) {
        this.crudRepositoryProgram = crudRepositoryProgram;
    }
        
    public List<Program> toList() {
        return this.crudRepositoryProgram.toList();
    
    }

    public Program findById(int program_id) throws ProgramNullException {
        Program program = this.crudRepositoryProgram.findById(program_id);
        if(program == null){
            throw new ProgramNullException("Program not found");
        } else {
            return program;
        }
    
    }

    public Program findByName(String program_name) throws ProgramException {
        return this.crudRepositoryProgram.findByName(program_name);
    }

    public void create(Program program) {
        this.crudRepositoryProgram.create(program);
    }

    public void update(Program program) {
        this.crudRepositoryProgram.update(program);
    }
        
}
