# 🚀 90 Days Backend Challenge

This repository documents my **90-day backend engineering challenge** using **Java & Spring Boot**.  
The goal is to build a **production-grade backend foundation** by working on real-world APIs and following industry-level practices — **learning by building, in public**.

---

## 🎯 Goal

To become a confident backend developer by:

- Building production-style REST APIs
- Following clean architecture (Controller → Service → Repository)
- Writing scalable and maintainable backend code
- Handling errors, validations, and edge cases professionally
- Understanding real-world backend request–response flows
- Implementing authentication & authorization correctly
- Designing consistent, frontend-friendly API responses
- Applying production-level security practices
- Debugging real-world backend & security issues
- Sharing daily learning and progress publicly

---

## 🛠 Tech Stack

- Java  
- Spring Boot  
- Spring Data JPA  
- Spring Security  
- JWT (JSON Web Token)  
- MySQL  
- Maven  
- Git & GitHub  
- Postman  

---

## 📅 Progress Tracker

### ✅ Day 1 – Foundation Setup
- Spring Boot project initialization
- Clean package structure
- Basic controller setup
- Database connection verified

---

### ✅ Day 2 – Database & Create API
- User entity creation
- Repository, service, and controller layers
- POST API implementation
- Postman testing
- Handled duplicate email constraint

---

### ✅ Day 3 – Clean APIs & Validation
- DTO implementation
- Request validation
- Global exception handling
- Clean and secure API responses

---

### ✅ Day 4 – Read APIs
- GET all users API
- GET user by ID API
- Custom 404 handling for invalid IDs
- Improved service-layer logic
- Complete Postman testing

---

### ✅ Day 5 – Update & Delete APIs (CRUD Complete)
- PUT API to update user details
- DELETE API to remove users
- Proper validation before update/delete
- Clean 404 handling for missing resources
- Full CRUD flow completed
- Real-world Git merge conflict handling experience

---

### ✅ Day 6 – Pagination, Sorting & Search APIs
- Implemented pagination using `Pageable`
- Sorting support using dynamic fields
- Search users by name (case-insensitive)
- Fetch user details by email
- Proper handling of invalid email cases
- Removed Lombok dependency
- Improved real-world backend API usability

---

### ✅ Day 7 – Week 1 Review & Code Polish
- Full API retesting using Postman
- Code cleanup and formatting
- Verified service-layer logic and edge cases
- Updated project documentation
- Week 1 backend foundation completed

---

### ✅ Day 8 – Spring Security Basics
- Introduced Spring Security
- Understood default security behavior (401 / 403)
- Configured custom security rules
- Disabled session-based authentication
- Prepared project for JWT integration

---

### ✅ Day 9 – JWT Authentication Implementation
- Designed JWT authentication flow
- Implemented login API with token generation
- Created `JwtUtil` for token creation & validation
- Implemented `JwtAuthFilter`
- Integrated custom `UserDetailsService`
- Tested JWT flow using Postman

---

### ✅ Day 10 – JWT Stabilization & Protected APIs
- Stabilized JWT authentication flow
- Stateless security configuration
- Public vs protected endpoints separation
- Secured APIs using Authorization header
- Handled expired and invalid tokens
- End-to-end API testing

---

### ✅ Day 11 – Role-Based Access Control (RBAC)
- Added **USER** and **ADMIN** roles
- Stored roles at database level
- Implemented `ROLE_` based authorities
- Secured admin-only endpoints (`/admin/**`)
- Debugged real-world **403 Forbidden** issues
- Verified admin & user access using JWT
- Understood production-level authorization flow

---

### ✅ Day 12 – API Response Standardization
- Designed global `ApiResponse<T>` structure
- Unified success and error responses
- Standardized response format across all APIs
- Made backend responses frontend-friendly
- Removed default Spring error responses
- Improved maintainability and predictability

---

### ✅ Day 13 – Security Error Handling (Production-Level)
- Implemented custom `AuthenticationEntryPoint` (401)
- Implemented custom `AccessDeniedHandler` (403)
- Replaced default Spring Security error pages
- Returned clean JSON error responses
- Integrated security errors with `ApiResponse`
- Achieved production-grade security behavior

---

### ✅ Day 14 – Security Stabilization & Filter Debugging
- Deep debugging of Spring Security filter chain
- Fixed JWT filter ordering and initialization issues
- Resolved real-world startup and runtime errors
- Integrated request/response logging filter
- Ensured clean application startup without warnings
- Strengthened understanding of Spring Security internals
- Achieved stable, production-ready security setup

---

### ✅ Day 15 – Production-Grade Security & Error Consistency
- Implemented custom `AuthenticationEntryPoint` (401 handling)
- Implemented custom `AccessDeniedHandler` (403 handling)
- Centralized global exception handling
- Standardized all success & error responses using `ApiResponse<T>`
- Removed default Spring Security error responses
- Prevented exposure of sensitive internal error details
- Fixed remaining security filter ordering issues
- Verified all edge cases using Postman (401 / 403 / validation errors)
- Achieved predictable, frontend-friendly API behavior

---

## 📘 API Endpoints

### Authentication
- **POST** `/auth/login` – Login & generate JWT token

### Users
- **POST** `/users` – Create user (public)
- **GET** `/users` – Get all users (JWT required)
- **GET** `/users/{id}` – Get user by ID (JWT required)
- **GET** `/users/search?name=` – Search users by name
- **GET** `/users/email/{email}` – Get user by email
- **PUT** `/users/{id}` – Update user (JWT required)
- **DELETE** `/users/{id}` – Delete user (JWT required)

### Admin
- **GET** `/admin/dashboard` – Admin-only access

---

## 📌 Current Status

**Day 15 completed successfully** ✅

✔ Full CRUD APIs implemented  
✔ Pagination, sorting & search added  
✔ Spring Security integrated  
✔ JWT authentication working end-to-end  
✔ Role-based access control implemented  
✔ Custom 401 / 403 security handling  
✔ Standardized API responses  
✔ Secure & stable filter chain  
✔ Stateless backend architecture  
✔ Production-grade error handling  
✔ All APIs tested with Postman  
✔ Real-world debugging & security issues resolved  

---

## 🚀 Next Phase (Week 3 Preview)

- API versioning
- Logging & monitoring fundamentals
- Correlation IDs & request tracing
- Performance considerations
- Backend refactoring & best practices
- Interview-level backend discussions

---

> Learning by building.  
> Debugging by doing.  
> Backend engineering — **in public** 🚀🔥
