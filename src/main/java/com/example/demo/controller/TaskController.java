package com.example.demo.controller;

import com.example.demo.dto.task.TaskCreateDto;
import com.example.demo.entity.task.Task;
import com.example.demo.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/task")
@RestController
public class TaskController {

    @Autowired
    TaskService taskService;

    @GetMapping
    public ResponseEntity<List<Task>> listAllUsers(){
        return new ResponseEntity<>(taskService.listTasks(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Task> listser(@PathVariable Long id){
        return new ResponseEntity<>(taskService.listTaskById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> createUser(@RequestBody TaskCreateDto dto){
        try {
            return new ResponseEntity<>(taskService.createTask(dto),HttpStatus.CREATED);
        }catch (IllegalArgumentException e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }

    }

    @PutMapping("/{id}")
    public ResponseEntity<Task> editUser(@PathVariable Long id, @RequestBody Task changes){
        return new ResponseEntity<>(taskService.editTask(changes, id),HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Task> deleteUser(@PathVariable Long id){
        return new ResponseEntity<>(taskService.deleteTask(id),HttpStatus.OK);
    }
}
