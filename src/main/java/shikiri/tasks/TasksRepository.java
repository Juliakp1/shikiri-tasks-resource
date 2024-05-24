package shikiri.tasks;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TasksRepository extends CrudRepository<TasksModel, String> {

    List<TasksModel> findByBoard(String boardId);

    List<TasksModel> findAllByUserId(String userId);
}
