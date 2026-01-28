# Simple Store – Spring Boot Security Training App
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

