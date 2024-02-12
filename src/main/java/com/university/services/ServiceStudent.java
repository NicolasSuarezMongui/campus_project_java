package com.university.services;

import java.util.List;

import com.university.exceptions.personexceptions.PersonExceptionInsertDataBase;
import com.university.exceptions.personexceptions.PersonNullException;
import com.university.repository.models.Person;
import com.university.repository.models.Student;

public interface ServiceStudent {
    
    List<Person> toList();  
    
    Person findByDocument(String document) throws PersonNullException;

    Student findById(int student_id) throws PersonNullException;

    int getId(String document) throws PersonNullException;

    void create(Student student);

    void create(Person person, int id_program) throws PersonExceptionInsertDataBase;

    void update(Student student);

    void delete(Student student) throws PersonNullException;

    void delete(String document) throws PersonNullException;

}
