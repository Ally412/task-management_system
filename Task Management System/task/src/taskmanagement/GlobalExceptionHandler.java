package taskmanagement;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(EmailAlreadyExists.class)
    public ResponseEntity<Void> handleEmailAlreadyExists(EmailAlreadyExists e) {
        log.warn("Unhandled exception occurred: ", e);
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
}
