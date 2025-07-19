package com.airline;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class FlightManager {
    private List<Flight> flights;

    public FlightManager() {
        flights = new ArrayList<>();
        loadFlightsFromDatabase();  // Load flights when the manager is instantiated
    }

    // Method to load flights from the database
    public void loadFlightsFromDatabase() {
        String query = "SELECT * FROM flights";  // Adjust the query if necessary

        try (Connection connection = DatabaseConnection.connect();  // Use your DatabaseConnection class here
             Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            while (rs.next()) {
                int flightId = rs.getInt("flight_id");
                String flightName = rs.getString("flight_name");
                String source = rs.getString("source");
                String destination = rs.getString("destination");
                String flightDate = rs.getString("flight_date");
                String flightTime = rs.getString("flight_time");
                int seatsAvailable = rs.getInt("seats_available");

                // Create a Flight object and add it to the list
                Flight flight = new Flight(flightId, flightName, source, destination, flightDate, flightTime, seatsAvailable);
                flights.add(flight);
            }

        } catch (SQLException e) {
            System.out.println("Error fetching flights: " + e.getMessage());
        }
    }

    // Method to display all flights
    public void displayFlights() {
        System.out.println("Available Flights:");
        for (Flight flight : flights) {
            System.out.println(flight);
        }
    }

    // Method to get a flight by its ID
    public Flight getFlightById(int flightId) {
        for (Flight flight : flights) {
            if (flight.getFlightId() == flightId) {
                return flight;  // Return the flight if found
            }
        }
        return null;  // Return null if no flight found with the given ID
    }

    // Optionally, you could add a method to fetch the flights directly as a list:
    public List<Flight> getFlights() {
        return flights;
    }
}
