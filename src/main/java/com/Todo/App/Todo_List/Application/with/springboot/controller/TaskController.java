package com.Todo.App.Todo_List.Application.with.springboot.controller;

import com.Todo.App.Todo_List.Application.with.springboot.model.Task;
import com.Todo.App.Todo_List.Application.with.springboot.service.TaskService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class TaskController {

    public TaskService taskService;

    public TaskController(TaskService taskService){
        this.taskService = taskService;

    }
    @GetMapping
    public String  allTask(Model model){
        List<Task> tasks = taskService.getAllTask();
        model.addAttribute("tasks" , tasks);
        return "task";
    }
     @PostMapping
    public String  createTask(@RequestParam String  name){
        taskService.addTask(name);
        return "redirect:/";
     }

     @GetMapping("/delete/{id}")
     public String deleteById( @PathVariable int id){
    taskService.deleteTask(id);
         return "redirect:/";

     }

     @GetMapping("/toggle/{id}")
     public  String completetask(@PathVariable int id){
        taskService.completeTask(id);
        return "redirect:/";
     }


}
