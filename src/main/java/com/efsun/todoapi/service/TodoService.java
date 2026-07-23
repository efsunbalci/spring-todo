package com.efsun.todoapi.service;

import com.efsun.todoapi.entity.Todo;
import com.efsun.todoapi.repository.TodoRepository;
import org.springframework.stereotype.Service;
import com.efsun.todoapi.dto.TodoRequest;
import com.efsun.todoapi.exception.TodoNotFoundException;

import java.util.List;

@Service
public class TodoService {

    private final TodoRepository todoRepository;

    public TodoService(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    public List<Todo> getAllTodos() {
        return todoRepository.findAll();
    }

    public Todo createTodo(TodoRequest request) {

        Todo todo = new Todo();

        todo.setTitle(request.getTitle());
        todo.setDescription(request.getDescription());
        todo.setCompleted(request.getCompleted());

        return todoRepository.save(todo);

    }
    public List<Todo> searchTodos(String todoTitle) {
        return todoRepository.findByTitleContainingIgnoreCase(todoTitle);
    }
    public Todo getTodoById(Long id) {

        return todoRepository.findById(id)
                .orElseThrow(() -> new TodoNotFoundException("Todo bulunamadı. ID: " + id));

    }
    public void deleteTodo(Long id) {
        todoRepository.deleteById(id);
    }
    public Todo updateTodo(Long id, Todo updatedTodo) {

        Todo todo = todoRepository.findById(id).orElse(null);

        if (todo == null) {
            return null;
        }

        todo.setTitle(updatedTodo.getTitle());
        todo.setDescription(updatedTodo.getDescription());
        todo.setCompleted(updatedTodo.getCompleted());

        return todoRepository.save(todo);
    }

}