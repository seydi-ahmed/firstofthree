package com.example.controller;

import com.example.model.Task;
import com.example.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController                   // Indique que c'est un contrôleur REST
@RequestMapping("/tasks")         // Toutes les routes commencent par /tasks
public class TaskController {

    @Autowired
    private TaskService taskService;

    // Récupérer toutes les tâches
    @GetMapping
    public List<Task> getAllTasks() {
        return taskService.getAllTasks();
    }

    // récupérer une tache
    @GetMapping("/{id}")
    public Task getTaskById(@PathVariable Long id){
        return taskService.getTaskById(id).orElse(null);
    }

    // créer une nouvelle tache
    @PostMapping
    public Task createTask(@RequestBody Task task){
        return taskService.saveTask(task);
    }

    // mettre à jour
    public Task updTask(@PathVariable Long id, @RequestBody Task updatedTask){
        Task task = taskService.getTaskById(id).orElse(null);
        if (task != null){
            task.setName(updatedTask.getName());
            task.setDescription(updatedTask.getDescription());
            return updatedTask;
        }
        return null;
    }

    // supprimer une tache
    @PutMapping("/{id}")
    public void deleteTask(@PathVariable Long id){
        taskService.deleteTask(id);
    }
}