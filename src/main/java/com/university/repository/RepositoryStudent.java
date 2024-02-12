package com.university.repository;

import java.util.List;

import com.university.exceptions.personexceptions.PersonExceptionInsertDataBase;
import com.university.repository.models.Person;
import com.university.repository.models.Student;

public interface RepositoryStudent {
    
    List<Person> toList();
    
    Person findByDocument(String document);

    void create(Student student);

    void create(Person person, int id_program) throws PersonExceptionInsertDataBase;

    void update(Student student);

    void delete(Student student);

    void delete(String document);

}
