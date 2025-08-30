package com.example.service;

import java.util.*;

import com.example.model.Task;
import com.example.repository.TaskRepository;

public class TaskService {
    private final TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository){
        this.taskRepository = taskRepository;
    }

    // récupérer toutes les taches
    public List<Task> getAllTasks(){
        return taskRepository.findAll();
    }

    // récupérer une tache
    public Optional<Task> getTaskById(Long id){
        return taskRepository.findById(id);
    }

    // créer ou mettre à jour une tache
    public Task saveTask(Task task){
        return taskRepository.save(task);
    }

    // supprimer une tache
    public void deleteTask(Long id){
        taskRepository.deleteById(id);
    }
}
