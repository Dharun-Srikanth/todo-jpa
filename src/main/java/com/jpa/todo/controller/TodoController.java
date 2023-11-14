package com.jpa.todo.controller;


import com.jpa.todo.model.Todo;
import com.jpa.todo.request.TodoRequest;
import com.jpa.todo.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/todo")
public class TodoController {

    @Autowired
    private TodoService todoService;

    @GetMapping("/{userId}")
    public List<Todo> findAll(@PathVariable int userID){
        return todoService.getAllTodos(userID);
    }

    @PostMapping
    public List<Todo> addTodo(@RequestBody TodoRequest todo){
        return todoService.addTodo(todo);
    }

    @PutMapping
    public List<Todo> updateTodo(@RequestBody TodoRequest todo){
        return todoService.updateTodo(todo);
    }

    @DeleteMapping
    public List<Todo> deleteById(@PathVariable Integer id){
        return todoService.deleteTodoById(id);
    }
}
