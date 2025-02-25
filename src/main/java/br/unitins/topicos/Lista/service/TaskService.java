package br.unitins.topicos.Lista.service;

import br.unitins.topicos.Lista.model.Task;
import br.unitins.topicos.Lista.repository.TaskRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class TaskService {

    private final TaskRepository repository;

    public TaskService(TaskRepository repository) {
        this.repository = repository;
    }

    public List<Task> findAll() {
        return repository.findAll();
    }

    public Optional<Task> findById(Long id) {
        return repository.findById(id);
    }

    public void saveTask(Task task) {
        repository.save(task);
    }

    public void updateTask(Long id, Task updatedTask) {
        Task existingTask = repository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Tarefa não encontrada com ID: " + id));

        existingTask.setTitle(updatedTask.getTitle());
        existingTask.setDescription(updatedTask.getDescription());
        repository.save(existingTask);
    }

    public void deleteTask(Long id) {
        repository.deleteById(id);
    }
}
