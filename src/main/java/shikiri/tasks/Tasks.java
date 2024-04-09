package shikiri.tasks;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

@Builder
@Getter @Setter @Accessors(fluent = true, chain = true)
@AllArgsConstructor @NoArgsConstructor
public class Tasks {

    private String id;
    private String name;
    private String description;
    private Boolean done;
    private String user;
    private String tool;
    private String board;
    
}
