package com.example.demo.dto.user;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserCreateDto {
    @NotBlank(message = "The username cannot be blank.")
    private String name;

    @Email(message = "Invalid email format")
    @NotBlank(message = "The email cannot be blank.")
    private String email;

    @NotBlank
    @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&.#_-])[A-Za-z\\d@$!%*?&.#_-]{8,}$",
             message = "A password must have at least 8 characters, including uppercase, lowercase, numbers, and special characters.")
    private String password;
}
