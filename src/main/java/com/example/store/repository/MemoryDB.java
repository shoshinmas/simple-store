package com.example.store.repository;


import com.example.store.model.*;
import java.util.*;


public class MemoryDB {
    public static List<Product> products = new ArrayList<>();
    public static List<User> users = new ArrayList<>();
    public static List<Transaction> transactions = new ArrayList<>();


    static {
        Product p1 = new Product(); p1.name = "Sample Product 1";
        Product p2 = new Product(); p2.name = "Sample Product 2";
        Product p3 = new Product(); p3.name = "Sample Product 3";
        products.addAll(List.of(p1,p2,p3));


        User admin = new User();
        admin.username = "admin";
        admin.password = "admin";
        admin.role = "ADMIN";


        users.add(admin);
    }
}