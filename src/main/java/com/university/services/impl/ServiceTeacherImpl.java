package com.university.services.impl;

import java.util.List;

import com.university.exceptions.personexceptions.PersonExceptionInsertDataBase;
import com.university.exceptions.personexceptions.PersonNullException;
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

    public Person findByDocument(String document) throws PersonNullException {
        Person person = crudRepositoryTeacher.findByDocument(document);
        if(person == null){
            throw new PersonNullException("Person not found");
        } else {
            return person;
        }
    }

    public void create(Teacher teacher){
        crudRepositoryTeacher.create(teacher);
    }

    public void create(Person person, int id_department) throws PersonExceptionInsertDataBase {
        crudRepositoryTeacher.create(person, id_department);
    }

    public void update(Teacher teacher){
        crudRepositoryTeacher.update(teacher);
    }

    public void delete(Teacher teacher){
        crudRepositoryTeacher.delete(teacher);
    }

    public void delete(String document) throws PersonNullException {
        crudRepositoryTeacher.delete(document);
    }

}
