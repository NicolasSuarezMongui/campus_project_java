package com.university.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Configuracion {
    
    private static Properties properties;

    static {
        properties = new Properties();
        loadProperties();
    }

    private static void loadProperties() {
        try (FileInputStream file = new FileInputStream("configuracion.properties")) {
            properties.load(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String getValue(String key) {
        return properties.getProperty(key);
    }

}
