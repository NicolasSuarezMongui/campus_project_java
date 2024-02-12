package com.university.services;

import java.util.List;

import com.university.exceptions.personexceptions.PersonException;
import com.university.repository.models.Person;
import com.university.repository.models.Teacher;

public interface ServiceTeacher {
    
    List<Person> toList();

    Person findByDocument(String document) throws PersonException;

    void create(Teacher teacher);

    void update(Teacher teacher);

    void delete(Teacher teacher);

}
