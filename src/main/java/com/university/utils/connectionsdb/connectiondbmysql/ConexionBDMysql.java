package com.university.utils.connectionsdb.connectiondbmysql;

import java.sql.Connection;
import java.sql.SQLException;

import com.university.utils.Configuracion;

public class ConexionBDMysql {

    private static String url=Configuracion.getValue("db.url");
    private static String username=Configuracion.getValue("db.username");
    private static String password=Configuracion.getValue("db.password");
    private static Connection connection;

    public static Connection getInstance() throws SQLException {
        if (connection == null) {
            connection = java.sql.DriverManager.getConnection(url, username, password);
        }
        return connection;
    }
    
}
