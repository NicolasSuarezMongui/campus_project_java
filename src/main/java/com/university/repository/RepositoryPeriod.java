package com.university.repository;

import java.util.List;

import com.university.repository.models.Period;

public interface RepositoryPeriod {
    
    public List<Period> toList();
    
    public Period findById(int period_id);
    
    public Period findByCode(String period_code);
    
    public void create(Period period);
    
    public void delete(int period_id);
    
    public void update(Period period);

}
