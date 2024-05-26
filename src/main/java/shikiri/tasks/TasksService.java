package shikiri.tasks;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.CacheEvict;

@Service
public class TasksService {

    @Autowired
    private TasksRepository tasksRepository;

    @CachePut(value = "tasksCache", key = "#result.id")
    public Tasks create(Tasks in) {
        return tasksRepository.save(new TasksModel(in)).to();
    }

    @CachePut(value = "tasksCache", key = "#result.id")
    public Tasks update(Tasks in) {
        return tasksRepository.save(new TasksModel(in)).to();
    }

    @Cacheable(value = "tasksCache", key = "#id")
    public Tasks read(String id) {
        return tasksRepository.findById(id)
                            .map(TasksModel::to)
                            .orElse(null);
    }
    
    @Cacheable(value = "tasksCache", key = "#name")
    public List<Tasks> findByNameContaining(String name) {
        return tasksRepository.findByNameContaining(name).stream().map(TasksModel::to).collect(Collectors.toList());
    }

    @Cacheable(value = "tasksCache", key = "#boardId")
    public List<Tasks> findByBoardId(String boardId) {
        return tasksRepository.findByBoardId(boardId).stream().map(TasksModel::to).collect(Collectors.toList());
    }

    @Cacheable(value = "tasksCache", key = "#toolId")
    public List<Tasks> findByToolId(String toolId) {
        return tasksRepository.findByToolId(toolId).stream().map(TasksModel::to).collect(Collectors.toList());
    }

    @CacheEvict(value = "tasksCache", key = "#id")
    public void delete(String id) {
        tasksRepository.deleteById(id);
    }
}
