package com.example.store.model;


import java.util.UUID;


public class Transaction {
    public UUID id = UUID.randomUUID();
    public String username;
    public String productName;
}