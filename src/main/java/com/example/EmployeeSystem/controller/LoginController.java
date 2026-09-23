package com.example.EmployeeSystem.controller;

import com.example.EmployeeSystem.model.User;
import com.example.EmployeeSystem.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import jakarta.servlet.http.HttpSession;

@Controller
public class LoginController {

    @Autowired
    private UserRepository userRepo;

    @PostMapping("/login")
    public String login(@RequestParam String username,
                        @RequestParam String password,
                        HttpSession session) {
        User user = userRepo.findByUsername(username);

        // ✅ If no user found, redirect back to login
        if (user == null) {
            return "redirect:/login.html?error=true";
        }

        // ✅ If password matches, go to index.html
        if (user.getPassword() != null && user.getPassword().equals(password)) {
            session.setAttribute("user", username);
            return "redirect:/index.html";
        }

        // ✅ Otherwise, wrong password
        return "redirect:/login.html?error=true";
    }

  
    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate(); // ✅ clears the session
        return "redirect:/logout.html"; // redirect to logout page
    }
}