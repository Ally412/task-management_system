package taskmanagement;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.config.Task;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class AuthController {
    @Autowired
    private UserService userService;

    @PostMapping("/accounts")
    public ResponseEntity<Void> register(@Valid  @RequestBody RegistrationRequest request, BindingResult result) {
        //TODO: validation on existent email is needed
        if(result.hasErrors()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        userService.registerUser(request);
        return ResponseEntity.ok().build();
    }
    @GetMapping("/task")
    public ResponseEntity<Void> getAllTasks() {
        //TODO: remove stab
        return ResponseEntity.ok()
                .build();
    }

}
