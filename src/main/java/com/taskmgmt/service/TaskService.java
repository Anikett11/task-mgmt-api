package com.taskmgmt.service;

import com.taskmgmt.model.Task;
import com.taskmgmt.model.TaskStatus;
import com.taskmgmt.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class TaskService {
    @Autowired
    private TaskRepository repository;

    // Create a new task
    public Task createTask(Task task) {
        return repository.save(task);
    }

    // Get all tasks
    public List<Task> getAllTasks() {
        return repository.findAll();
    }

    // Update task status
    public Task updateTaskStatus(Long id, TaskStatus status) {
        Task task = repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Task not found"));
        task.setStatus(status);
        return repository.save(task);
    }

    // Del a task
    public void deleteTask(Long id) {
        if (!repository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Task not found");
        }
        repository.deleteById(id);
    }
}
