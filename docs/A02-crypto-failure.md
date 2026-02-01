# A02 – Cryptographic Failures: Plain‑Text Password Storage

## OWASP Category

**A02: Cryptographic Failures**

---

## Vulnerability Summary

The application stores user passwords in **plain text** in memory and uses `NoOpPasswordEncoder`, meaning:

* Passwords are never hashed
* Anyone with access to memory, logs, or debugging tools can read credentials

This is an intentional baseline vulnerability.

---

## Affected Components

* `MemoryDB.users`
* `User.password`
* `NoOpPasswordEncoder`

---

## Exploitation Preconditions

* Attacker has:

  * Local access (developer / insider)
  * OR debug / log access
  * OR memory dump capability

This models **realistic internal threat scenarios**.

---

## Exploitation Steps

1. Register a new user via `/register`
2. Inspect in‑memory user list during runtime
3. Observe passwords stored in readable form

Example (conceptual):

```
User{ username='alice', password='password123', role='USER' }
```

---

## Impact

* Immediate credential compromise
* Password reuse across services
* Full account takeover
* Privilege escalation if admin credentials are leaked

---

## Root Cause Analysis

* Passwords treated as regular data
* No cryptographic boundary between input and storage
* Missing security policy enforcement

---

## Why This Matters

Even in demo applications:

* Developers copy patterns
* Weak examples propagate

Plain‑text password storage is **never acceptable**, even in memory.

---

## Learning Outcome

* Understand why hashing is mandatory
* Recognize cryptographic failures early
* Prepare for secure password handling

---

## Next Step

➡ Patch branch: `patch-a02-password-hashing`

Introduce BCrypt hashing and remove `NoOpPasswordEncoder`.
