package com.university.services;

import java.util.List;

import com.university.exceptions.periodexceptions.PeriodExceptionInsertDataBase;
import com.university.exceptions.periodexceptions.PeriodNullException;
import com.university.repository.models.Period;

public interface ServicePeriod {
    
    List<Period> toList();

    Period findById(int period_id) throws PeriodNullException;

    Period findByCode(String period_code);

    void create(Period period) throws PeriodExceptionInsertDataBase;

    void update(Period period);

    void delete(int id_period);

}
