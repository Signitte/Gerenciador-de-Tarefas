package com.example.demo.dto.project_member;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProjectMemberResponseDto {
    private Long id;
    private Long userId;
    private Long projectId;

    public ProjectMemberResponseDto(Long id, Long userId, Long projectId) {
        this.id = id;
        this.userId = userId;
        this.projectId = projectId;
    }
}
