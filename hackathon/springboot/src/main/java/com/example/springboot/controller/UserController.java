package com.example.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller // ✅ Use @Controller (not @RestController)
public class UserController {

    @GetMapping("/")
    public String showHomePage() {
        return "home"; // ✅ Loads home.jsp or home.html
    }

    @GetMapping("/signin")
    public String showSignInPage() {
        return "signin"; // ✅ Loads signin.jsp or signin.html
    }
}
