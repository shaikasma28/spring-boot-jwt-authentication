package com.login_auth.service;

import com.login_auth.model.User;
import com.login_auth.repository.UserRepository;
import com.login_auth.security.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private JwtUtil jwtUtil;

    private final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    public String registerUser(String username, String password) {
        if (userRepository.findByUsername(username).isPresent()) {
            return "User already exists";
        }
        User user = new User(null, username, encoder.encode(password));
        userRepository.save(user);
        return "User registered successfully";
    }

    public String authenticateUser(String username, String password) {
        Optional<User> user = userRepository.findByUsername(username);

        if (user.isEmpty()) {
            System.out.println("User not found: " + username);
            return "invalid username or password";
        }

        if (!encoder.matches(password, user.get().getPassword())) {
            System.out.println("Invalid password for user: " + username);
            return "invalid username or password";
        }

        System.out.println("User authenticated: " + username);
        return jwtUtil.generateToken(username);
    }

    }

