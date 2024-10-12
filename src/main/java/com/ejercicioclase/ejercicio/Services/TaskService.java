package com.ejercicioclase.ejercicio.Services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.ejercicioclase.ejercicio.Model.Task;

@Service
public class TaskService {
    private List<Task> tasks = new ArrayList<>();

    public List<Task> getAllTasks() {
        return tasks;
    }

    public Task createTask(Task task) {
        tasks.add(task);
        return task;
    }

    public void deleteTask(String taskName) {
        tasks.removeIf(task -> task.getTask().equals(taskName));
    }
}
