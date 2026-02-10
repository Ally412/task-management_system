package taskmanagement.taskhandling;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TaskRepository extends JpaRepository<Task, Long> {
    Optional<Task> findByUsername(String userEmail);
    boolean existsByUsername(String userEmail);
}
