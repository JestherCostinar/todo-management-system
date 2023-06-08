package com.jesthercostinar.todo.service;

import com.jesthercostinar.todo.dto.TodoDto;

import java.util.List;

public interface TodoService {
    TodoDto createTodo(TodoDto todoDto);

    TodoDto getTodoById(Long id);

    List<TodoDto> getTodos();

    TodoDto updateTodo(TodoDto todoDto, Long id);

    void deleteTodo(Long id);

    TodoDto completeTodo(Long id);
}
