package com.university.services.impl;

import java.util.List;

import com.university.repository.RepositoryCity;
import com.university.repository.models.City;
import com.university.services.ServiceCity;

public class ServiceCityImpl implements ServiceCity{
    
    private final RepositoryCity crudRepositoryCity;

    public ServiceCityImpl(RepositoryCity crudRepositoryCity) {
        this.crudRepositoryCity = crudRepositoryCity;
    }

    public List<City> toList() {
        return crudRepositoryCity.toList();
    }
    
    public City findByName(String name) {
        return crudRepositoryCity.findByName(name);
    }

    public void create(City city) {
        crudRepositoryCity.create(city);
    }
    
    public void update(City city) {
        crudRepositoryCity.update(city);
    }

}
