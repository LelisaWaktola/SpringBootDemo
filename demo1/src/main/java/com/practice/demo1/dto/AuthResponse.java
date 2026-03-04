package com.practice.demo1.dto;


import lombok.Builder;

@Builder
public class AuthResponse {

    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String accessToken;
    private String tokenType;

}
