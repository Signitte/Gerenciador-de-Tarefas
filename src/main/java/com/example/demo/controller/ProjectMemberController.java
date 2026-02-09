package com.example.demo.controller;

import com.example.demo.entity.ProjectMember;
import com.example.demo.service.ProjectMemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/project_members")
@RestController
public class ProjectMemberController {

    @Autowired
    ProjectMemberService projectMemberService;

    @GetMapping("/project/{projectId}")
    public ResponseEntity<List<ProjectMember>> getMembersByProject(@PathVariable Long projectId) {
        return new ResponseEntity<>(projectMemberService.listMembers(projectId),HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> addMember(@RequestParam Long projectId, @RequestParam Long userId) {
        try {
            return new ResponseEntity<>(projectMemberService.addMember(projectId,userId), HttpStatus.CREATED);
        }catch (IllegalArgumentException e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMember(@PathVariable Long id) {
        projectMemberService.removeMember(id);
        return ResponseEntity.noContent().build();
    }
}
