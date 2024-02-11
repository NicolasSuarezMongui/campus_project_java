package com.university;

import com.university.repository.impl.implperson.RepositoryPersonMysqlImpl;
import com.university.repository.impl.implstudent.RepositoryStudentMysqlImpl;
import com.university.repository.models.Person;

public class Main {
    public static void main(String[] args) {
        RepositoryPersonMysqlImpl repositoryPersonMysqlImpl = new RepositoryPersonMysqlImpl();
        RepositoryStudentMysqlImpl repositoryStudentMysqlImpl = new RepositoryStudentMysqlImpl();
        for (Person person : repositoryPersonMysqlImpl.toList()){
            System.out.println(person);
        }
        Person currentPerson = new Person("C.C", "123456789", "Juan", "Perez", 1, 1);
        repositoryStudentMysqlImpl.create(currentPerson, 1);
        System.out.println("After Delete");
        for (Person person : repositoryPersonMysqlImpl.toListStudents()){
            System.out.println(person);
        }
    }
}