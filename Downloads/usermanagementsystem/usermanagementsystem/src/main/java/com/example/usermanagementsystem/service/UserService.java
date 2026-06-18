package com.example.usermanagementsystem.service;

import com.example.usermanagementsystem.dto.LoginRequest;
import com.example.usermanagementsystem.dto.RegisterRequest;
import com.example.usermanagementsystem.entity.User;
import com.example.usermanagementsystem.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    @Autowired
    private PasswordEncoder encoder;

    public String register(RegisterRequest request) {

        if (repository.findByEmail(request.getEmail()).isPresent()) {
            return "Email already exists";
        }

        User user = new User();

        user.setName(request.getName());
        user.setEmail(request.getEmail());
        user.setPassword(
                encoder.encode(request.getPassword()));

        repository.save(user);

        return "Registration Successful";
    }

    public String login(LoginRequest request) {

        User user = repository.findByEmail(
                request.getEmail())
                .orElse(null);

        if (user == null) {
            return "User Not Found";
        }

        if (encoder.matches(
                request.getPassword(),
                user.getPassword())) {

            return "Login Successful";
        }

        return "Invalid Password";
    }

    public User getProfile(String email) {

        return repository.findByEmail(email)
                .orElse(null);
    }
}