package hu.flowacademy.todolist.domain;

public class TodoItem {

    private String id;
    private String description;
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
