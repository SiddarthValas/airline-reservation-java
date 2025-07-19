package com.airline;

public class Passenger {
    private int passengerId;  // Unique identifier for each passenger
    private String passengerName;
    private String email;

    // Constructor that takes passengerId, passengerName, and email
    public Passenger(int passengerId, String passengerName, String email) {
        this.passengerId = passengerId;
        this.passengerName = passengerName;
        this.email = email;
    }

    // Constructor that only takes passengerName and email
    public Passenger(String passengerName, String email) {
        this.passengerName = passengerName;
        this.email = email;
    }

    // Getters and Setters
    public int getPassengerId() {
        return passengerId;
    }

    public void setPassengerId(int passengerId) {
        this.passengerId = passengerId;
    }

    public String getPassengerName() {
        return passengerName;
    }

    public void setPassengerName(String passengerName) {
        this.passengerName = passengerName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    // Optionally, add a toString() method for easy printing of passenger details
    @Override
    public String toString() {
        return "Passenger ID: " + passengerId + ", Name: " + passengerName + ", Email: " + email;
    }
}
