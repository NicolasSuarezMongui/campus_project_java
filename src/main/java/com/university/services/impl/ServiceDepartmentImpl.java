package com.university.services.impl;

import java.util.List;

import com.university.repository.RepositoryDepartment;
import com.university.repository.models.Department;
import com.university.services.ServiceDepartment;

public class ServiceDepartmentImpl implements ServiceDepartment{

    private final RepositoryDepartment crudRepositoryDepartment;

    public ServiceDepartmentImpl(RepositoryDepartment crudRepositoryDepartment) {
        this.crudRepositoryDepartment = crudRepositoryDepartment;
    }
    
    public List<Department> toList(){
        return crudRepositoryDepartment.toList();
    }

    public Department findById(int department_id){
        return crudRepositoryDepartment.findById(department_id);
    }

    public Department findByName(String department_name){
        return crudRepositoryDepartment.findByName(department_name);
    }

    public void create(Department department){
        crudRepositoryDepartment.create(department);
    }

    public void update(Department department){
        crudRepositoryDepartment.update(department);
    }

    public void delete(int id_department){
        crudRepositoryDepartment.delete(id_department);
    }

}
