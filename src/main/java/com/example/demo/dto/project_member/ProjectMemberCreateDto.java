package com.example.demo.dto.project_member;

import jakarta.validation.constraints.Positive;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProjectMemberCreateDto {
    @Positive
    private Long userId;

    @Positive
    private Long projectId;
}
