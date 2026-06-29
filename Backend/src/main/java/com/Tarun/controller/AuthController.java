 package com.Tarun.controller;

import com.Tarun.model.User;
import com.Tarun.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.Tarun.model.LoginRequest;
import com.Tarun.model.LoginResponse;

@RestController
@RequestMapping("/auth")
@CrossOrigin(origins="*")
public class AuthController {

    @Autowired
    private UserService userService;

    @PostMapping("/signup")
    public User signup(@RequestBody User user) {
        return userService.register(user);
    }

    @PostMapping("/login")
public LoginResponse login(@RequestBody LoginRequest request) {
    return userService.login(request);
}
}