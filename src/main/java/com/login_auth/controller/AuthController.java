package com.login_auth.controller;

import com.login_auth.model.User;
import com.login_auth.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
//@CrossOrigin(origins = "http://localhost:8081")
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody User user) {
        String response = authService.registerUser(user.getUsername(), user.getPassword());
        return ResponseEntity.ok(response);
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody User user) {
        String token = authService.authenticateUser(user.getUsername(), user.getPassword());

        if (token.equals("invalid username or password")) {
            return ResponseEntity.status(401).body("Invalid username or password");  // Send HTTP 401 Unauthorized
        }

        return ResponseEntity.ok(token);
    }

}