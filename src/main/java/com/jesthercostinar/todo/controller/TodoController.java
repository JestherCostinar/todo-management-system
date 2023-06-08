package com.jesthercostinar.todo.controller;

import com.jesthercostinar.todo.dto.TodoDto;
import com.jesthercostinar.todo.entity.Todo;
import com.jesthercostinar.todo.service.TodoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
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
    @Operation(
            summary = "Create TODO Rest API",
            description = "In this Post Rest API, the todo will save to the database"
    )
    @ApiResponse(
            responseCode = "201",
            description = "HTTP Status 201 CREATED"
    )
    @PostMapping
    public ResponseEntity<TodoDto> save(@RequestBody TodoDto todo) {
        TodoDto savedTodo = todoService.createTodo(todo);

        return new ResponseEntity<>(savedTodo, HttpStatus.CREATED);
    }

    // Retrive Todo by Id
    @Operation(
            summary = "Get Todo by ID Rest API",
            description = "In this GET Rest API, it will retrieve from the database the todo with given ID"
    )
    @ApiResponse(
            responseCode = "200",
            description = "HTTP Status 200 OK"
    )
    @GetMapping("{id}")
    public ResponseEntity<TodoDto> getTodoById(@PathVariable Long id) {
        TodoDto todo = todoService.getTodoById(id);
        return ResponseEntity.ok(todo);
    }

    // Retrieve All Todo
    @Operation(
            summary = "Get all Todo Rest API",
            description = "In this GET Rest API, it will retrieve from the database all the todo list"
    )
    @ApiResponse(
            responseCode = "200",
            description = "HTTP Status 200 OK"
    )
    @GetMapping
    public ResponseEntity<List<TodoDto>> getAllTodo() {
        List<TodoDto> todos = todoService.getTodos();
        return ResponseEntity.ok(todos);
    }

    // Build Update Todo REST API
    @Operation(
            summary = "Update Todo using PUT Rest API",
            description = "In this PUT Rest API, it will update the entire entity that's why we use Put method"
    )
    @ApiResponse(
            responseCode = "200",
            description = "HTTP Status 200 OK"
    )
    @PutMapping("{id}")
    private ResponseEntity<TodoDto> updateTodo(@RequestBody TodoDto todoDto,
                                               @PathVariable Long id) {
        TodoDto updatedTodo = todoService.updateTodo(todoDto, id);
        return ResponseEntity.ok(updatedTodo);
    }

    @Operation(
            summary = "Delete Todo REST APIA",
            description = "In this DELETE Rest API, it will delete the the record with the given ID"
    )
    @ApiResponse(
            responseCode = "200",
            description = "HTTP Status 200 OK"
    )
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteTodo(@PathVariable Long id) {
        todoService.deleteTodo(id);
        return ResponseEntity.ok("Successfully deleted!");
    }

    // Complete Todo REST API
    @Operation(
            summary = "Update Todo specific field using PATCH Rest API",
            description = "In this PATCH Rest API, it will partially update the specific field(isCompleted)  that is given in the code that's why we use PATCH method"
    )
    @ApiResponse(
            responseCode = "200",
            description = "HTTP Status 200 OK"
    )
    @PatchMapping("{id}/completed")
    public ResponseEntity<TodoDto> completedTodo(@PathVariable Long id) {
        TodoDto completedTodo = todoService.completeTodo(id);
        return ResponseEntity.ok(completedTodo);
    }

    // Incomplete Todo REST API
    @Operation(
            summary = "Update Todo specific field using PATCH Rest API",
            description = "In this PATCH Rest API, it will partially update the specific field(isCompleted) that is given in the code that's why we use PATCH method"
    )
    @ApiResponse(
            responseCode = "200",
            description = "HTTP Status 200 OK"
    )
    @PatchMapping("{id}/in-complete")
    public ResponseEntity<TodoDto> incompleteTodo(@PathVariable Long id) {
        TodoDto incompleteTodo = todoService.incompleteTodo(id);
        return ResponseEntity.ok(incompleteTodo);
    }
}
