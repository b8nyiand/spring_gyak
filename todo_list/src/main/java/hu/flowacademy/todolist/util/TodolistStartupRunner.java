package hu.flowacademy.todolist.util;

import hu.flowacademy.todolist.domain.TodoItem;
import hu.flowacademy.todolist.domain.User;
import hu.flowacademy.todolist.repository.TodolistRepository;
import hu.flowacademy.todolist.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class TodolistStartupRunner implements CommandLineRunner {

    @Autowired
    private TodolistRepository todolistRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public void run(String... args) throws Exception {

        TodoItem todoItem1 = new TodoItem("EX1", "Find out who killed Laura Palmer", false);
        TodoItem todoItem2 = new TodoItem("EX2", "Drink a DAMN fine cup of coffee", true);
        TodoItem todoItem3 = new TodoItem("EX3", "Have a meeting with Dale", false);
        TodoItem todoItem4 = new TodoItem("EX4", "Ask Dianne to check my savings", true);

        User user1 = new User("dalecooper", "Dale Cooper", "coffee");
        User user2 = new User("gordoncole", "Gordon Cole", "cherrypie");

        todolistRepository.save(todoItem1);
        todolistRepository.save(todoItem2);
        todolistRepository.save(todoItem3);
        todolistRepository.save(todoItem4);

        userRepository.save(user1);
        userRepository.save(user2);

    }

}
