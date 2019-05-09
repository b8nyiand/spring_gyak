package hu.flowacademy.todolist.test.controller;

import hu.flowacademy.todolist.controller.TodolistController;
import hu.flowacademy.todolist.domain.TodoItem;
import hu.flowacademy.todolist.service.TodolistService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(TodolistController.class)
public class TodolistControllerTests {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private TodolistService todolistService;

    @Test
    public void givenTodoItems_whenTodoItems_thenReturnJsonArray() throws Exception {

        TodoItem todoItemShouldBeFound = new TodoItem("ExTest1", "TestTodoItem", false);

        List<TodoItem> allTodoItemShouldBeFound = Arrays.asList(todoItemShouldBeFound);

        given(todolistService.listItems()).willReturn(allTodoItemShouldBeFound);

        mvc.perform(get("/todolist/list-items")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].description", is(todoItemShouldBeFound.getDescription())));
    }

}
