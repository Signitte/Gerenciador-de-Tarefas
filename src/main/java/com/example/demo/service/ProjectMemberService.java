package com.example.demo.service;

import com.example.demo.dto.project.ProjectCreateDto;
import com.example.demo.dto.project_member.ProjectMemberCreateDto;
import com.example.demo.dto.project_member.ProjectMemberResponseDto;
import com.example.demo.entity.Project;
import com.example.demo.entity.ProjectMember;
import com.example.demo.entity.User;
import com.example.demo.repository.ProjectMemberRepository;
import com.example.demo.repository.ProjectRepository;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectMemberService {
    @Autowired
    private ProjectMemberRepository projectMemberRepository;

    @Autowired
    private ProjectRepository projectRepository;

    @Autowired
    private UserRepository userRepository;

    public ProjectMemberResponseDto addMember(ProjectMemberCreateDto dto) {

        Project project = projectRepository.findById(dto.getProjectId())
                .orElseThrow(() -> new RuntimeException("Project not found"));

        User user = userRepository.findById(dto.getUserId())
                .orElseThrow(() -> new RuntimeException("User not found"));

        ProjectMember member = new ProjectMember();
        member.setProject(project);
        member.setUser(user);

        member = projectMemberRepository.save(member);


        return new ProjectMemberResponseDto(
                member.getId(),
                member.getUser().getId(),
                member.getProject().getId()
        );
    }

    public List<ProjectMember> listMembers(Long projectId){
        return projectMemberRepository.findByProjectId(projectId);
    }

    public void removeMember(Long memberId){
        projectMemberRepository.deleteById(memberId);
    }


}
