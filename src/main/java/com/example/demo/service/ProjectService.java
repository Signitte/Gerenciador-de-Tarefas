package com.example.demo.service;

import com.example.demo.dto.project.ProjectCreateDto;
import com.example.demo.dto.project.ProjectResponseDto;
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

    public ProjectResponseDto createProject(ProjectCreateDto dto){
        Project project = new Project();

        project.setName(dto.getName());

        project = projectRepository.save(project);

        return new ProjectResponseDto(
                project.getId(),
                project.getName()
        );
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
