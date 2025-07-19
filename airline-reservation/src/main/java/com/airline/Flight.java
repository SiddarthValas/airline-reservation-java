package com.airline;

public class Flight {
    private int flightId;
    private String flightName;
    private String source;
    private String destination;
    private String flightDate;
    private String flightTime;
    private int seatsAvailable;

    public Flight(int flightId, String flightName, String source, String destination, String flightDate, String flightTime, int seatsAvailable) {
        this.flightId = flightId;
        this.flightName = flightName;
        this.source = source;
        this.destination = destination;
        this.flightDate = flightDate;
        this.flightTime = flightTime;
        this.seatsAvailable = seatsAvailable;
    }

    public int getFlightId() {
        return flightId;
    }

    public String getFlightName() {
        return flightName;
    }

    public String getSource() {
        return source;
    }

    public String getDestination() {
        return destination;
    }

    public String getFlightDate() {
        return flightDate;
    }

    public String getFlightTime() {
        return flightTime;
    }

    public int getSeatsAvailable() {
        return seatsAvailable;
    }

    @Override
    public String toString() {
        return flightName + " (" + flightId + ") - " + source + " to " + destination + " on " + flightDate + " at " + flightTime + " with " + seatsAvailable + " seats available.";
    }
}
