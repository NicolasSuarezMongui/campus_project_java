package com.university.services.impl;

import java.util.List;

import com.university.exceptions.classroomexceptions.ClassroomExceptionInsertDataBase;
import com.university.exceptions.classroomexceptions.ClassroomNullException;
import com.university.repository.RepositoryClassroom;
import com.university.repository.models.Classroom;
import com.university.services.ServiceClassroom;

public class ServiceClassroomImpl implements ServiceClassroom{

    private final RepositoryClassroom crudRepositoryClassroom;

    public ServiceClassroomImpl(RepositoryClassroom crudRepositoryClassroom) {
        this.crudRepositoryClassroom = crudRepositoryClassroom;
    }
    
    public List<Classroom> toList() {
        return crudRepositoryClassroom.toList();
    
    }

    public Classroom findById(int classroom_id) throws ClassroomNullException{
        return crudRepositoryClassroom.findById(classroom_id);
    }

    public Classroom findByName(String classroom_name){
        return crudRepositoryClassroom.findByName(classroom_name);
    }

    public void create(Classroom classroom) throws ClassroomExceptionInsertDataBase{
        crudRepositoryClassroom.create(classroom);
    }

    public void update(Classroom classroom){
        crudRepositoryClassroom.update(classroom);
    }

    public void delete(int id_classroom){
        crudRepositoryClassroom.delete(id_classroom);
    }

}
