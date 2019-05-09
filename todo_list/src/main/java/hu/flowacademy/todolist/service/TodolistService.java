package hu.flowacademy.todolist.service;

import hu.flowacademy.todolist.domain.TodoItem;
import hu.flowacademy.todolist.exception.TodoItemNotFoundException;
import hu.flowacademy.todolist.repository.TodolistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class TodolistService {

    @Autowired
    private TodolistRepository todolistRepository;

    public TodoItem save(TodoItem todoItem) {
        return todolistRepository.save(todoItem);
    }

    public void delete(String id) {
        try {
            todolistRepository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            throw new TodoItemNotFoundException(id);
        }
    }

    public List<TodoItem> listItems() {
        return todolistRepository.findAll();
    }

    public TodoItem getOneItem(String id) {
        if (todolistRepository.findById(id).isPresent()) {
            return todolistRepository.findById(id).get();
        }
        throw new TodoItemNotFoundException(id);
    }

    public List<TodoItem> getItemsByLogin(String login) {
        return todolistRepository.findByUserLogint(login);
    }

    public TodoItem getItemByDescription(String description) {
        return todolistRepository.findByDescription(description);
    }

}
