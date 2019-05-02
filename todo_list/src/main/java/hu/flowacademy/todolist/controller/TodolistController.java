package hu.flowacademy.todolist.controller;

import hu.flowacademy.todolist.domain.TodoItem;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping(path = "/todolist")
public class TodolistController {

    private Map<String, TodoItem> todoList = new HashMap<>();

    @PostMapping("/add")
    public ResponseEntity<TodoItem> addTodoItem(@RequestBody TodoItem todoItem) {
        todoList.put(todoItem.getId(), todoItem);
        logList();
        return ResponseEntity.ok(todoItem);
    }

    @PutMapping("/update")
    public ResponseEntity<TodoItem> updateTodoItem(@RequestBody TodoItem todoItem) {
        TodoItem foundTodoItem = todoList.get(todoItem.getId());
        if (foundTodoItem != null) {
            todoList.remove(todoItem.getId());
            todoList.put(todoItem.getId(), todoItem);
            logList();
            return ResponseEntity.ok(todoItem);
        }
        return ResponseEntity.ok(new TodoItem());
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteTodoItem(@PathVariable String id) {
        todoList.remove(id);
        logList();
        return ResponseEntity.ok(id);
    }

    @GetMapping("/list-items")
    public ResponseEntity<List<TodoItem>> listTodoItems() {
        logList();
        List<TodoItem> todoListItems = new ArrayList<>(todoList.values());
        return ResponseEntity.ok(todoListItems);
    }

    private void logList() {
        System.out.println("----------------------------");
        for (TodoItem todoItem : todoList.values()) {
            System.out.println(todoItem.toString());
        }
        System.out.println("----------------------------");
    }



}
