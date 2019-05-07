package hu.flowacademy.todolist.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "todo_item")
public class TodoItem {

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
