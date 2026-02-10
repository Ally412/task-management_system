package taskmanagement;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import taskmanagement.authhandling.SecurityConfig;
import taskmanagement.taskhandling.TaskController;
import taskmanagement.taskhandling.TaskRepository;
import taskmanagement.taskhandling.TaskService;

@Configuration
@Import(SecurityConfig.class)
@ComponentScan
public class TaskManagementSystemConfig {
    @Bean
    public TaskController taskController(TaskService taskService) {
        return new TaskController(taskService);
    }
    @Bean
    public TaskService taskService(TaskRepository taskRepository) {
        return new TaskService(taskRepository);
    }
}
