package com.jesthercostinar.todo.controller;

import com.jesthercostinar.todo.dto.TodoDto;
import com.jesthercostinar.todo.entity.Todo;
import com.jesthercostinar.todo.service.TodoService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/todo")
@AllArgsConstructor

public class TodoController {

    private TodoService todoService;

    // Save Todo jpa to database and Save it in todoDto to return as Dto
    @PostMapping
    public ResponseEntity<TodoDto> save(@RequestBody TodoDto todo) {
        TodoDto savedTodo = todoService.createTodo(todo);

        return new ResponseEntity<>(savedTodo, HttpStatus.CREATED);
    }

    // Retrive Todo by Id
    @GetMapping("{id}")
    public ResponseEntity<TodoDto> getTodoById(@PathVariable Long id) {
        TodoDto todo = todoService.getTodoById(id);
        return ResponseEntity.ok(todo);
    }

    // Retrieve All Todo
    @GetMapping
    public ResponseEntity<List<TodoDto>> getAllTodo() {
        List<TodoDto> todos = todoService.getTodos();
        return ResponseEntity.ok(todos);
    }
}
