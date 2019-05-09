package hu.flowacademy.todolist.domain;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "todo_item")
public class TodoItem {

    public TodoItem(String id, String description, Boolean done, User user) {
        this.id = id;
        this.description = description;
        this.done = done;
        this.user = user;
    }

    public TodoItem(String id, String description, Boolean done) {
        this.id = id;
        this.description = description;
        this.done = done;
    }

    public TodoItem() {
    }

    @Id
    @Column(name = "id", length = 10)
    private String id;

    @Column(name = "description", length = 300)
    private String description;

    @Column(name = "done")
    private Boolean done;

    @OneToOne
    @JoinColumn(name = "user_id", foreignKey = @ForeignKey(name = "fk_todoitem_userid"))
    private User user;

    @OneToMany(mappedBy = "todoItem")
    private List<SubtaskItem> subtaskItems;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getDone() {
        return done;
    }

    public void setDone(Boolean done) {
        this.done = done;
    }

    @Override
    public String toString() {
        return "TodoItem{" +
                "id='" + id + '\'' +
                ", description='" + description + '\'' +
                ", done=" + done +
                '}';
    }
}
