package taskmanagement.taskhandling;

import org.springframework.data.domain.Sort;

import java.util.List;

public class TaskService {
    private final TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }
    public TaskResponse createTask(AddingTaskRequest request, String author) {
        Task task = new Task();
        task.setTitle(request.getTitle());
        task.setDescription(request.getDescription());
        task.setAuthor(author);
        task.setStatus("CREATED");
        task =  taskRepository.save(task);
        return new TaskResponse(task.getId().toString(), task.getTitle(), task.getDescription(), task.getStatus(), author);
    }
    public List<TaskResponse> getAllTasks() {
        return taskRepository.findAll(Sort.by("id").descending()).stream()
                .map(task -> new TaskResponse(task.getId().toString(),
                        task.getTitle(), task.getDescription(), task.getStatus(), task.getAuthor()))
                .toList();
    }
    public List<TaskResponse> getTasksByAuthor(String author) {
        return taskRepository.findByAuthorIgnoreCaseOrderByIdDesc(author).stream()
                .map(task -> new TaskResponse(task.getId().toString(),
                        task.getTitle(), task.getDescription(), task.getStatus(), task.getAuthor()))
                .toList();
    }
}
