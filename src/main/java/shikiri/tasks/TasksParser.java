package shikiri.tasks;

public class TasksParser {

    public static Tasks to(TasksIn in) {
        return Tasks.builder()
            .name(in.name())
            .description(in.description())
            .done(in.done())
            .toolId(in.toolId())
            .boardId(in.boardId())
            .build();
    }

    public static TasksOut to(Tasks tasks) {
        return TasksOut.builder()
            .id(tasks.id())
            .name(tasks.name())
            .description(tasks.description())
            .done(tasks.done())
            .toolId(tasks.toolId())
            .boardId(tasks.boardId())
            .build();
    }
    
}
