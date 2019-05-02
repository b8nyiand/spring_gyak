package hu.flowacademy.todolist.repository;

import hu.flowacademy.todolist.domain.TodoItem;
import hu.flowacademy.todolist.exception.TodoItemNotFoundException;
import hu.flowacademy.todolist.util.TodolistUtils;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class TodolistRepository {

    private Map<String, TodoItem> todoList = new HashMap<>();

    public TodoItem save(TodoItem todoItem) {
        if (todoList.get(todoItem.getId()) != null) {
            todoList.remove(todoItem.getId());
            todoList.put(todoItem.getId(), todoItem);
            TodolistUtils.logList(todoList);
            return todoItem;
        }
        todoList.put(todoItem.getId(), todoItem);
        TodolistUtils.logList(todoList);
        return todoItem;
    }

    public String delete(String id) {
        if (todoList.get(id) == null) {
            throw new TodoItemNotFoundException(id);
        }
        todoList.remove(id);
        TodolistUtils.logList(todoList);
        return id;
    }

    public List<TodoItem> getItems() {
        TodolistUtils.logList(todoList);
        return new ArrayList<>(todoList.values());
    }

}
