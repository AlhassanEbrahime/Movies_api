package org.project.movieapi.Controllers;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.project.movieapi.DTOs.Requests.LoginRequest;
import org.project.movieapi.DTOs.Requests.RegisterRequest;
import org.project.movieapi.DTOs.Responses.AuthResponse;
import org.project.movieapi.Services.AuthService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/auth")
public class AuthController {

    private final AuthService authService;

    @PostMapping("login")
    public AuthResponse authenticate(@Valid @RequestBody LoginRequest loginRequest) {
        return authService.authenticate(loginRequest);
    }

    @PostMapping("register")
    public AuthResponse register(@Valid @RequestBody RegisterRequest registerRequest) {
        return authService.register(registerRequest);
    }
}
