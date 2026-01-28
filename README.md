# Simple Store – Spring Boot Security Training App


This project is a **deliberately simple web application** built for **training and experimentation with web application security** in a Java / Spring ecosystem.


The application intentionally uses **minimal, insecure-by-design patterns** so they can be identified, discussed, and improved step by step.


---


## 🎯 Purpose


This app is **NOT production-ready**.


Its goals are:
- Learn **Spring Boot + Thymeleaf** basics
- Practice **authentication & authorization** concepts
- Identify **common security flaws**
- Incrementally secure a web application
- Serve as a **training / interview / workshop project**


---


## 🧱 Tech Stack


- Java 17
- Spring Boot
- Spring Security (basic form login)
- Thymeleaf
- Maven
- In-memory data storage (no database)


---


## 🚀 Features


### Public
- Storefront with 3 sample products
- Product images using 100x100 placeholders
- User registration
- Login form


### User (after login)
- View products
- Perform "buy" actions
- View own transactions
- Each transaction has a **UUID**


### Admin
- Admin login (`admin / admin`)
- View all products
- Add new products
- View all users
- View all transactions


---


## ⚠️ Intentional Security Weaknesses
The following issues are **intentional** and meant for learning purposes:
## 🧠 Portfolio Usage Strategy


This repository is intentionally suitable as a **portfolio project**.


Recommended approach:
- Keep `main` branch intentionally insecure (baseline)
- Create branches such as:
  - `secure-step-1-password-hashing`
  - `secure-step-2-authentication`
  - `secure-step-3-access-control`
- Reference OWASP IDs in commit messages


Example commit message:
```
A02: Add BCrypt password hashing
```


---


## 📁 Suggested Repository Structure (Final State)


```
store-security-training/
├── README.md
├── pom.xml
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/example/store/
│   │   │       ├── config/
│   │   │       ├── controller/
│   │   │       ├── service/
│   │   │       ├── model/
│   │   │       └── repository/
│   │   └── resources/
│   │       └── templates/
└── docs/
    └── security-notes.md
```


---


## 📚 Disclaimer


This project is for **educational purposes only**.


Do **NOT** deploy this application to production without implementing proper security measures.


---


## 📌 License


MIT – use freely for learning, demos, and training.
