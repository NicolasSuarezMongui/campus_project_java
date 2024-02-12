package com.university;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.SQLException;
import java.util.Scanner;


import com.university.repository.impl.implperson.RepositoryPersonMysqlImpl;
import com.university.repository.impl.implprogram.RepositoryProgramMysqlImpl;
import com.university.repository.impl.implstudent.RepositoryStudentMysqlImpl;
import com.university.repository.models.Program;
import com.university.services.ServiceProgram;
import com.university.services.impl.ServiceProgramImpl;
import com.university.utils.connectionsdb.connectiondbmysql.ConexionBDMysql;

public class Main {
    public static void main(String[] args) {
        try (Connection conn = ConexionBDMysql.getInstance()) {
            conn.setAutoCommit(false);
            if (!conn.getAutoCommit()) {
                System.out.println("autoCommit correctamente configurado a false");
            } else {
                System.out.println("autoCommit no está configurado a false.");
                
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}