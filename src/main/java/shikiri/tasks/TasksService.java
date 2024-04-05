package shikiri.tasks;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.NonNull;

@Service
public class TasksService {

    @Autowired
    private TasksRepository tasksRepository;

    public Tasks create(Tasks in) {
        return tasksRepository.save(new TasksModel(in)).to();
    }
    
}
