package taskmanagement.taskhandling;

import jakarta.validation.Valid;
import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/tasks")
public class TaskController {
    private final TaskService taskService;
    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }
    @GetMapping
    public ResponseEntity<Void> getAllTasks() {
        //TODO: remove stab
        return ResponseEntity.ok()
                .build();
    }
    @PostMapping
    public ResponseEntity<AddingTaskResponse> createTask(
            @Valid @RequestBody AddingTaskRequest req,
            BindingResult bindingResult,
            @AuthenticationPrincipal
            (expression = "#this instanceof T(org.springframework.security.core.userdetails.UserDetails) ? #this : null")
            UserDetails userDetails) {
        if (bindingResult.hasErrors()) {
            return ResponseEntity.badRequest().build();
        }
        String userEmail = userDetails != null ? userDetails.getUsername() : null;
        AddingTaskResponse response = taskService.createTask(req, userEmail);
        return  new ResponseEntity<>(response, HttpStatus.CREATED);
    }
}
