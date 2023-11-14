package com.jpa.todo.service;

import com.jpa.todo.model.AppUser;
import com.jpa.todo.model.Todo;
import com.jpa.todo.repository.TodoRepository;
import com.jpa.todo.repository.UserRepository;
import com.jpa.todo.request.TodoRequest;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TodoService {

    @Autowired
    private TodoRepository todoRepository;

    @Autowired
    private UserRepository userRepository;


    public List<Todo> getAllTodos(int userID){
        List<Todo> allTodos = todoRepository.findAll();

        return allTodos.stream()
                .filter(todo -> todo.getUser().getUserID() == userID)
                .collect(Collectors.toList());
    }

    public Optional<Todo> getTodoById(Integer id){
        return todoRepository.findById(id);
    }

    public List<Todo> addTodo(TodoRequest todo){
        Todo originalTodo = new Todo();
        originalTodo.setValue(todo.getTodo());
        AppUser user = userRepository.findById(todo.getUserId()).get();
        originalTodo.setUser(user);
        todoRepository.save(originalTodo);
        return getAllTodos(todo.getUserId());
    }

    public List<Todo> updateTodo(TodoRequest todo){
        Todo originalTodo = new Todo();
        originalTodo.setValue(todo.getTodo());
        AppUser user = userRepository.findById(todo.getUserId()).get();
        originalTodo.setUser(user);
        todoRepository.save(originalTodo);
        return getAllTodos(todo.getUserId());
    }

    public List<Todo> deleteTodoById(Integer id){
        todoRepository.deleteById(id);
        return getAllTodos(1);
    }
}
