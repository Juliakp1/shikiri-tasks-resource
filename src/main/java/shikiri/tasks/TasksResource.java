package shikiri.tasks;

import java.util.Map;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
public class TasksResource implements TasksController {

    @Autowired
    private TasksService tasksService;

    @GetMapping("/tasks/info")
    public ResponseEntity<Map<String, String>> info() {
        return new ResponseEntity<Map<String, String>>(
            Map.ofEntries(
                Map.entry("microservice.name", TasksApplication.class.getSimpleName()),
                Map.entry("os.arch", System.getProperty("os.arch")),
                Map.entry("os.name", System.getProperty("os.name")),
                Map.entry("os.version", System.getProperty("os.version")),
                Map.entry("file.separator", System.getProperty("file.separator")),
                Map.entry("java.class.path", System.getProperty("java.class.path")),
                Map.entry("java.home", System.getProperty("java.home")),
                Map.entry("java.vendor", System.getProperty("java.vendor")),
                Map.entry("java.vendor.url", System.getProperty("java.vendor.url")),
                Map.entry("java.version", System.getProperty("java.version")),
                Map.entry("line.separator", System.getProperty("line.separator")),
                Map.entry("path.separator", System.getProperty("path.separator")),
                Map.entry("user.dir", System.getProperty("user.dir")),
                Map.entry("user.home", System.getProperty("user.home")),
                Map.entry("user.name", System.getProperty("user.name")),
                Map.entry("jar", new java.io.File(
                    TasksApplication.class.getProtectionDomain()
                        .getCodeSource()
                        .getLocation()
                        .getPath()
                    ).toString())
            ), HttpStatus.OK
        );
    }

    public ResponseEntity<TasksOut> create(TasksIn in) {
        Tasks tasks = TasksParser.to(in);
        tasks = tasksService.create(tasks);
        return ResponseEntity.created(
            ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(tasks.id())
                .toUri())
            .body(TasksParser.to(tasks));
    }

    public ResponseEntity<TasksOut> update(TasksIn in) {
        Tasks tasks = TasksParser.to(in);
        tasks = tasksService.update(tasks);
        return ResponseEntity.ok(TasksParser.to(tasks));
    }

    @Override
    public ResponseEntity<TasksOut> getById(String id) {
        Tasks tasks = tasksService.read(id);
        return ResponseEntity.ok(TasksParser.to(tasks));
    }

    @Override
    public ResponseEntity<List<TasksOut>> findByNameContaining(String name) {
        java.util.List<Tasks> tasks = tasksService.findByNameContaining(name);
        return ResponseEntity.ok(tasks.stream().map(TasksParser::to).collect(java.util.stream.Collectors.toList()));
    }

    @Override
    public ResponseEntity<List<TasksOut>> findByBoardId(String boardId) {
        java.util.List<Tasks> tasks = tasksService.findByBoardId(boardId);
        return ResponseEntity.ok(tasks.stream().map(TasksParser::to).collect(java.util.stream.Collectors.toList()));
    }

    @Override
    public ResponseEntity<List<TasksOut>> findByToolId(String toolId) {
        java.util.List<Tasks> tasks = tasksService.findByToolId(toolId);
        return ResponseEntity.ok(tasks.stream().map(TasksParser::to).collect(java.util.stream.Collectors.toList()));
    }

    @Override
    public ResponseEntity<Void> delete(String id) {
        tasksService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
