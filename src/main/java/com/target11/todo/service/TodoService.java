package com.target11.todo.service;

import com.target11.todo.model.Todo;
import com.target11.todo.repository.TodoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoService {

    private final TodoRepository repository;

    public TodoService(TodoRepository repository) {
        this.repository = repository;
    }

    public List<Todo> findAll() {
        return repository.findAll();
    }

    public Todo save(Todo todo) {
        return repository.save(todo);
    }

    public Todo findById(String id) {
        return repository.findById(id).orElse(null);
    }

    public void delete(String id) {
        repository.deleteById(id);
    }
}
