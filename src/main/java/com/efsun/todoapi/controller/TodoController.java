package com.efsun.todoapi.controller;


import com.efsun.todoapi.entity.Todo;
import com.efsun.todoapi.service.TodoService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PutMapping;
import com.efsun.todoapi.dto.TodoRequest;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.List;

import java.util.List;

@RestController
public class TodoController {

    private final TodoService todoService;

    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    @GetMapping("/todos")
    public List<Todo> getAllTodos() {
        return todoService.getAllTodos();
    }
    @PostMapping("/todos")
    public Todo createTodo(@Valid @RequestBody TodoRequest request) {
        return todoService.createTodo(request);
    }

    @GetMapping("/todos/{id}")
    public Todo getTodoById(@PathVariable Long id) {
        return todoService.getTodoById(id);
    }
    @GetMapping("/todos/search")
    public ResponseEntity<List<Todo>> searchTodos(
            @RequestParam("q") String todoTitle) {

        return ResponseEntity.ok(
                todoService.searchTodos(todoTitle)
        );
    }

    @DeleteMapping("/todos/{id}")
    public void deleteTodo(@PathVariable Long id) {
        todoService.deleteTodo(id);
    }
    @PutMapping("/todos/{id}")
    public Todo updateTodo(@PathVariable Long id,
                           @RequestBody Todo todo) {

        return todoService.updateTodo(id, todo);
    }

}