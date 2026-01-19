package com.target11.todo.controller;

import com.target11.todo.model.Todo;
import com.target11.todo.service.TodoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/todos")
public class TodoController {

    private final TodoService service;

    public TodoController(TodoService service) {
        this.service = service;
    }

    @GetMapping
    public List<Todo> getAll() {
        return service.findAll();
    }

    @PostMapping
    public Todo create(@RequestBody Todo todo) {
        return service.save(todo);
    }

    @GetMapping("/{id}")
    public Todo getById(@PathVariable String id) {
        return service.findById(id);
    }

    @PutMapping("/{id}")
    public Todo update(@PathVariable String id, @RequestBody Todo todo) {
        Todo existing = service.findById(id);
        if (existing != null) {
            existing.setTitle(todo.getTitle());
            existing.setDescription(todo.getDescription());
            existing.setCompleted(todo.isCompleted());
            return service.save(existing);
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id) {
        service.delete(id);
    }
}
