package com.taskmgmt.service;

import com.taskmgmt.model.Task;
import com.taskmgmt.model.TaskStatus;
import com.taskmgmt.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {
    @Autowired
    private TaskRepository repository;

    public Task createTask(Task task) {
        return repository.save(task);
    }

    public List<Task> getAllTasks() {
        return repository.findAll();
    }

    public Task updateTaskStatus(Long id, TaskStatus status) {
        Task task = repository.findById(id).orElseThrow(() -> new RuntimeException("Task not found"));
        task.setStatus(status);
        return repository.save(task);
    }

//    public void deleteTask(Long id) {
//        repository.deleteById(id);
//    }
public void deleteTask(Long id) {
    Task task = repository.findById(id)
            .orElseThrow(() -> new RuntimeException("Task not found"));
    repository.delete(task);
}


    // FIXED: Implementing the saveTask method
    public Task saveTask(Task task) {
        return repository.save(task);
    }
}
