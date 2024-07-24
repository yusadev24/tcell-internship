package org.atmosware.database;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {

    public static Connection getConnection() {
        try {
            // Corrected connection string to include DB_CLOSE_DELAY=-1 without any extra spaces
            return DriverManager.getConnection("jdbc:h2:mem:testdb;DB_CLOSE_DELAY=-1", "admin", "test");
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        return null; // Return null if connection could not be established
    }
    }
