package com.example.springboottodoapplication.controllers;

import com.example.springboottodoapplication.models.TodoItem;
import com.example.springboottodoapplication.repositories.TodoItemRepository;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class TodoFormController {

    private final Logger logger = LoggerFactory.getLogger(TodoFormController.class);

    @Autowired
    private TodoItemRepository todoItemRepository;

    @GetMapping("/edit/{id}")
    public String showUpdateForm(@PathVariable("id") long id, Model model){
        TodoItem todoItem = todoItemRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("TodoItem id: " +id+ " not found"));

        model.addAttribute("todo", todoItem);
        return "update-todo-item";
    }

}
