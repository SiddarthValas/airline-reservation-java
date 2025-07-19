CREATE DATABASE airline_db;
USE airline_db;

CREATE TABLE flights (
    flight_id INT PRIMARY KEY AUTO_INCREMENT,
    flight_name VARCHAR(100) NOT NULL,
    source VARCHAR(100) NOT NULL,
    destination VARCHAR(100) NOT NULL,
    flight_date DATE NOT NULL,
    flight_time TIME NOT NULL,
    seats_available INT DEFAULT 60
);

CREATE TABLE passengers (
    passenger_id INT PRIMARY KEY AUTO_INCREMENT,
    passenger_name VARCHAR(100) NOT NULL,
    email VARCHAR(100) NOT NULL
);

CREATE TABLE bookings (
    booking_id INT PRIMARY KEY AUTO_INCREMENT,
    passenger_id INT NOT NULL,
    flight_id INT NOT NULL,
    booking_date DATETIME DEFAULT CURRENT_TIMESTAMP,
    CONSTRAINT fk_passenger FOREIGN KEY (passenger_id) REFERENCES passengers(passenger_id) ON DELETE CASCADE,
    CONSTRAINT fk_flight FOREIGN KEY (flight_id) REFERENCES flights(flight_id) ON DELETE CASCADE
);

INSERT INTO passengers (passenger_name, email) VALUES
('Siddarth', 'Siddarth@gmail.com'),
('Rashi', 'Rashi@gmail.com'),
('Roshni', 'Rosh@gmail.com'),
('Ambar','Ambr@gmail.com'),
('Arnav','Arnav@gmail.com'),
('John Doe', 'john@example.com'),
('Alice Smith', 'alice@example.com'),
('Bob Johnson', 'bob@example.com');


INSERT INTO flights (flight_name, source, destination, flight_date, flight_time, seats_available) VALUES
('Air India 101', 'Delhi', 'Mumbai', '2025-05-10', '09:00:00', 60),
('IndiGo 202', 'Bangalore', 'Kolkata', '2025-05-11', '14:00:00', 55),
('SpiceJet 303', 'Chennai', 'Delhi', '2025-05-12', '18:00:00', 50),
('Vistara 404', 'Mumbai', 'Goa', '2025-05-13', '07:30:00', 45),
('Air India 505', 'Delhi', 'Hyderabad', '2025-05-15', '10:00:00', 60),
('IndiGo 606', 'Mumbai', 'Dehradun', '2025-05-16', '11:30:00', 55),
('SpiceJet 707', 'Bangalore', 'Raipur', '2025-05-17', '15:45:00', 50),
('Vistara 808', 'Kolkata', 'Hyderabad', '2025-05-18', '16:00:00', 45),
('GoAir 909', 'Chennai', 'Dehradun', '2025-05-19', '12:30:00', 50),
('Air India 1010', 'Raipur', 'Delhi', '2025-05-20', '07:00:00', 55),
('Air India 1011', 'Hyderabad', 'Raipur', '2025-05-21', '08:00:00', 60),
('IndiGo 2022', 'Raipur', 'Hyderabad', '2025-05-22', '14:30:00', 55);


INSERT INTO bookings (passenger_id, flight_id) VALUES 
(1, 12),  -- Siddarth
(2, 12),  -- Rashi
(3, 12);  -- Roshni

-- Insert bookings for other passengers
-- Ambar books flight from Delhi to Hyderabad (Flight ID 5)
INSERT INTO bookings (passenger_id, flight_id) VALUES (4, 5);

-- Arnav books flight from Bangalore to Raipur (Flight ID 7)
INSERT INTO bookings (passenger_id, flight_id) VALUES (5, 7);

-- John Doe books flight from Delhi to Mumbai (Flight ID 1)
INSERT INTO bookings (passenger_id, flight_id) VALUES (6, 1);

-- Alice Smith books flight from Mumbai to Dehradun (Flight ID 6)
INSERT INTO bookings (passenger_id, flight_id) VALUES (7, 6);

-- Bob Johnson books flight from Chennai to Delhi (Flight ID 3)
INSERT INTO bookings (passenger_id, flight_id) VALUES (8, 3);


SHOW DATABASES;
USE airline_db;
SHOW TABLES;

SELECT USER();

SELECT user, host FROM mysql.user;

Select *from Passengers;

show tables;

select *from bookings;
select *from flights;
select *from passengers;
