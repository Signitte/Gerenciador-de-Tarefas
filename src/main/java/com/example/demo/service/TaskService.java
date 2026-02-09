package com.example.demo.service;

import com.example.demo.entity.Project;
import com.example.demo.entity.task.Task;
import com.example.demo.entity.task.TaskStatus;
import com.example.demo.repository.ProjectRepository;
import com.example.demo.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {

    @Autowired
    TaskRepository taskRepository;

    @Autowired
    ProjectRepository projectRepository;

    public List<Task> listTasks(){
        return taskRepository.findAll();
    }

    public Task listTaskById(Long id){
        return taskRepository.findById(id).orElse(null);
    }

    public Task createTask(Task task, Long projectId){
        Project project = projectRepository.findById(projectId).orElse(null);

        task.setProject(project);
        task.setCondition(TaskStatus.To_Do);
        return taskRepository.save(task);
    }

    public Task editTask(Task changes, Long id){
        Task task = taskRepository.getReferenceById(id);

        task.setTitle(changes.getTitle());
        task.setDescription(changes.getDescription());

        return taskRepository.save(task);
    }

    public Task moveTask(Long id) {
        Task task = taskRepository.findById(id).orElse(null);

        if (task.getCondition() == TaskStatus.To_Do) {
            task.setCondition(TaskStatus.Doing);
        } else if (task.getCondition()== TaskStatus.Doing) {
            task.setCondition(TaskStatus.Complete);
        }

        return taskRepository.save(task);
    }

    public Task deleteTask(Long id){
        Task task = taskRepository.findById(id).orElse(null);
        taskRepository.delete(task);
        return task;
    }
}
