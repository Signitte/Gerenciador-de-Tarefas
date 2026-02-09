package com.example.demo.controller;

import com.example.demo.entity.Project;
import com.example.demo.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/project")
@RestController
public class ProjectController {

    @Autowired
    ProjectService projectService;

    @GetMapping
    public ResponseEntity<List<Project>> getAllProjects(){
        return new ResponseEntity<>(projectService.getAllProjects(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Project> getProjectById(@PathVariable Long id){
        return new ResponseEntity<>(projectService.findProjectById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> createProject(@RequestBody Project project){
        try {
            return new ResponseEntity<>(projectService.createProject(project),HttpStatus.CREATED);
        }catch (IllegalArgumentException e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Project> editProject(@PathVariable Long id, @RequestBody Project changes){
        return new ResponseEntity<>(projectService.editProject(changes,id),HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Project> deletProject(@PathVariable Long id){
        return new ResponseEntity<>(projectService.deleteProject(id),HttpStatus.OK);
    }
}
