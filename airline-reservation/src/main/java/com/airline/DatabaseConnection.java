package com.airline;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {

    // Connect to MySQL database
    public static Connection connect() {
        try {
            String url = "jdbc:mysql://localhost:3306/airline_db"; 
            String username = "root"; 
            String password = "Si@190905"; 

            // Establish connection
            Connection connection = DriverManager.getConnection(url, username, password);
            System.out.println("Database connected successfully.");
            return connection;

        } catch (SQLException e) {
            System.out.println("Error connecting to the database: " + e.getMessage());
            return null;
        }
    }
}


