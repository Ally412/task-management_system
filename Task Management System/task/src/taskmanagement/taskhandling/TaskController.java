package taskmanagement.taskhandling;

import jakarta.validation.Valid;
import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
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
    public ResponseEntity<List<Task>> getAllTasks() {
        //TODO: remove stab
        return ResponseEntity.ok(taskService.getAllTasks());
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
