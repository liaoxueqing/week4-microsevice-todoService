package com.thoughtworks.training.xueqing.todoservice.controller;

import com.thoughtworks.training.xueqing.todoservice.model.Todo;
import com.thoughtworks.training.xueqing.todoservice.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/todos")
public class TodoController {
    @Autowired
    private TodoService todoService;

    @GetMapping
    public List<Todo> getTodos(Principal user) {
        return todoService.findAll(user.getName());
    }

    @GetMapping("/{id}")
    public Todo getOneById(@PathVariable Integer id, Principal user) {
        return todoService.findById(id, user.getName());
    }

    @PostMapping
    public Todo save(@RequestBody Todo todo) {
        System.out.println("+++"+ todo);
        return todoService.save(todo);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable Integer id, @RequestBody Todo todo) {
        todoService.update(id, todo);
    }

    @PutMapping("/completed/{id}")
    public void completed(@PathVariable Integer id) {
        todoService.completed(id);
    }

    @DeleteMapping("/{id}")
    public void deleted(@PathVariable Integer id) {
        todoService.deleted(id);
    }

}
