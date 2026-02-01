# A01 – Access Control Fix: Enforcing Transaction Ownership

## OWASP Category

**A01: Broken Access Control**

---

## Problem Recap

In the baseline application, all authenticated users can view all transactions.

This violates the principle of **least privilege** and allows horizontal privilege escalation.

---

## Fix Overview

The fix enforces **transaction ownership** by:

* Binding each transaction to the authenticated user
* Filtering transactions by owner before display
* Ensuring users can only access their own data

---

## Implementation Strategy

1. Use `Authentication.getName()` to identify the current user
2. Store the username as the transaction owner
3. Filter transaction visibility in the controller/service layer

---

## Why This Works

* Ownership is enforced consistently
* Authorization logic is explicit
* Authentication identity is trusted from Spring Security

This prevents horizontal access control attacks.

---

## Trade-offs

* Slightly more complex business logic
* Requires careful propagation of user identity

These trade-offs are necessary for security.

---

## Security Principle Reinforced

> **Authentication proves who you are. Authorization defines what you can do.**

This patch ensures the application respects that boundary.

---

## Verification Steps

1. Log in as User A
2. Create a transaction
3. Log in as User B
4. Verify User A's transaction is not visible

---

## Learning Outcome

* Understand horizontal privilege escalation
* Apply object-level access control
* Design secure data exposure paths

---

## Status

✔ Broken access control mitigated
