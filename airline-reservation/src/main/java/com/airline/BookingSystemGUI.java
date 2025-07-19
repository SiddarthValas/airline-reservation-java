package com.airline;

import com.formdev.flatlaf.FlatLightLaf;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.Date;
import java.util.List;

public class BookingSystemGUI {

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(new FlatLightLaf());
        } catch (UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }

        SwingUtilities.invokeLater(BookingSystemGUI::createAndShowGUI);
    }

    public static void createAndShowGUI() {
        JFrame frame = new JFrame("Airline Reservation System");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(700, 500);
        frame.setLayout(new BorderLayout());

        JPanel panel = new JPanel(new GridLayout(6, 2, 10, 10));
        panel.setBackground(new Color(240, 240, 240));

        // Passenger Name
        JLabel nameLabel = new JLabel("Enter Passenger Name:");
        nameLabel.setFont(new Font("Segoe UI", Font.BOLD, 14));
        nameLabel.setForeground(new Color(0, 102, 204));
        JTextField nameField = new JTextField();

        // Passenger Email
        JLabel emailLabel = new JLabel("Enter Email:");
        emailLabel.setFont(new Font("Segoe UI", Font.BOLD, 14));
        emailLabel.setForeground(new Color(0, 102, 204));
        JTextField emailField = new JTextField();

        // Flight Selection
        JLabel flightLabel = new JLabel("Select Flight:");
        flightLabel.setFont(new Font("Segoe UI", Font.BOLD, 14));
        flightLabel.setForeground(new Color(0, 102, 204));
        JComboBox<String> flightComboBox = new JComboBox<>();
        FlightManager flightManager = new FlightManager();
        List<Flight> flights = flightManager.getFlights();

        if (flights.isEmpty()) {
            flightComboBox.addItem("No flights available");
        } else {
            for (Flight flight : flights) {
                String item = flight.getFlightId() + " - " + flight.getFlightName() + " | " +
                        flight.getSource() + " ➔ " + flight.getDestination() + " | " +
                        flight.getFlightDate() + " " + flight.getFlightTime() + " | " +
                        "Seats: " + flight.getSeatsAvailable();
                flightComboBox.addItem(item);
            }
        }

        // Submit Button
        JButton submitButton = new JButton("Book Flight");
        submitButton.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        submitButton.setBackground(new Color(0, 153, 51));
        submitButton.setForeground(Color.WHITE);

        submitButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                submitButton.setBackground(new Color(0, 204, 102));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                submitButton.setBackground(new Color(0, 153, 51));
            }
        });

        // Booking Logic
        submitButton.addActionListener(e -> {
            String passengerName = nameField.getText().trim();
            String email = emailField.getText().trim();
            String selectedFlight = (String) flightComboBox.getSelectedItem();

            if (passengerName.isEmpty() || email.isEmpty() || selectedFlight == null || selectedFlight.contains("No flights")) {
                JOptionPane.showMessageDialog(frame, "Please enter all details and select a valid flight.", "Input Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            // Extract flight ID
            int flightId;
            try {
                flightId = Integer.parseInt(selectedFlight.split(" - ")[0].trim());
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(frame, "Invalid flight selection.", "Input Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            // Add passenger
            PassengerManager passengerManager = new PassengerManager();
            Passenger newPassenger = passengerManager.addPassenger(passengerName, email);

            if (newPassenger != null) {
                // Book flight with current date
                BookingManager bookingManager = new BookingManager();
                java.sql.Date currentDate = java.sql.Date.valueOf(java.time.LocalDate.now());  // Fixing the date issue here
                bookingManager.createBooking(newPassenger, flightId, currentDate); // Assuming the booking method is fixed to use Date
                JOptionPane.showMessageDialog(frame, "Booking successful!\nPassenger: " + newPassenger.getPassengerName() + "\nFlight ID: " + flightId);
            } else {
                JOptionPane.showMessageDialog(frame, "Failed to add passenger. Please try again.", "Database Error", JOptionPane.ERROR_MESSAGE);
            }

            nameField.setText("");
            emailField.setText("");
        });

        // Add components
        panel.add(nameLabel);
        panel.add(nameField);
        panel.add(emailLabel);
        panel.add(emailField);
        panel.add(flightLabel);
        panel.add(flightComboBox);
        panel.add(new JLabel());  // Spacer
        panel.add(submitButton);

        frame.add(panel, BorderLayout.CENTER);
        frame.setVisible(true);
    }
}
