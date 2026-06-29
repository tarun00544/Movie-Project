package com.Tarun.service;

import com.Tarun.model.LoginRequest;
import com.Tarun.model.LoginResponse;
import com.Tarun.security.JwtUtil;
import com.Tarun.model.User;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import com.Tarun.repository.UserRepository;

@Service
public class UserService {
    @Autowired
private PasswordEncoder passwordEncoder;

@Autowired
private UserRepository userRepository;

@Autowired
private JwtUtil jwtUtil;

public User register(User user) {
     if(userRepository.findByEmail(user.getEmail()).isPresent()){
        throw new RuntimeException("Email already exists");
    }
    user.setPassword(passwordEncoder.encode(user.getPassword()));
    
    return userRepository.save(user);
}
   public LoginResponse login(LoginRequest request) {

    User user = userRepository.findByEmail(request.getEmail())
            .orElseThrow(() -> new RuntimeException("User not found"));

    if (!passwordEncoder.matches(request.getPassword(), user.getPassword())) {
        throw new RuntimeException("Invalid Password");
    }

    String token = jwtUtil.generateToken(user.getEmail());

    return new LoginResponse(token);
}
}
