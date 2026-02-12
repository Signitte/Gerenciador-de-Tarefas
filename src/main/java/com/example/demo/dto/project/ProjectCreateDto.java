package com.example.demo.dto.project;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProjectCreateDto {
    @NotBlank(message = "This field is need to filled in.")
    private String name;
}
