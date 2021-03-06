package com.mariadb.backend.services;

import java.util.List;

import com.mariadb.backend.models.Task;
import com.mariadb.backend.repositories.TasksRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TaskService {
    
    @Autowired
    private TasksRepository repository;

    public Boolean isValid(Task task) {
        if (task != null && !task.getDescription().isEmpty()) {
            return true;
        }
        return false;
    }

    public List<Task> getAll() {
        return repository.findAll();
    }

    public void save(Task task) {
        if (task.getId() > 0) {
            repository.update(task);
        }
        else {
            repository.insert(task);
        }
    }

    public void delete(int id) {
        repository.delete(id);
    }
}