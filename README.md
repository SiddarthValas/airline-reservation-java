✈️ Airline Reservation System

A Java-based GUI application that allows users to book flights, manage passengers, and store booking data in a MySQL database. The system provides a smooth experience for both users and administrators, with functionalities like flight management, passenger registration, and seat booking.

⸻

🧠 Objective

The goal of this project is to create an interactive and persistent Airline Reservation System that:
	•	Allows admins to manage flight details
	•	Enables passengers to book flights
	•	Stores all data in a relational MySQL database
	•	Provides a user-friendly interface for operations

⸻

🚀 Features

👩‍💼 Admin Side
	•	Add and manage flights (name, source, destination, date, available seats)
	•	View flight listings

🧑‍✈️ User Side
	•	View available flights
	•	Register as a passenger (name and email)
	•	Book selected flights
	•	Receive confirmation message after booking

⸻

🛠️ Tech Stack & Tools

Component	Technology Used
Programming Language	Java
GUI Framework	Java Swing + FlatLightLaf
Database	MySQL
DB Connectivity	JDBC
Build Tool	Maven
SQL Usage	SELECT, INSERT, UPDATE, DELETE


⸻

🗃️ Database Schema
	•	flights: Stores flight details (id, name, source, destination, date, seats)
	•	passengers: Stores passenger details (id, name, email)
	•	bookings: Maps passengers to flights with booking timestamp

⸻

📸 UI Screenshots

You can add screenshots of the GUI here if available (e.g., Booking Window, Admin Panel).

⸻

🧩 Installation & Usage

✅ Prerequisites
	•	Java JDK installed
	•	MySQL Server setup
	•	Maven installed

⚙️ Steps
	1.	Clone this repository:

git clone https://github.com/yourusername/airline-reservation-system.git


	2.	Set up your MySQL database using the provided schema (if available)
	3.	Configure DB connection inside the Java source files (JDBC URL, user, password)
	4.	Compile and run the project using Maven:

mvn clean install
mvn exec:java



⸻

📚 Concepts Applied
	•	Object-Oriented Programming (OOP)
	•	GUI Event Handling (ActionListener, MouseListener)
	•	SQL CRUD operations
	•	JDBC and PreparedStatement
	•	Exception Handling and Logging

⸻

🧑‍💻 Author

Siddarth Valasubramanian

⸻

📄 License

This project is for educational purposes only.
