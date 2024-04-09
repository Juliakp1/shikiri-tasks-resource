package shikiri.tasks;

public class TasksParser {

    public static Tasks to(TasksIn in) {
        return Tasks.builder()
            .name(in.name())
            .user(in.user())
            .description(in.description())
            .tool(in.tool())
            .board(in.board())
            .done(in.done())
            .build();
    }

    public static TasksOut to(Tasks account) {
        return TasksOut.builder()
            .id(account.id())
            .user(account.user())
            .name(account.name())
            .build();
    }
    
}
