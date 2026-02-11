package taskmanagement.taskhandling;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tasks")
public class TaskController {
    private final TaskService taskService;
    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }
    @GetMapping
    public ResponseEntity<List<Task>> getTasks(@RequestParam(required = false) String author) { //author = email
        //TODO: remove stab
        List<Task> tasks;
        if (author == null || author.isEmpty()) {
            ResponseEntity.ok(taskService.getAllTasks());
        }
        return ResponseEntity.ok(taskService.getTasksByAuthor(author));
    }
    @PostMapping
    public ResponseEntity<AddingTaskResponse> createTask(
            @Valid @RequestBody AddingTaskRequest req,
            BindingResult bindingResult,
            @AuthenticationPrincipal
            UserDetails userDetails) {
        if (bindingResult.hasErrors()) {
            return ResponseEntity.badRequest().build();
        }
        String userEmail = userDetails.getUsername();
        AddingTaskResponse response = taskService.createTask(req, userEmail);
        return  new ResponseEntity<>(response, HttpStatus.CREATED);
    }
}
