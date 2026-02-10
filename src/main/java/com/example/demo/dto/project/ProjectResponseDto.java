package com.example.demo.dto.project;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProjectResponseDto {
    private Long id;
    private String name;

    public ProjectResponseDto(Long id, String name) {
        this.id = id;
        this.name = name;
    }
}
