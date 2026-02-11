package taskmanagement;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/actuator/shutdown")
public class TaskManagementController {
    @PostMapping
    public ResponseEntity<?> shutdown() {
        return ResponseEntity.ok().build();
    }
}
