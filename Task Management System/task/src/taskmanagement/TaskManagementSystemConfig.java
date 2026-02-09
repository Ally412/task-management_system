package taskmanagement;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@Import(SecurityConfig.class)
@ComponentScan
public class TaskManagementSystemConfig {
    @Bean
    public TaskController taskController() {
        return new TaskController();
    }
}
