package com.example.demo.entity;

import com.example.demo.entity.task.Task;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "project")
public class Project {

    @Getter
    @Setter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Getter
    @Setter
    private String name;

    @ManyToOne
    @JoinColumn(name = "created_by")
    private User createdBy;

    public Project() {
    }

    @Getter
    @Setter
    @OneToMany(mappedBy = "project", cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<Task> tasks = new ArrayList<>();
}
