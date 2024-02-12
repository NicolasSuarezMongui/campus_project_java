package com.university.services.impl;

import java.util.List;

import com.university.exceptions.personexceptions.PersonException;
import com.university.repository.RepositoryTeacher;
import com.university.repository.models.Person;
import com.university.repository.models.Teacher;
import com.university.services.ServiceTeacher;

public class ServiceTeacherImpl implements ServiceTeacher{

    private final RepositoryTeacher crudRepositoryTeacher;

    public ServiceTeacherImpl(RepositoryTeacher crudRepositoryTeacher) {
        this.crudRepositoryTeacher = crudRepositoryTeacher;
    }
    
    public List<Person> toList(){
        return crudRepositoryTeacher.toList();
    }

    public Person findByDocument(String document) throws PersonException {
        Person person = crudRepositoryTeacher.findByDocument(document);
        if(person == null){
            throw new PersonException("Person not found");
        } else {
            return person;
        }
    }

    public void create(Teacher teacher){
        crudRepositoryTeacher.create(teacher);
    }

    public void update(Teacher teacher){
        crudRepositoryTeacher.update(teacher);
    }

    public void delete(Teacher teacher){
        crudRepositoryTeacher.delete(teacher);
    }

}
