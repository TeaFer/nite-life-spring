package com.nitelife.nitelife.account;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;

@Getter
public class AccountSignUpRequest {
    @NotBlank(message="Username is required")
    @Size(min=5, message="Username must be at least 5 characters long")
    private String username;

    @NotBlank(message="Password is required")
    @Size(min=8, message="Password must be at least 8 characters long")
    private String password;

    @NotBlank(message="Email is required")
    @Email(message="Invalid email provided")
    private String email;

    @NotBlank(message="Display name is required")
    @Size(min=5, message="Display name must be at least 5 characters long")
    private String displayName;

    private String fullName;
    private String gender;
}
