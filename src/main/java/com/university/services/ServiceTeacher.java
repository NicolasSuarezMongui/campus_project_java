package com.university.services;

import java.util.List;

import com.university.exceptions.personexceptions.PersonExceptionInsertDataBase;
import com.university.exceptions.personexceptions.PersonNullException;
import com.university.repository.models.Person;
import com.university.repository.models.Teacher;

public interface ServiceTeacher {
    
    List<Person> toList();

    Person findByDocument(String document) throws PersonNullException;

    void create(Teacher teacher);

    void create(Person person, int id_department) throws PersonExceptionInsertDataBase;

    void update(Teacher teacher);

    void delete(Teacher teacher) throws PersonNullException;

    void delete(String document) throws PersonNullException;

}
