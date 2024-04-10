package shikiri.tasks;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TasksRepository extends CrudRepository<TasksModel, String> {

    Optional<TasksModel> findByBoard(String board);
    
}

