package com.practice.demo1.controller;

import com.practice.demo1.dto.ApiResponse;
import com.practice.demo1.dto.AuthRequest;
import com.practice.demo1.dto.AuthResponse;
import com.practice.demo1.dto.RegisterRequest;
import com.practice.demo1.reposittory.UserRepository;
import com.practice.demo1.service.AuthService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {
    private final AuthService authService;
    private final UserRepository userRepository;

    public AuthController(AuthService authService, UserRepository userRepository){
              this.authService=authService;
        this.userRepository = userRepository;
    }

    @PostMapping("/register")
    public ResponseEntity<ApiResponse<AuthResponse>> register(@RequestBody RegisterRequest request){
             AuthResponse response= authService.register(request);
             return ResponseEntity.status(HttpStatus.CREATED).body(
                     ApiResponse.ok("user successfully registered ", response)
             );
    }


}











