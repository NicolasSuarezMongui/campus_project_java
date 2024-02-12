package com.university.services;

import java.util.List;

import com.university.exceptions.personexceptions.PersonException;
import com.university.repository.models.Person;
import com.university.repository.models.Student;

public interface ServiceStudent {
    
    List<Person> toList();  
    
    Person findByDocument(String document) throws PersonException;

    void create(Student student);

    void update(Student student);

    void delete(Student student);

}
