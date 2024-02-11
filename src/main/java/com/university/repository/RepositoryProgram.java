package com.university.repository;

import java.util.List;

import com.university.repository.models.Program;

public interface RepositoryProgram {

    public List<Program> toList();

    public Program findById(int program_id);

    public Program findByName(String program_name);

    public void create(Program program);

    public void delete(int program_id);

    public void update(Program program);

}
