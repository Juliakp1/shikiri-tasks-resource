package shikiri.tasks;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

@Entity
@Table(name = "tasks")
@EqualsAndHashCode(of = "id")
@Builder @Getter @Setter @Accessors(chain = true, fluent = true)
@NoArgsConstructor @AllArgsConstructor
public class TasksModel {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id_task")
    private String id;

    @Column(name = "ts_name")
    private String name;

    @Column(name = "ts_description")
    private String description;

    @Column(name = "ts_done")
    private Boolean done;

    @Column(name = "ts_tool")
    private String tool;

    @Column(name = "id_board")
    private String board;

    public TasksModel(Tasks o) {
        this.id = o.id();
        this.name = o.name();
        this.description = o.description();
        this.done = o.done();
        this.tool = o.tool();
        this.board = o.board();
    }
    
    public Tasks to() {
        return Tasks.builder()
            .id(id)
            .name(name)
            .description(description)
            .done(done)
            .tool(tool)
            .board(board)
            .build();
    }
    
}
