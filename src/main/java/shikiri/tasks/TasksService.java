package shikiri.tasks;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TasksService {

    @Autowired
    private TasksRepository tasksRepository;

    public Tasks create(Tasks in) {
        return tasksRepository.save(new TasksModel(in)).to();
    }
    
}
