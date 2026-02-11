package taskmanagement.taskhandling;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface TaskRepository extends JpaRepository<Task, Long>, PagingAndSortingRepository<Task, Long> {
    List<Task> findByAuthorIgnoreCaseOrderByIdDesc(String email);
    boolean existsByAuthor(String email);
    List<Task> findAll(Sort sort);
}
