package com.jesthercostinar.todo.service.impl;

import com.jesthercostinar.todo.dto.TodoDto;
import com.jesthercostinar.todo.entity.Todo;
import com.jesthercostinar.todo.exception.ResourceNotFoundException;
import com.jesthercostinar.todo.repository.TodoRepository;
import com.jesthercostinar.todo.service.TodoService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class TodoServiceImpl implements TodoService {

    public TodoRepository todoRepository;
    private ModelMapper modelMapper;

    @Override
    public TodoDto createTodo(TodoDto todoDto) {
        // Convert todoDto into JPA entity to save the entity to database
        Todo todo = modelMapper.map(todoDto, Todo.class);
        // Save and store in jpa entity
        Todo savedTodo = todoRepository.save(todo);
        // Convert saved Todo Jpa entity object into TodoData object
        TodoDto savedTodoDto = modelMapper.map(savedTodo, TodoDto.class);

        return savedTodoDto;
    }

    @Override
    public TodoDto getTodoById(Long id) {
        Todo todo = todoRepository.findById(id).orElseThrow(() ->
            new ResourceNotFoundException("Todo not found with id:" + id)
        );
        return modelMapper.map(todo, TodoDto.class);
    }

    @Override
    public List<TodoDto> getTodos() {
        List<Todo> todos = todoRepository.findAll();

        return todos.stream().map((todo) -> modelMapper.map(todo, TodoDto.class)).collect(Collectors.toList());
    }

    @Override
    public TodoDto updateTodo(TodoDto todoDto, Long id) {
        Todo todo = todoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Todo not found with id: " + id));
        todo.setTitle(todoDto.getTitle());
        todo.setDescription(todoDto.getDescription());
        todo.setCompleted(todoDto.isCompleted());

        Todo updatedTodo = todoRepository.save(todo);

        return modelMapper.map(updatedTodo, TodoDto.class);
    }

    @Override
    public void deleteTodo(Long id) {
        Todo todo = todoRepository.findById(id)
                                  .orElseThrow(() -> new ResourceNotFoundException("Todo not found with id: " + id));
        todoRepository.deleteById(todo.getId());
    }

    @Override
    public TodoDto completeTodo(Long id) {
        Todo todo = todoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Todo not found with id: " + id));

        todo.setCompleted(Boolean.TRUE);

        Todo completedTodo = todoRepository.save(todo);

        return modelMapper.map(completedTodo, TodoDto.class);
    }

    @Override
    public TodoDto incompleteTodo(Long id) {
        Todo todo = todoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Todo not found with id: " + id));

        todo.setCompleted(Boolean.FALSE);

        Todo completedTodo = todoRepository.save(todo);

        return modelMapper.map(completedTodo, TodoDto.class);
    }
}
