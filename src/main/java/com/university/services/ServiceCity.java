package com.university.services;

import java.util.List;

import com.university.repository.models.City;

public interface ServiceCity {
    
    List<City> toList();
    
    City findByName(String name);

    void create(City city);
    
    void update(City city);

}
