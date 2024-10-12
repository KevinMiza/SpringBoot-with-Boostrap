package com.ejercicioclase.ejercicio.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ejercicioclase.ejercicio.Model.Task;
import com.ejercicioclase.ejercicio.Services.TaskService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequestMapping("/tasks")
public class TaskWebController {
    @Autowired
    private TaskService taskService;

    @GetMapping
    public String showTaskList(Model model) {
        model.addAttribute("tasks", taskService.getAllTasks());
        model.addAttribute("task", new Task("", ""));
        return "index";
    }

    @PostMapping
    public String addTask(@ModelAttribute Task task) {

        taskService.createTask(task);
        return "redirect:/tasks";
    }

    @PostMapping("/delete")
    public String deleteTask(@RequestParam String task) {
        System.out.println("Deleting task: " + task); // Logging
        taskService.deleteTask(task);
        return "redirect:/tasks";
    }

}
