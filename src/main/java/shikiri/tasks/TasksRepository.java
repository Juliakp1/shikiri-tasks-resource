package shikiri.tasks;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TasksRepository extends CrudRepository<TasksModel, String> {

    List<TasksModel> findByBoardId(String boardId);

    List<TasksModel> findByToolId(String toolId);

    List<TasksModel> findByNameContaining(String name);
}
