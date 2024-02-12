package com.university.services.impl;

import java.util.List;

import com.university.exceptions.personexceptions.PersonExceptionInsertDataBase;
import com.university.repository.RepositoryPerson;
import com.university.repository.models.Person;
import com.university.services.ServicePerson;

public class ServicePersonImpl implements ServicePerson{

    private final RepositoryPerson crudRepositoryPerson;

    public ServicePersonImpl(RepositoryPerson crudRepositoryPerson) {
        this.crudRepositoryPerson = crudRepositoryPerson;
    }
    
    public List<Person> toList(){
        return crudRepositoryPerson.toList();
    }

    public Person findByDocument(String Document) {
        return crudRepositoryPerson.findByDocument(Document);
    }

    public void create(Person person) throws PersonExceptionInsertDataBase{
        crudRepositoryPerson.create(person);
    }

    public void update(Person person){
        crudRepositoryPerson.update(person);
    }

    public void delete(Person person){
        crudRepositoryPerson.delete(person);
    }

}
