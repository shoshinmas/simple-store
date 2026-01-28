package com.example.store.controller;
import com.example.store.model.*;
import com.example.store.repository.MemoryDB;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
public class StoreController {


    @GetMapping("/")
    public String home() { return "redirect:/store"; }


    @GetMapping("/store")
    public String store(Model model) {
        model.addAttribute("products", MemoryDB.products);
        model.addAttribute("transactions", MemoryDB.transactions);
        return "store";
    }


    @PostMapping("/buy/{name}")
    public String buy(@PathVariable String name) {
        Transaction t = new Transaction();
        t.productName = name;
        t.username = "loggedUser";
        MemoryDB.transactions.add(t);
        return "redirect:/store";
    }
}


@Controller
class AuthController {
    @GetMapping("/login")
    public String login() { return "login"; }


    @GetMapping("/register")
    public String register() { return "register"; }


    @PostMapping("/register")
    public String registerUser(@RequestParam String username,@RequestParam String password) {
        User u = new User();
        u.username = username;
        u.password = password;
        u.role = "USER";
        MemoryDB.users.add(u);
        return "redirect:/login";
    }
}


@Controller
@RequestMapping("/admin")
class AdminController {
    @GetMapping
    public String admin(Model model) {
        model.addAttribute("products", MemoryDB.products);
        model.addAttribute("users", MemoryDB.users);
        model.addAttribute("transactions", MemoryDB.transactions);
        return "admin";
    }


    @PostMapping("/addProduct")
    public String add(@RequestParam String name) {
        Product p = new Product(); p.name = name;
        MemoryDB.products.add(p);
        return "redirect:/admin";
    }
}