package hu.flowacademy.todolist.test.service;

import hu.flowacademy.todolist.domain.TodoItem;
import hu.flowacademy.todolist.repository.TodolistRepository;
import hu.flowacademy.todolist.service.TodolistService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.*;

@RunWith(SpringRunner.class)
public class TodolistServiceTests {

    @TestConfiguration
    static class TodolistServiceTestContextConfiguration {

        @Bean
        public TodolistService employeeService() {
            return new TodolistService();
        }
    }

    @Autowired
    private TodolistService todolistService;

    @MockBean
    private TodolistRepository todolistRepository;

    @Before
    public void setup() {
        TodoItem todoItemShouldBeFound = new TodoItem("ExTest1", "TestTodoItem", false);
        Mockito.when(todolistRepository.findByDescription(todoItemShouldBeFound.getDescription())).thenReturn(todoItemShouldBeFound);
    }

    @Test
    public void whenValidDescription_thenTodoItemShouldBeFound() {
        String description = "TestTodoItem";
        TodoItem found = todolistService.getItemByDescription(description);
        assertThat(found.getDescription())
                .isEqualTo(description);
    }

}
