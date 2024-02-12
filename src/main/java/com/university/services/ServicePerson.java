package com.university.services;

import java.util.List;

import com.university.repository.models.Person;

public interface ServicePerson {
    
    List<Person> toList();

    Person findByDocument(String Document);

    void create(Person person);

    void update(Person person);

    void delete(Person person);

}
