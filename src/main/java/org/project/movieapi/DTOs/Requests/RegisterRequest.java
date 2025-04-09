package org.project.movieapi.DTOs.Requests;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import org.project.movieapi.Entites.Role;

@Data
public class RegisterRequest {
    @NotBlank(message = "Name is required")
    private String name;
    @NotBlank(message = "Password is required")
    private String password;
    @NotBlank(message = "Email is required")
    private String email;
    private Role role;
}