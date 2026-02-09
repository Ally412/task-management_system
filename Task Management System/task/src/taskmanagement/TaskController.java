package taskmanagement;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TaskController {
    @GetMapping("/api/task")
    public ResponseEntity<Void> getAllTasks() {
        //TODO: remove stab
        return ResponseEntity.ok()
                .build();
    }
}
