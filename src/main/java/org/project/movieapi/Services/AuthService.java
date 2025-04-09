package org.project.movieapi.Services;

import org.project.movieapi.DTOs.Requests.LoginRequest;
import org.project.movieapi.DTOs.Requests.RegisterRequest;
import org.project.movieapi.DTOs.Responses.AuthResponse;

public interface AuthService {
    AuthResponse register(RegisterRequest registerRequest);
    AuthResponse authenticate(LoginRequest loginRequest);
}