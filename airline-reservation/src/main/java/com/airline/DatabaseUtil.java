package com.airline;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseUtil {

    // Method to get the database connection
    public static Connection connect() throws SQLException {

        String url = "jdbc:mysql://localhost:3306/airline_db";
        String username = "root"; 
        String password = ""; 

        // Return the connection object
        return DriverManager.getConnection(url, username, password);
    }
}

