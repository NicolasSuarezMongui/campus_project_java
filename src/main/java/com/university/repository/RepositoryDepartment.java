package com.university.repository;

import java.util.List;

import com.university.repository.models.Department;

public interface RepositoryDepartment {
    
    public List<Department> toList();
    
    public Department findById(int department_id);
    
    public Department findByName(String department_name);
    
    public void create(Department department);
    
    public void delete(int department_id);
    
    public void update(Department department);

}
