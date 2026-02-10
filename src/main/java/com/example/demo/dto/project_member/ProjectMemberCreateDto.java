package com.example.demo.dto.project_member;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProjectMemberCreateDto {
    private Long userId;
    private Long projectId;
}
