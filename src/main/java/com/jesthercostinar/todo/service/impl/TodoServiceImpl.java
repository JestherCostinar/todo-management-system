package com.jesthercostinar.todo.service.impl;

import com.jesthercostinar.todo.dto.TodoDto;
import com.jesthercostinar.todo.entity.Todo;
import com.jesthercostinar.todo.repository.TodoRepository;
import com.jesthercostinar.todo.service.TodoService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class TodoServiceImpl implements TodoService {

    public TodoRepository todoRepository;
    @Override
    public TodoDto createTodo(TodoDto todoDto) {
        // Convert todoDto into JPA entity to save the entity to database
        Todo todo = new Todo();
        todo.setTitle(todoDto.getTitle());
        todo.setDescription(todoDto.getDescription());
        todo.setCompleted(todoDto.isCompleted());

        // Save and store in jpa entity
        Todo savedTodo = todoRepository.save(todo);

        // Convert saved Todo Jpa entity object into TodoData object
        TodoDto savedTodoDto = new TodoDto();
        savedTodoDto.setId(savedTodo.getId());
        savedTodoDto.setTitle(savedTodo.getTitle());
        savedTodoDto.setDescription(savedTodo.getDescription());
        savedTodoDto.setCompleted(savedTodo.isCompleted());

        return savedTodoDto;
    }
}
