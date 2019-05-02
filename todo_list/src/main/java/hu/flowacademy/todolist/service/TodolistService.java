package hu.flowacademy.todolist.service;

import hu.flowacademy.todolist.domain.TodoItem;
import hu.flowacademy.todolist.repository.TodolistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodolistService {

    @Autowired
    private TodolistRepository todolistRepository;

    public TodoItem save(TodoItem todoItem) {
        return todolistRepository.save(todoItem);
    }

    public String delete(String id) {
        return todolistRepository.delete(id);
    }

    public List<TodoItem> listItems() {
        return todolistRepository.getItems();
    }

}
