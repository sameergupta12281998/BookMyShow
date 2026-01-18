🎬 BookMyShow – Monolithic Backend (Spring Boot)
📌 Overview

This project is a monolithic backend implementation of a BookMyShow-like movie ticket booking system built using Spring Boot and PostgreSQL.

The system allows users to:

Browse theatres and shows

View seat availability

Book tickets

Lock seats during booking

Make payments (simulated)

Receive booking notifications (logged)

❌ No authentication is used (as per requirement).
✔ Focus is on core booking functionality, database design, and transaction handling.

🛠 Tech Stack

Java 17

Spring Boot 3.x

Spring Data JPA

PostgreSQL

Maven

JUnit 5 & Mockito

🧱 Architecture (Monolithic)
Controller → Service → Repository → Database

Modules

Catalog (Theatres, Movies, Shows)

Seat Management

Booking

Payment (Simulation)

Notification (Logging + DB)

🌐 REST APIs
🎥 Browse Shows
GET /api/catalog/shows?theatreId={id}&date=YYYY-MM-DD

💺 View Seats
GET /api/shows/{showId}/seats

🎟 Create Booking
POST /api/bookings


Request Body

{
  "showId": 1,
  "showSeatIds": [1,2,3],
  "userEmail": "user@example.com"
}

💳 Payment (Simulated)
POST /api/bookings/{bookingId}/pay?success=true

📄 View Booking
GET /api/bookings/{bookingId}

⚙ Configuration
Database

Create database manually:

CREATE DATABASE bookmyshow;

application.yml
spring:
  datasource:
    url: jdbc:postgresql://localhost:5432/bookmyshow
    username: postgres
    password: postgres
  jpa:
    hibernate:
      ddl-auto: update
    show-sql: true
server:
  port: 8080

▶️ How to Run
mvn clean install
mvn spring-boot:run


Application starts at:

http://localhost:8080

🧪 Testing
Unit Tests Included

BookingServiceTest

Mockito-based service testing

Seat locking validation

Run tests:

mvn test

📌 Assumptions & Notes

Payment gateway is simulated

Notifications are logged & stored in DB

Pricing is fixed (₹100 per seat for demo)

No concurrency handling beyond transactional locking (can be extended)
