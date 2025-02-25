import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WebController {
    private final TaskService service;

    public WebController(TaskService service) {
        this.service = service;
    }

    @GetMapping("/web/tasks")
    public String viewTasks(Model model) {
        model.addAttribute("tasks", service.findAll());
        return "tasks";
    }
}
