package com.webproject.foodservice.dto;


import com.webproject.foodservice.entity.Role;
import lombok.Data;

@Data
public class JwtAuthenticationResponse {

    private String token;

    private String refreshToken;

    private String username;

    private Role role;

}
