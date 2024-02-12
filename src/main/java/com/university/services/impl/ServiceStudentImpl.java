package com.university.services.impl;

import java.util.List;

import com.university.exceptions.personexceptions.PersonException;
import com.university.repository.RepositoryStudent;
import com.university.repository.models.Person;
import com.university.repository.models.Student;
import com.university.services.ServiceStudent;

public class ServiceStudentImpl implements ServiceStudent{

    private final RepositoryStudent crudRepositoryStudent;

    public ServiceStudentImpl(RepositoryStudent crudRepositoryStudent) {
        this.crudRepositoryStudent = crudRepositoryStudent;
    }
    
    public List<Person> toList(){
        return crudRepositoryStudent.toList();
    }
    
    public Person findByDocument(String document) throws PersonException {
        Person person = crudRepositoryStudent.findByDocument(document);
        if(person == null){
            throw new PersonException("Person not found");
        } else {
            return person;
        }
    }

    public void create(Student student) {
        crudRepositoryStudent.create(student);
    }

    public void update(Student student) {
        crudRepositoryStudent.update(student);
    }

    public void delete(Student student) {
        crudRepositoryStudent.delete(student);
    }

}
