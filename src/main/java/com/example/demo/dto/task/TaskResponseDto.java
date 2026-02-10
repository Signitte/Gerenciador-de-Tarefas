package com.example.demo.dto.task;

import com.example.demo.entity.task.TaskStatus;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TaskResponseDto {
    private Long id;
    private String title;
    private String description;
    private String condition;

    public TaskResponseDto(Long id, String title, String description, TaskStatus condition, Long projectId) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.condition = String.valueOf(condition);
    }
}
