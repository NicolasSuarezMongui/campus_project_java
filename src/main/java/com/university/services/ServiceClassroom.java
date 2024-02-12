package com.university.services;

import java.util.List;

import com.university.exceptions.classroomexceptions.ClassroomExceptionInsertDataBase;
import com.university.exceptions.classroomexceptions.ClassroomNullException;
import com.university.repository.models.Classroom;

public interface ServiceClassroom {
    
    List<Classroom> toList();

    Classroom findById(int classroom_id) throws ClassroomNullException;

    Classroom findByName(String classroom_name);

    void create(Classroom classroom) throws ClassroomExceptionInsertDataBase;

    void update(Classroom classroom);

    void delete(int id_classroom);

}
