package org.project.movieapi.Services.Impl;

import lombok.RequiredArgsConstructor;
import org.project.movieapi.DTOs.Requests.LoginRequest;
import org.project.movieapi.DTOs.Requests.RegisterRequest;
import org.project.movieapi.DTOs.Responses.AuthResponse;
import org.project.movieapi.Entites.User;
import org.project.movieapi.Services.AuthService;
import org.project.movieapi.Services.UserService;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.security.authentication.AuthenticationManager;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final UserService userService;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;


    @Override
    public AuthResponse register(RegisterRequest registerRequest) {
        boolean isEmailExists = userService.isEmailExists(registerRequest.getEmail());
        if (isEmailExists) {
            throw new IllegalArgumentException("Email already exists");
        }

        User user = User.builder()
                .name(registerRequest.getName())
                .email(registerRequest.getEmail())
                .role(registerRequest.getRole())
                .password(passwordEncoder.encode(registerRequest.getPassword()))
                .build();

        userService.saveUser(user);

        String token = jwtService.generateToken(user);
        return AuthResponse.builder()
                .token(token)
                .build();
    }

    @Override
    public AuthResponse authenticate(LoginRequest loginRequest) {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(loginRequest.getEmail() , loginRequest.getPassword())
            );
        } catch (AuthenticationException e) {
            throw new UsernameNotFoundException("Username or password is incorrect");
        }

        User user = userService.findByEmail(loginRequest.getEmail());

        String token = jwtService.generateToken(user);
        return AuthResponse.builder()
                .token(token)
                .build();
    }
}
