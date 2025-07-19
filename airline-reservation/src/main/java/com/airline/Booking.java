package com.airline;

import java.util.Date;

public class Booking {
    private int bookingId;
    private Passenger passenger;
    private Flight flight;
    private Date bookingDate;

    public Booking(int bookingId, Passenger passenger, Flight flight) {
        this.bookingId = bookingId;
        this.passenger = passenger;
        this.flight = flight;
        this.bookingDate = new Date(); // Set booking date to current time
    }

    public int getBookingId() {
        return bookingId;
    }

    public Passenger getPassenger() {
        return passenger;
    }

    public Flight getFlight() {
        return flight;
    }

    public Date getBookingDate() {
        return bookingDate;
    }

    @Override
    public String toString() {
        return "Booking ID: " + bookingId + " | Passenger: " + passenger + " | Flight: " + flight + " | Date: " + bookingDate;
    }
}