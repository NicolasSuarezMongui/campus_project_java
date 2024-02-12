package com.university.services;

import java.util.List;

import com.university.repository.models.Department;

public interface ServiceDepartment {
    
    List<Department> toList();

    Department findById(int department_id);

    Department findByName(String department_name);

    void create(Department department);

    void update(Department department);

    void delete(int id_department);

}
