package hu.flowacademy.todolist.service;

import hu.flowacademy.todolist.domain.SubtaskItem;
import hu.flowacademy.todolist.domain.TodoItem;
import hu.flowacademy.todolist.exception.TodoItemNotFoundException;
import hu.flowacademy.todolist.repository.SubtaskItemRepository;
import hu.flowacademy.todolist.repository.TodolistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class SubtaskItemService {

    @Autowired
    private TodolistRepository todolistRepository;

    @Autowired
    private SubtaskItemRepository subtaskItemRepository;

    public SubtaskItem save(SubtaskItem subtaskItem) {
        Optional<TodoItem> todoItem = todolistRepository.findById(subtaskItem.getTodoItemId());
        if (todoItem.isPresent()) {
            subtaskItem.setTodoItem(todoItem.get());
            return subtaskItemRepository.save(subtaskItem);
        }
        throw new TodoItemNotFoundException(subtaskItem.getTodoItemId());
    }

    public List<SubtaskItem> getSubtasksByTodoItemId(String todoItemId) {
        return subtaskItemRepository.findByTodoItem_Id(todoItemId);
    }

}
