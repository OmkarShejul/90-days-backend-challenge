---

# 90 Days Backend Challenge 🚀

This repository documents my **90-day backend engineering challenge** using **Java & Spring Boot**.
The goal is to build a **production-grade backend foundation** by working on real-world APIs and following industry-level practices — **learning by building, in public**.

---

## 🎯 Goal

To become a confident backend developer by:

* Building production-style REST APIs
* Following clean architecture (Controller → Service → Repository)
* Writing scalable and maintainable backend code
* Handling errors, validations, and edge cases properly
* Understanding real-world backend flows
* Implementing authentication & authorization correctly
* Designing consistent, frontend-friendly API responses
* Sharing daily learning and progress publicly

---

## 🛠 Tech Stack

* Java
* Spring Boot
* Spring Data JPA
* Spring Security
* JWT (JSON Web Token)
* MySQL
* Maven
* Git & GitHub
* Postman

---

## 📅 Progress Tracker

### ✅ Day 1 – Foundation Setup

* Spring Boot project initialization
* Clean package structure
* Basic controller setup
* Database connection verified

---

### ✅ Day 2 – Database & Create API

* User entity creation
* Repository, service, and controller layers
* POST API implementation
* Postman testing
* Handled duplicate email constraint

---

### ✅ Day 3 – Clean APIs & Validation

* DTO implementation
* Request validation
* Global exception handling
* Clean and secure API responses

---

### ✅ Day 4 – Read APIs

* GET all users API
* GET user by ID API
* Custom 404 handling for invalid IDs
* Improved service-layer logic
* Complete Postman testing

---

### ✅ Day 5 – Update & Delete APIs (CRUD Complete)

* PUT API to update user details
* DELETE API to remove users
* Proper validation before update/delete
* Clean 404 handling for missing resources
* Full CRUD flow completed
* Real-world Git merge conflict handling experience

---

### ✅ Day 6 – Pagination, Sorting & Search APIs

* Implemented pagination using `Pageable`
* Sorting support using dynamic fields
* Search users by name (case-insensitive)
* Fetch user details by email
* Proper handling of invalid email cases
* Removed Lombok dependency and fixed constructor issues
* Deep Postman testing for all scenarios
* Improved real-world backend API usability

---

### ✅ Day 7 – Week 1 Review & Code Polish

* Full API retesting using Postman
* Code cleanup and formatting
* Verified service-layer logic and edge cases
* Updated project documentation (README)
* Week 1 backend foundation completed successfully

---

### ✅ Day 8 – Spring Security Basics

* Introduced Spring Security to the project
* Understood default security behavior (401 / 403)
* Configured custom security rules
* Disabled session-based authentication
* Prepared project for JWT integration

---

### ✅ Day 9 – JWT Authentication Implementation

* Designed JWT authentication flow
* Implemented login API with token generation
* Created `JwtUtil` for token creation & validation
* Implemented `JwtAuthFilter`
* Integrated custom `UserDetailsService`
* Tested login and token generation using Postman

---

### ✅ Day 10 – JWT Stabilization & Protected APIs

* Stabilized JWT authentication flow
* Implemented stateless security configuration
* Public vs protected endpoints separation
* Secured APIs using Authorization header
* Handled expired and invalid tokens properly
* Ensured protected APIs are accessible only with valid JWT
* Full end-to-end API testing using Postman

---

### ✅ Day 11 – Role-Based Access Control (RBAC)

* Added **USER** and **ADMIN** roles
* Stored roles at database level
* Implemented role-based authorities using `ROLE_` prefix
* Secured admin-only endpoints (`/admin/**`)
* Configured access rules using Spring Security
* Debugged real-world **403 Forbidden** issues
* Ensured correct role → authority → access mapping
* Verified admin & user access using JWT + Postman
* Understood production-level authorization flow

---

### ✅ Day 12 – API Response Standardization

* Designed a global `ApiResponse<T>` structure
* Unified success and failure responses
* Standardized response format across all APIs
* Made backend responses frontend-friendly
* Removed inconsistent and default error outputs
* Improved API predictability and maintainability

---

### ✅ Day 13 – Security Error Handling (Production-Level)

* Implemented custom **AuthenticationEntryPoint** (401 handling)
* Implemented custom **AccessDeniedHandler** (403 handling)
* Replaced default Spring Security error responses
* Returned clean, consistent JSON error responses
* Integrated security errors with `ApiResponse` format
* Achieved fully professional, production-grade API behavior

---

## 📘 API Endpoints

### Authentication

* **POST** `/auth/login` – Login & generate JWT token

### Users

* **POST** `/users` – Create user (public)
* **GET** `/users` – Get all users (JWT required)
* **GET** `/users/{id}` – Get user by ID (JWT required)
* **GET** `/users/search?name=` – Search users by name
* **GET** `/users/email/{email}` – Get user by email
* **PUT** `/users/{id}` – Update user (JWT required)
* **DELETE** `/users/{id}` – Delete user (JWT required)

### Admin

* **GET** `/admin/dashboard` – Admin-only access (ADMIN role required)

---

## 📌 Current Status

**Day 13 completed successfully** ✅

✔ Full CRUD APIs implemented
✔ Pagination, sorting & search added
✔ Spring Security integrated
✔ JWT authentication working end-to-end
✔ Role-based access control implemented
✔ Admin & user authorization verified
✔ Custom 401 / 403 security handling
✔ Standardized API responses across backend
✔ Stateless backend architecture followed
✔ All APIs tested with Postman
✔ Real-world backend security & error-handling workflow understood

---

## 🚀 Next Phase (Week 3 Preview)

* API versioning
* Logging & monitoring basics
* Performance considerations
* Backend refactoring & best practices
* Interview-level backend discussions

---

> Learning by building.
> Debugging by doing.
> Backend engineering — **in public** 🚀🔥

---
