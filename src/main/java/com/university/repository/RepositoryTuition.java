package com.university.repository;

import java.util.List;

import com.university.repository.models.Tuition;

public interface RepositoryTuition {
    public List<Tuition> toList();

    public Tuition findByPeriodIdAndProgram(int period_id, int program_id);

    public Tuition findById(int tuiton_id);

    public void create(Tuition tuiton);

    public void delete(int tuiton_id);

    public void update(Tuition tuiton);
}
