package com.university.services;

import java.util.List;

import com.university.repository.models.Building;

public interface ServiceBuilding {
    
    List<Building> toList();

    Building findById(int building_id);

    Building findByName(String building_name);

    void create(Building building);

    void update(Building building);

}
