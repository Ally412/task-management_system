package taskmanagement;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TaskManagementSystemConfig {
    @Bean
    public UserService userService() {
        return new UserService();
    }

    @Bean
    public AuthController authController() {
        return new AuthController();
    }
}
