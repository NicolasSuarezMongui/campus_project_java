package com.university.services.impl;

import java.util.List;

import com.university.exceptions.periodexceptions.PeriodExceptionInsertDataBase;
import com.university.exceptions.periodexceptions.PeriodNullException;
import com.university.repository.RepositoryPeriod;
import com.university.repository.models.Period;
import com.university.services.ServicePeriod;

public class ServicePeriodImpl implements ServicePeriod {
    
    private final RepositoryPeriod crudRepositoryPeriod;

    public ServicePeriodImpl(RepositoryPeriod crudRepositoryPeriod) {
        this.crudRepositoryPeriod = crudRepositoryPeriod;
    }

    public List<Period> toList(){
        return crudRepositoryPeriod.toList();
    }

    public Period findById(int period_id) throws PeriodNullException{
        Period period = crudRepositoryPeriod.findById(period_id);
        if (period == null) {
            throw new PeriodNullException("Period not found");
        }
        return period;
    }

    public Period findByCode(String period_code) {
        return crudRepositoryPeriod.findByCode(period_code);
    }

    public void create(Period period) throws PeriodExceptionInsertDataBase{
        crudRepositoryPeriod.create(period);
    }

    public void saveOnMysql(Period period) throws PeriodExceptionInsertDataBase{
        crudRepositoryPeriod.create(period);
    }

    public void update(Period period){
        crudRepositoryPeriod.update(period);
    }

    public void delete(int id_period){
        crudRepositoryPeriod.delete(id_period);
    }

}
