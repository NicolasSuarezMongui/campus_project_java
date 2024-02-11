package com.university.repository;

import java.util.List;

import com.university.repository.models.Person;
import com.university.repository.models.Teacher;

public interface RepositoryTeacher {
    
    List<Person> toList();

    Person findByDocument(String document);

    void create(Teacher teacher);

    void update(Teacher teacher);

    void delete(Teacher teacher);

}
