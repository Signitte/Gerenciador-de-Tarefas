package com.example.demo.dto.task;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TaskCreateDto {
    @NotBlank(message = "This field needs to be filled in.")
    private String title;

    @Size(max = 5000, message = "The limit of characters is 5000")
    private String description;

    private String condition;

    @Positive
    private Long projectId;
}
