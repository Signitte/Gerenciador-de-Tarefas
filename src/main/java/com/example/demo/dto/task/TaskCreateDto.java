package com.example.demo.dto.task;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TaskCreateDto {
    private String title;
    private String description;
    private String condition;
    private Long projectId;
}
