package com.example.demo.dto.auth;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginDto {
    @NotBlank(message = "This field is required")
    private String email;

    @NotBlank(message = "This field is required")
    private String password;
}
