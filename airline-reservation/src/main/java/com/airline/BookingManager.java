package com.airline;

import java.sql.*;

public class BookingManager {

    // Method to create a booking
    public void createBooking(Passenger passenger, int flightId, java.sql.Date bookingDate) {
        // Correct SQL query with the passenger_id, flight_id, and booking_date columns
        String query = "INSERT INTO bookings (passenger_id, flight_id, booking_date) VALUES (?, ?, ?)";

        try (Connection connection = DatabaseConnection.connect();
             PreparedStatement stmt = connection.prepareStatement(query)) {

            // Correctly using passenger_id from the Passenger object
            stmt.setInt(1, passenger.getPassengerId());

            // Using flightId for the flight in the bookings table
            stmt.setInt(2, flightId); // Set the flightId at the correct position

            // Setting the booking date
            stmt.setDate(3, bookingDate); // Set the booking date (current date)

            // Execute the query to create the booking
            stmt.executeUpdate();
            System.out.println("Booking successful for passenger: " + passenger.getPassengerName());

        } catch (SQLException e) {
            System.out.println("Error creating booking: " + e.getMessage());
        }
    }

}  
