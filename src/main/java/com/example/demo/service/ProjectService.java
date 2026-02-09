package com.example.demo.service;

import com.example.demo.entity.Project;
import com.example.demo.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectService {

    @Autowired
    ProjectRepository projectRepository;

    public List<Project> getAllProjects(){return projectRepository.findAll();}

    public Project findProjectById(Long id){
        return projectRepository.findById(id).orElse(null);
    }

    public Project createProject(Project project){
        return projectRepository.save(project);
    }

    public Project editProject(Project changes, Long id){
        Project project = projectRepository.findById(id).orElse(null);

        project.setName(changes.getName());

        return projectRepository.save(project);
    }

    public Project deleteProject(Long id){
        Project project = projectRepository.findById(id).orElse(null);
        projectRepository.delete(project);
        return project;

    }
}
