import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/tasks")
public class TaskController {
    private final TaskService service;

    public TaskController(TaskService service) {
        this.service = service;
    }

    @GetMapping
    public CollectionModel<EntityModel<Task>> all() {
        List<EntityModel<Task>> tasks = service.findAll().stream()
            .map(task -> EntityModel.of(task,
                WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(TaskController.class).one(task.getId())).withSelfRel()))
            .collect(Collectors.toList());

        return CollectionModel.of(tasks, WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(TaskController.class).all()).withSelfRel());
    }

    @GetMapping("/{id}")
    public EntityModel<Task> one(@PathVariable Long id) {
        Task task = service.findById(id)
                .orElseThrow(() -> new RuntimeException("Task not found"));
        return EntityModel.of(task,
                WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(TaskController.class).one(id)).withSelfRel(),
                WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(TaskController.class).all()).withRel("tasks"));
    }

    @PostMapping
    public Task newTask(@RequestBody Task task) {
        return service.save(task);
    }

    @DeleteMapping("/{id}")
    public void deleteTask(@PathVariable Long id) {
        service.delete(id);
    }
}
