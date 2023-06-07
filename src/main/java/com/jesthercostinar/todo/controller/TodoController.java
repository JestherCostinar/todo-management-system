package com.jesthercostinar.todo.controller;

import com.jesthercostinar.todo.dto.TodoDto;
import com.jesthercostinar.todo.entity.Todo;
import com.jesthercostinar.todo.service.TodoService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/todo")
@AllArgsConstructor

public class TodoController {

    private TodoService todoService;
    @PostMapping
    public ResponseEntity<TodoDto> save(@RequestBody TodoDto todo) {
        TodoDto savedTodo = todoService.createTodo(todo);

        return new ResponseEntity<>(savedTodo, HttpStatus.CREATED);
    }
}
