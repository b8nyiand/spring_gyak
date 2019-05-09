package hu.flowacademy.todolist.domain;

import javax.persistence.*;

@Entity
@Table(name = "subtask_item")
public class SubtaskItem {

    public SubtaskItem(Long id, String description, TodoItem todoItem, String todoItemId) {
        this.id = id;
        this.description = description;
        this.todoItem = todoItem;
        this.todoItemId = todoItemId;
    }

    public SubtaskItem() {
    }

    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "description")
    private String description;

    @ManyToOne
    @JoinColumn(name = "todo_item_id", foreignKey = @ForeignKey(name = "fk_todoitem_subtaskitem"))
    private TodoItem todoItem;

    @Transient
    private String todoItemId;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public TodoItem getTodoItem() {
        return todoItem;
    }

    public void setTodoItem(TodoItem todoItem) {
        this.todoItem = todoItem;
    }

    public String getTodoItemId() {
        return todoItemId;
    }

    public void setTodoItemId(String todoItemId) {
        this.todoItemId = todoItemId;
    }

    @Override
    public String toString() {
        return "SubtaskItem{" +
                "id=" + id +
                ", description='" + description + '\'' +
                '}';
    }
}
