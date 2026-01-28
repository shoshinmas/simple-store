# simple-store
Cybersec training web app (store with UUID)


# Simple Store – Spring Boot Security Training App


### A07: Identification and Authentication Failures
- Simplified authentication logic
- No session/user context binding


**Exercise:**
- Implement proper authentication flow
- Track authenticated user identity correctly


---


### A09: Security Logging and Monitoring Failures
- No audit trail
- No logging of security events


**Exercise:**
- Add login / logout / admin action logging
- Introduce basic audit logs


---


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
│ ├── main/
│ │ ├── java/
│ │ │ └── com/example/store/
│ │ │ ├── config/
│ │ │ ├── controller/
│ │ │ ├── service/
│ │ │ ├── model/
│ │ │ └── repository/
│ │ └── resources/
│ │ └── templates/
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
