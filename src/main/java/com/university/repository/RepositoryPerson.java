package com.university.repository;

import java.util.List;

import com.university.exceptions.personexceptions.PersonExceptionInsertDataBase;
import com.university.repository.models.Person;

public interface RepositoryPerson {
    
    List<Person> toList();

    Person findByDocument(String document);

    void create(Person person) throws PersonExceptionInsertDataBase;

    void update(Person person);

    void delete(Person person);

}
