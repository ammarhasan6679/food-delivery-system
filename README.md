# 🍽️ Food Ordering Backend System

A scalable and modular backend system for a food ordering platform developed using Java Spring Boot and MySQL. This project handles user management, restaurant and menu data, order processing, and secure multi-mode payments using design patterns.

## 🚀 Features

- 🔹 **User Management**: Register, update, fetch user info
- 🔹 **Restaurant Module**: Manage restaurant info and menus
- 🔹 **Menu Items**: Add, update, delete, and list food items
- 🔹 **Order Module**: Place orders, update status, fetch history
- 🔹 **Payment System**: Integrated Factory, Strategy, and Adapter design patterns to handle UPI, Card, and Cash payments
- 🔹 **Design Principles**: Applied SOLID principles for clean, scalable code
- 🔹 **Database**: Connected to MySQL using Spring Data JPA and Hibernate
- 🔹 **REST APIs**: Built and tested using Postman for complete CRUD operations

## 🧱 Architecture

Controller Layer
↓
Service Layer (Business Logic)
↓
Repository Layer (Data Access)
↓
MySQL Database


Uses DTOs to separate internal models from exposed API data.

## 🛠️ Tech Stack

- **Backend:** Java, Spring Boot, Spring Data JPA, Hibernate
- **Database:** MySQL
- **Testing:** Postman
- **Design Patterns:** Factory, Strategy, Adapter
- **Principles:** SOLID
- **Version Control:** Git, GitHub

## 📁 Project Structure

src/
├── controller/
├── service/
├── model/
├── dto/
├── repository/
└── util/ (for strategy & factory classes)


## 📦 Getting Started

1. Clone the repository  
   ```bash
   git clone https://github.com/yourusername/food-ordering-backend.git
   cd food-ordering-backend

2.Configure your application.properties:

spring.datasource.url=jdbc:mysql://localhost:3306/your_db_name
spring.datasource.username=root
spring.datasource.password=your_password

3.Run the project using your IDE or:
./mvnw spring-boot:run

4.Use Postman to test API endpoints.

✅ Example Endpoints

POST /api/users - Register User

POST /api/orders - Place Order

POST /api/payments - Make Payment

GET /api/menu - Fetch Menu Items

Contributing

Pull requests are welcome. For major changes, please open an issue first.

Happy coding! 💻


