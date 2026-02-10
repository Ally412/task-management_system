package taskmanagement.taskhandling;

public record AddingTaskResponse(Long id, String title, String description, String status, String author) {
}
