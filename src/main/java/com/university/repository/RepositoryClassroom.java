package com.university.repository;

import java.util.List;

import com.university.repository.models.Classroom;

public interface RepositoryClassroom {
        
        public List<Classroom> toList();
    
        public Classroom findById(int classroom_id);
    
        public Classroom findByName(String classroom_name);
    
        public void create(Classroom classroom);
    
        public void delete(int classroom_id);
    
        public void update(Classroom classroom);
        
}
