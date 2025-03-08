package com.resume.service;

import com.resume.model.User;
import com.resume.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;


@Service
public class UserService {
    
    @Autowired
    private UserRepository userRepository;

    public String registerUser(String email, String password, String name) {
        if (userRepository.findByEmail(email).isPresent()) {
            return "User already exists!";
        }

        User user = new User(null, email, password, name);
        userRepository.save(user);
        return "User registered successfully!";
    }

    public String loginUser(String email, String password) {
        Optional<User> user = userRepository.findByEmail(email);

        if (user.isPresent() && user.get().getPassword().equals(password)) {
            return "Login successful!";
        }
        
        return "Invalid email or password!";
    }
}