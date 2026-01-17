package com.edutech.progressive.config;


import java.sql.DriverManager;
import java.sql.SQLException;


import java.io.InputStream;
import java.sql.Connection;

import java.util.Properties;



import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DatabaseConnectionManager {

    private static final Properties props = new Properties();
    private static boolean loaded = false;

    private static synchronized void loadProperties() {
        if (loaded) return;
        try (InputStream in = DatabaseConnectionManager.class
                .getClassLoader()
                .getResourceAsStream("application.properties")) {
            if (in == null) throw new RuntimeException("application.properties not found on classpath");
            props.load(in);
            String driver = props.getProperty("db.driver-class-name");
            if (driver != null && !driver.isBlank()) {
                Class.forName(driver);
            }
            loaded = true;
        } catch (Exception e) {
            throw new RuntimeException("Failed to load DB properties", e);
        }
    }

    public static Connection getConnection() throws SQLException {
        if (!loaded) loadProperties();
        String url = props.getProperty("db.url");
        String user = props.getProperty("db.username");
        String pass = props.getProperty("db.password");
        if (url == null || user == null) throw new SQLException("Missing DB properties (db.url / db.username)");
        return DriverManager.getConnection(url, user, pass);
    }
}
