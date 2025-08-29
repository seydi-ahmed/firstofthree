package com.example.service;

import com.example.model.Task;
import com.example.repository.TaskRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskService {

    private final TaskRepository taskRepository;

    // Injection du repository via le constructeur
    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    // Récupérer toutes les tâches
    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    // Récupérer une tâche par ID
    public Optional<Task> getTaskById(Long id) {
        return taskRepository.findById(id);
    }

    // Créer ou mettre à jour une tâche
    public Task saveTask(Task task) {
        return taskRepository.save(task);
    }

    // Supprimer une tâche
    public void deleteTask(Long id) {
        taskRepository.deleteById(id);
    }
}
