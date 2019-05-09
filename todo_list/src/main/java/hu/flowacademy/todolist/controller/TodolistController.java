package hu.flowacademy.todolist.controller;

import hu.flowacademy.todolist.domain.TodoItem;
import hu.flowacademy.todolist.service.TodolistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping(path = "/todolist")
public class TodolistController {

    @Autowired
    private TodolistService todolistService;

    @PostMapping("/add")
    public ResponseEntity<TodoItem> addTodoItem(@RequestBody TodoItem todoItem) {
        return ResponseEntity.ok(todolistService.save(todoItem));
    }

    @PutMapping("/update")
    public ResponseEntity<TodoItem> updateTodoItem(@RequestBody TodoItem todoItem) {
        return ResponseEntity.ok(todolistService.save(todoItem));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteTodoItem(@PathVariable String id) {
        todolistService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/list-items")
    public ResponseEntity<List<TodoItem>> listTodoItems() {
        return ResponseEntity.ok(todolistService.listItems());
    }


    @GetMapping("/find-item/{id}")
    public ResponseEntity<TodoItem> findOneItem(@PathVariable String id) {
        return ResponseEntity.ok(todolistService.getOneItem(id));
    }

    @GetMapping("/find-item-by-login/{login}")
    public ResponseEntity<List<TodoItem>> findOneItemByLogin(@PathVariable String login) {
        return ResponseEntity.ok(todolistService.getItemsByLogin(login));
    }

}
