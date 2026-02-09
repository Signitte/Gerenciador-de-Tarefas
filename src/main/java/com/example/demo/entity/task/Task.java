package com.example.demo.entity.task;

import com.example.demo.entity.Project;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "task")
public class Task {

    @Setter
    @Getter
    TaskStatus condition = TaskStatus.To_Do;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Setter
    @Getter
    private Long id;

    @Setter
    @Getter
    private String title;

    @Setter
    @Getter
    private String description;

    @Setter
    @Getter
    @ManyToOne
    @JoinColumn(name = "project_id")
    @JsonBackReference
    private Project project;

}
