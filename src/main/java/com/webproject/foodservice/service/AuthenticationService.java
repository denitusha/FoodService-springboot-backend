package com.webproject.foodservice.service;

import com.webproject.foodservice.dto.JwtAuthenticationResponse;
import com.webproject.foodservice.dto.RefreshTokenRequest;
import com.webproject.foodservice.dto.SignInRequest;
import com.webproject.foodservice.dto.SignUpRequest;
import com.webproject.foodservice.entity.User;

public interface AuthenticationService {

    User signup(SignUpRequest signUpRequest);
    JwtAuthenticationResponse signin(SignInRequest signInRequest);

    JwtAuthenticationResponse refreshToken(RefreshTokenRequest refreshTokenRequest);
}
