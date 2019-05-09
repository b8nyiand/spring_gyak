package hu.flowacademy.todolist.test.repository;

import hu.flowacademy.todolist.domain.TodoItem;
import hu.flowacademy.todolist.repository.TodolistRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureTestEntityManager;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.*;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class TodolistRepositoryTests {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private TodolistRepository todolistRepository;

    @Test
    public void whenFindByDescription_thenReturnTodoItem() {
        TodoItem todoItemShouldBeFound = new TodoItem("ExTest1", "TestTodoItem", false);
        entityManager.persist(todoItemShouldBeFound);
        entityManager.flush();
        TodoItem todoItemFound = todolistRepository.findByDescription(todoItemShouldBeFound.getDescription());
        assertThat(todoItemFound.getDescription()).isEqualTo(todoItemShouldBeFound.getDescription());
    }

}
