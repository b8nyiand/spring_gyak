package hu.flowacademy.todolist.util;

import hu.flowacademy.todolist.domain.TodoItem;

import java.util.Map;

public class TodolistUtils {

    public static void logList(Map<String, TodoItem> todoList) {
        System.out.println("----------------------------");
        for (TodoItem todoItem : todoList.values()) {
            System.out.println(todoItem.toString());
        }
        System.out.println("----------------------------");
    }

}
