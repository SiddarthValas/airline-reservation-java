package com.airline;

import com.airline.Passenger;
import java.sql.Date;
import java.time.LocalDate;
import java.util.Scanner;

public class BookingSystem {

    public static void main(String[] args) {
        System.out.println("Welcome to the Airline Reservation System!");

        // Create instances of FlightManager, PassengerManager, and BookingManager
        FlightManager flightManager = new FlightManager();
        PassengerManager passengerManager = new PassengerManager();
        BookingManager bookingManager = new BookingManager();

        // Display available flights from database
        flightManager.displayFlights();

        // Input for making a booking
        Scanner scanner = new Scanner(System.in);
        System.out.print("\nEnter Passenger Name: ");
        String passengerName = scanner.nextLine();

        System.out.print("Enter Passenger Email: ");
        String email = scanner.nextLine();  // Added email input

        System.out.print("Enter Flight ID to book: ");
        int flightId = scanner.nextInt();

        // Create a new passenger and add to the database
        Passenger passenger = passengerManager.addPassenger(passengerName, email); // Call updated method

        // If the passenger is added successfully, create a booking
        if (passenger != null) {
            // Get current date as java.sql.Date
            Date currentDate = Date.valueOf(LocalDate.now());

            // Call the createBooking method with the correct arguments
            bookingManager.createBooking(passenger, flightId, currentDate);
            System.out.println("Booking successful!");
        } else {
            System.out.println("Error: Could not add passenger.");
        }

        scanner.close();
    }
}
