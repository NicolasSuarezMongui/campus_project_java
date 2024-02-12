package com.university.services.impl;

import java.util.List;

import com.university.exceptions.personexceptions.PersonExceptionInsertDataBase;
import com.university.exceptions.personexceptions.PersonNullException;
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
    
    public Person findByDocument(String document) throws PersonNullException {
        Person person = crudRepositoryStudent.findByDocument(document);
        if(person == null){
            throw new PersonNullException("Person not found");
        } else {
            return person;
        }
    }

    public Student findById(int student) {
        return crudRepositoryStudent.findById(student);
    }

    public int getId(String document) throws PersonNullException {
        Person person = crudRepositoryStudent.findByDocument(document);
        if(person == null){
            throw new PersonNullException("Person not found");
        } else {
            return person.getId();
        }

    }

    public void create(Student student) {
        crudRepositoryStudent.create(student);
    }

    public void create(Person person, int id_program) throws PersonExceptionInsertDataBase{
        crudRepositoryStudent.create(person, id_program);
    }

    public void update(Student student) {
        crudRepositoryStudent.update(student);
    }

    public void delete(Student student) throws PersonNullException {
        crudRepositoryStudent.delete(student);
    }

    public void delete(String document) throws PersonNullException {
        crudRepositoryStudent.delete(document);
    }

}
