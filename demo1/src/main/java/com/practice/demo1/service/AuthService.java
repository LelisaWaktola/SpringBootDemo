package com.practice.demo1.service;

import com.practice.demo1.dto.ApiResponse;
import com.practice.demo1.dto.AuthResponse;
import com.practice.demo1.dto.RegisterRequest;
import com.practice.demo1.entity.User;
import com.practice.demo1.reposittory.UserRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    private final UserRepository userRepository;

    public AuthService(UserRepository userRepository){
        this.userRepository=userRepository;
    }

    public AuthResponse register(RegisterRequest request){
          if(userRepository.existsByEmail(request.getEmail())){throw new RuntimeException("user already registered");}

          User user= new User();
          user.setEmail(request.getEmail());
          user.setPassword(request.getPassword());
          user.setFirstName(request.getFirstName());
          user.setLastName(request.getLastName());

          user= userRepository.save(user);

          return AuthResponse.builder()
                  .id(user.getId())
                  .email(user.getEmail())
                  .firstName(user.getFirstName())
                  .lastName(user.getLastName())
                  .build();
    }


}











