package com.example.demo.repository;

import com.example.demo.entity.ProjectMember;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProjectMemberRepository extends JpaRepository<com.example.demo.entity.ProjectMember,Long> {
    List<ProjectMember> findByProjectId(Long projectId);
}
