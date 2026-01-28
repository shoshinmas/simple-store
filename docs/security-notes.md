# Security Notes – Spring Boot Store Training App

This document accompanies the **Simple Store – Spring Boot Security Training App**.

It documents the **security mindset**, **threat model**, **intentional vulnerabilities**, and the **hardening roadmap** used to evolve the application from insecure-by-design to progressively secured.

---

## 🎯 Objective

The goal of this project is to:

* Learn **application security by practice**
* Understand *why* vulnerabilities exist
* Apply **defensive coding patterns** in Spring
* Map fixes to the **OWASP Top 10**

This is not a checklist-driven exercise, but a **reasoning-first security lab**.

---

## 🧠 Threat Model (Simplified)

### Assets

* User credentials
* User sessions
* Transaction history
* Admin functionality

### Actors

* Anonymous attacker
* Authenticated user (low privilege)
* Malicious insider

### Trust Boundaries

* Browser ↔ Web Server
* User ↔ Admin role
* Public endpoints ↔ Authenticated endpoints

---

## 🚨 Intentional Vulnerabilities (Baseline)

The `main` branch is intentionally insecure.

### Authentication

* Plain-text password storage
* No password hashing
* No account lockout

### Authorization

* No ownership checks on transactions
* Users can view all transactions
* Admin logic mixed with user logic

### Session & Identity

* Logged-in user identity not properly bound
* Actions not tied to authenticated principal

### Configuration

* CSRF disabled
* Security headers not configured
* Debug-friendly defaults

---

## 🛡 OWASP Top 10 Mapping

### A01 – Broken Access Control

**Problem:**

* Any authenticated user can see all transactions

**Risk:**

* Data leakage
* Privilege escalation

**Fix Strategy:**

* Bind transactions to user ID
* Enforce access checks at service layer

---

### A02 – Cryptographic Failures

**Problem:**

* Plain-text passwords

**Risk:**

* Credential compromise

**Fix Strategy:**

* BCrypt hashing
* Never store raw passwords

---

### A03 – Injection

**Problem:**

* No validation on user input

**Risk:**

* Injection once persistence is added

**Fix Strategy:**

* Input validation
* Prepared persistence layer

---

### A05 – Security Misconfiguration

**Problem:**

* CSRF disabled
* Weak defaults

**Risk:**

* Cross-site request forgery
* Browser-based attacks

**Fix Strategy:**

* Enable CSRF
* Configure HTTP security headers

---

### A07 – Identification & Authentication Failures

**Problem:**

* Simplified login flow

**Risk:**

* Session confusion
* Authentication bypass patterns

**Fix Strategy:**

* Proper `UserDetailsService`
* Secure session handling

---

### A09 – Security Logging & Monitoring Failures

**Problem:**

* No audit logs

**Risk:**

* Attacks go undetected

**Fix Strategy:**

* Log authentication events
* Log admin actions

---

## 🧪 Attack Scenarios (Examples)

### Scenario 1: Transaction Snooping

1. User logs in
2. Views all transactions
3. Learns other users’ purchase history

**Lesson:** Authorization must consider *ownership*, not just authentication.

---

### Scenario 2: Credential Leak

1. In-memory data exposed (debug/logs)
2. Plain-text passwords revealed

**Lesson:** Hashing is mandatory even in demos.

---

## 🧱 Hardening Roadmap (Suggested Order)

1. Password hashing (BCrypt)
2. Proper user identity binding
3. Transaction ownership enforcement
4. CSRF protection
5. Role-based method security
6. Audit logging
7. Persistence with JPA + H2

Each step should be:

* One branch
* One clear security goal
* One OWASP reference

---

## 🏷 Branch & Commit Naming Convention

**Branch:**

```
secure-a02-password-hashing
```

**Commit:**

```
A02: Hash passwords using BCrypt
```

---

## 📚 Learning Outcomes

By completing this project, you should be able to:

* Identify common web security flaws
* Explain *why* they are dangerous
* Implement Spring Security correctly
* Communicate security decisions clearly

---

## ⚠️ Disclaimer

This project is intentionally vulnerable in its baseline state.

Do **NOT** deploy it to production without completing the hardening steps.

---

## 🧠 Final Note

Security is not about tools.

It is about **thinking in threats, boundaries, and abuse cases**.

This repository exists to practice that mindset.
