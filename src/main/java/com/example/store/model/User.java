package com.example.store.model;


import java.util.UUID;


public class User {
    public UUID id = UUID.randomUUID();
    public String username;
    public String password;
    public String role; // USER or ADMIN
}