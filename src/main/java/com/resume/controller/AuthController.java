package com.resume.controller;

import com.resume.dto.RegisterRequest;
import com.resume.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/auth")
public class AuthController {
    
    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody RegisterRequest request) {
        String response = userService.registerUser(
            request.getEmail(),
            request.getPassword(),
            request.getName()
        );
        return ResponseEntity.ok(response);
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody Map<String, String> request) {
        String response = userService.loginUser(request.get("email"), request.get("password"));
        return ResponseEntity.ok(response);
    }
}