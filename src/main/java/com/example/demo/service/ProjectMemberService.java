package com.example.demo.service;

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

    public ProjectMember addMember(Long projectId, Long userId) {

        Project project = projectRepository.findById(projectId)
                .orElseThrow(() -> new RuntimeException("Project not found"));

        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        ProjectMember member = new ProjectMember();

        member.setProject(project);
        member.setUser(user);

        return projectMemberRepository.save(member);
    }

    public List<ProjectMember> listMembers(Long projectId){
        return projectMemberRepository.findByProjectId(projectId);
    }

    public void removeMember(Long memberId){
        projectMemberRepository.deleteById(memberId);
    }


}
