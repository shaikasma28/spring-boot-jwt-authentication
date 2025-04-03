# login-authentication

This is a JWT-based authentication system built using Spring Boot, Spring Security, and MySQL. It allows users to register, log in, and access a secure dashboard using a JWT token.

Features:
User Registration
User Login with JWT Authentication
Password Encryption using BCrypt
Secure API Endpoints
JWT Token Storage & Validation
Frontend Integration

Technologies Used:

Backend (Spring Boot):
Java (Spring Boot)
Spring Security
JWT (JSON Web Token)
Spring Data JPA (MySQL)
Lombok (for reducing boilerplate code)

Frontend:
HTML, CSS, JavaScript
Fetch API for API calls
LocalStorage for storing JWT Token

Run the Project:
1.Create a new database
2.Open src/main/resources/application.properties and update with your MySQL credentials:

spring.datasource.url=jdbc:mysql://localhost:3306/(db_name)
spring.datasource.username=root
spring.datasource.password=yourpassword

3.Update the project and run the project. This will be running on port http://localhost:8081.
4.Frontend part will be running at http://127.0.0.1:5500/index.html
5.Register a New User
Open http://127.0.0.1:5500/register.html

How to use the application:
Enter a Username and Password.
Click Register.

Login with JWT Authentication
Open http://127.0.0.1:5500/index.html
Enter your Username and Password.
Click Login.

If correct, you’ll be redirected to dashboard.html.

Logout:
Click Logout on the dashboard.

You will be redirected back to the login page.

API Endpoints:
Authentication APIs:
Method	Endpoint	Description	Payload
POST	/auth/register	Register User	{ "username": "user1", "password": "pass123" }
POST	/auth/login	Login & Get Token	{ "username": "user1", "password": "pass123" }

Protected API
Method	Endpoint	Description	Header
GET	/user/profile	Get User Details	Authorization: Bearer <JWT_TOKEN>
