package taskmanagement.taskhandling;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddingTaskRequest {
    @NotBlank
    private String title;
    @NotBlank
    private String description;
}
