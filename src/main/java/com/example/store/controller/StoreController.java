package com.example.store.controller;
import com.example.store.model.*;
import com.example.store.repository.MemoryDB;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;



@Controller
public class StoreController {


    @GetMapping("/")
    public String home() { return "redirect:/store"; }


    @GetMapping("/store")
    public String store(Model model) {

        Authentication auth = SecurityContextHolder
                .getContext()
                .getAuthentication();

        boolean isAdmin = auth.getAuthorities().stream()
                .anyMatch(a -> a.getAuthority().equals("ROLE_ADMIN"));

        model.addAttribute("products", MemoryDB.products);

        if (isAdmin) {
            model.addAttribute("transactions", MemoryDB.transactions);
        } else {
            model.addAttribute(
                    "transactions",
                    MemoryDB.transactions.stream()
                            .filter(t -> t.username.equals(auth.getName()))
                            .toList()
            );
        }

        return "store";
    }



    @PostMapping("/buy/{name}")
    public String buy(@PathVariable String name) {

        Authentication auth = SecurityContextHolder
                .getContext()
                .getAuthentication();

        Transaction t = new Transaction();
        t.productName = name;
        t.username = auth.getName();

        MemoryDB.transactions.add(t);
        return "redirect:/store";
    }

}


@Controller
class AuthController {
    private final PasswordEncoder passwordEncoder;

    public AuthController(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    @GetMapping("/login")
    public String login() { return "login"; }


    @GetMapping("/register")
    public String register() { return "register"; }


    @PostMapping("/register")
    public String registerUser(@RequestParam String username,@RequestParam String password) {
        User u = new User();
        u.username = username;
        u.password = passwordEncoder.encode(password);
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