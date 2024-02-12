package com.university.services.impl;

import java.util.List;

import com.university.repository.RepositoryBuilding;
import com.university.repository.models.Building;
import com.university.services.ServiceBuilding;

public class ServiceBuildingImpl implements ServiceBuilding {

    private final RepositoryBuilding crudRepositoryBuilding;
    
    public ServiceBuildingImpl(RepositoryBuilding crudRepositoryBuilding) {
        this.crudRepositoryBuilding = crudRepositoryBuilding;
    }

    public List<Building> toList() {
        return crudRepositoryBuilding.toList();
    }

    public Building findById(int building_id) {
        return crudRepositoryBuilding.findById(building_id);
    }

    public Building findByName(String building_name){
        return crudRepositoryBuilding.findByName(building_name);
    }

    public void create(Building building){
        crudRepositoryBuilding.create(building);
    }

    public void update(Building building){
        crudRepositoryBuilding.update(building);
    }

}
