package hu.flowacademy.todolist.exception;

public class TodoItemNotFoundException extends RuntimeException{

    public TodoItemNotFoundException(String id) {
        super("Could not find todo item " + id);
    }

}
