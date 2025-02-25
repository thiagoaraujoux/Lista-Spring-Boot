package br.unitins.topicos.Lista.service;

import br.unitins.topicos.Lista.model.Task;
import br.unitins.topicos.Lista.repository.TaskRepository;
import org.springframework.stereotype.Service;

import java.util.List;
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

    public Task save(Task task) {
        return repository.save(task);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
