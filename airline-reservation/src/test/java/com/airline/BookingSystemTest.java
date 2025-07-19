package com.airline;

public class BookingSystemTest {

    public static void main(String[] args) {
        // Create an instance of the test class and run the test
        BookingSystemTest test = new BookingSystemTest();
        test.testAddPassenger();
    }

    public void testAddPassenger() {
        // Create a PassengerManager instance
        PassengerManager passengerManager = new PassengerManager();

        // Sample passenger data
        String passengerName = "John Doe";
        String email = "johndoe@example.com";

        // Call addPassenger method and store the result
        Passenger passenger = passengerManager.addPassenger(passengerName, email);

        // Assert that passenger is not null
        assert passenger != null : "Passenger should not be null";
        
        // Assert that the passenger name matches the expected value
        assert passenger.getPassengerName().equals(passengerName) : 
            "Passenger name should match. Expected: " + passengerName + ", but got: " + passenger.getPassengerName();

        // Assert that the passenger email matches the expected value
        assert passenger.getEmail().equals(email) : 
            "Passenger email should match. Expected: " + email + ", but got: " + passenger.getEmail();

        System.out.println("Test passed");
    }
}