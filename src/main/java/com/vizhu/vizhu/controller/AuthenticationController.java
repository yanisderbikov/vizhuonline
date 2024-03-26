package com.vizhu.vizhu.controller;

import com.vizhu.vizhu.dto.JwtAuthenticationResponse;
import com.vizhu.vizhu.dto.SignInRequest;
import com.vizhu.vizhu.dto.SignUpRequest;
import com.vizhu.vizhu.service.AuthenticationService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;


@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class AuthenticationController {

    private final AuthenticationService authenticationService;

    @PostMapping("/signup")
    public JwtAuthenticationResponse signup(@Valid @RequestBody SignUpRequest request) {
        return authenticationService.signup(request);
    }

    @PostMapping("/signin")
    public JwtAuthenticationResponse signin(@Valid @RequestBody SignInRequest request) {
        return authenticationService.signin(request);
    }
}