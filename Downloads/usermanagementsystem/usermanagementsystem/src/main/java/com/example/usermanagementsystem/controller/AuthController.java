/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.usermanagementsystem.controller;

import com.example.usermanagementsystem.dto.LoginRequest;
import com.example.usermanagementsystem.dto.RegisterRequest;
import com.example.usermanagementsystem.service.UserService;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private UserService service;

    @PostMapping("/signup")
    public String signup(
            @Valid @RequestBody RegisterRequest request) {

        return service.register(request);
    }

    @PostMapping("/login")
    public String login(
            @RequestBody LoginRequest request) {

        return service.login(request);
    }
}