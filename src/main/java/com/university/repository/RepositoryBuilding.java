package com.university.repository;

import java.util.List;

import com.university.repository.models.Building;

public interface RepositoryBuilding {
    
    public List<Building> toList();

    public Building findById(int building_id);

    public Building findByName(String building_name);

    public void create(Building building);

    public void delete(int building_id);

    public void update(Building building);

}
