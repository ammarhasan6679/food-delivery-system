🧾 Spring Boot Project

This is a Spring Boot-based Payment Microservice that allows users to make payments linked to an order. It demonstrates RESTful API design, integration with JPA for database operations, and error handling using custom exceptions.

🚀 Tech Stack
Java 17+

Spring Boot

Spring Web

Spring Data JPA

Hibernate

H2 / MySQL (Pluggable)

Lombok

Postman (for testing)

Maven


🧩 Features

✅ Make payment for a specific order

✅ Custom error handling (e.g., order not found)

✅ Timestamps for payments

✅ Easily pluggable with real-world order service

✅ RESTful endpoint using @RestController

✅ DTO to Entity mapping for clean architecture

🔗 API Endpoints

POST /api/payment/make

Make a payment for a given order.



Clone the repository:

git clone https://github.com/YOUR_USERNAME/springboot-payment-system.git

cd springboot-payment-system

Build and run:

./mvnw spring-boot:run
Test using Postman at:

http://localhost:8080/api/payment/make
📄 To-Do / Upcoming

Integrate with actual Order Service using REST Template or Feign

Will add different Design pattern like Adoptor,Builder and many more to .

Will Deploy it on AWS

Add authentication/authorization (JWT)

Use ResponseEntity for better control over HTTP responses

Use custom exceptions instead of RuntimeException

Store transactions in real DB (MySQL/Postgres)

🤝 Author

Ammar 
