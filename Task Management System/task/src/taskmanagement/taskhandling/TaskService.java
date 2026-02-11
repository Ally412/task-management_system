package taskmanagement.taskhandling;

import java.util.List;

public class TaskService {
    private final TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }
    public AddingTaskResponse createTask(AddingTaskRequest request, String author) {
        Task task = new Task();
        task.setTitle(request.getTitle());
        task.setDescription(request.getDescription());
        task.setAuthor(author);
        task.setStatus("Created");
        task =  taskRepository.save(task);
        return new AddingTaskResponse(task.getId(), task.getTitle(), task.getDescription(), task.getStatus(), author);
    }
    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }
}
