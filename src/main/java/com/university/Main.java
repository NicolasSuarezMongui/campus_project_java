package com.university;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.SQLException;
import java.util.Scanner;


import com.university.repository.impl.implperson.RepositoryPersonMysqlImpl;
import com.university.repository.impl.implprogram.RepositoryProgramMysqlImpl;
import com.university.repository.impl.implstudent.RepositoryStudentMysqlImpl;
import com.university.repository.models.Person;
import com.university.repository.models.Program;
import com.university.services.ServiceProgram;
import com.university.services.impl.ServiceProgramImpl;
import com.university.utils.connectionsdb.connectiondbmysql.ConexionBDMysql;

public class Main {
    public static void main(String[] args) {
        RepositoryPersonMysqlImpl repositoryPersonMysqlImpl = new RepositoryPersonMysqlImpl();
        for (Person person : repositoryPersonMysqlImpl.toList()) {
            System.out.println(person);
        }
    }
}