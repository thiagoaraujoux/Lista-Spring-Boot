package br.unitins.topicos.Lista.controller;

import br.unitins.topicos.Lista.model.Task;
import br.unitins.topicos.Lista.service.TaskService;

import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/tasks")
public class TaskController {

    private final TaskService service;

    public TaskController(TaskService service) {
        this.service = service;
    }

    // Exibe todas as tarefas
    @GetMapping
    public String listTasks(Model model) {
        model.addAttribute("tasks", service.findAll());
        return "task";
    }

    // Adiciona uma nova tarefa
    @PostMapping("/add")
    public String addTask(@ModelAttribute Task task) {
        service.saveTask(task);
        return "redirect:/tasks";
    }

    // Método de exclusão corrigido
    @PostMapping("/delete/{id}")
    public String deleteTask(@PathVariable("id") Long id) { // <- Adicione o nome explicitamente
        service.deleteTask(id);
        return "redirect:/tasks";
    }

    // Método de edição também precisa da correção
    @GetMapping("/edit/{id}")
    public String editTask(@PathVariable("id") Long id, Model model) { // <- Corrigido aqui também
        Optional<Task> task = service.findById(id);
        if (task.isPresent()) {
            model.addAttribute("task", task.get());
            return "edit-task";
        } else {
            return "redirect:/tasks";
        }
    }
    @PostMapping("/edit")
    public String updateTask(@ModelAttribute Task task) {
        service.updateTask(task.getId(), task);
        return "redirect:/tasks";
    }

}
