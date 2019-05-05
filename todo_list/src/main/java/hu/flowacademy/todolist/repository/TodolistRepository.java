package hu.flowacademy.todolist.repository;

import hu.flowacademy.todolist.domain.TodoItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TodolistRepository extends JpaRepository<TodoItem, String> {

    public void deleteById(String id);

}
