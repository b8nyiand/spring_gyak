package hu.flowacademy.todolist.repository;

import hu.flowacademy.todolist.domain.TodoItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TodolistRepository extends JpaRepository<TodoItem, String> {

    public void deleteById(String id);

    public List<TodoItem> findByUser_Login(String login);

    @Query("FROM TodoItem todoItem WHERE todoItem.user.login = ?1")
    public List<TodoItem> findByUserLogint(@Param("login") String login);

    public TodoItem findByDescription(String id);

}
