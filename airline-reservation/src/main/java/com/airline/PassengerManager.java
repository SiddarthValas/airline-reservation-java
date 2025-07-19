package com.airline;

import java.sql.*;

public class PassengerManager {

    public Connection getConnection() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/airline_db";
        String user = "root";
        String password = "Si@190905";

        return DriverManager.getConnection(url, user, password);
    }

    public Passenger addPassenger(String passengerName, String email) {
        String sql = "INSERT INTO passengers (passenger_name, email) VALUES (?, ?)";
        Passenger newPassenger = null;

        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            statement.setString(1, passengerName);
            statement.setString(2, email);

            int rowsAffected = statement.executeUpdate();

            if (rowsAffected > 0) {
                try (ResultSet generatedKeys = statement.getGeneratedKeys()) {
                    if (generatedKeys.next()) {
                        int passengerId = generatedKeys.getInt(1);
                        newPassenger = new Passenger(passengerId, passengerName, email);
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return newPassenger;
    }
}