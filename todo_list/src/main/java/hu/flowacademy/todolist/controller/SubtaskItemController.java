package hu.flowacademy.todolist.controller;

import hu.flowacademy.todolist.domain.SubtaskItem;
import hu.flowacademy.todolist.domain.TodoItem;
import hu.flowacademy.todolist.service.SubtaskItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/subtask")
public class SubtaskItemController {

    @Autowired
    private SubtaskItemService subtaskItemService;

    @PostMapping("/add")
    public ResponseEntity<SubtaskItem> addSubtaskItem(@RequestBody SubtaskItem subtaskItem) {
        return ResponseEntity.ok(subtaskItemService.save(subtaskItem));
    }

    @PutMapping("/update")
    public ResponseEntity<SubtaskItem> updateTodoItem(@RequestBody SubtaskItem subtaskItem) {
        return ResponseEntity.ok(subtaskItemService.save(subtaskItem));
    }


    @GetMapping("/find-item-by-todo-id/{todoItemId}")
    public ResponseEntity<List<SubtaskItem>> findOneItemByTodoItem(@PathVariable String todoItemId) {
        return ResponseEntity.ok(subtaskItemService.getSubtasksByTodoItemId(todoItemId));
    }

}
