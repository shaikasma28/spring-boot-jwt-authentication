package com.login_auth.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController  
@RequestMapping("/user") 
public class UserController {

    @GetMapping("/profile")
    public ResponseEntity<String> getUserProfile(@RequestHeader("Authorization") String token) {
        return ResponseEntity.ok("This is a protected user profile.");
    }

    @GetMapping("/dashboard")
    public ResponseEntity<String> getDashboard(@RequestHeader("Authorization") String token) {
        return ResponseEntity.ok("Welcome to your dashboard!");
    }
}
