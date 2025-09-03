package com.Todo.App.Todo_List.Application.with.springboot.service;

import com.Todo.App.Todo_List.Application.with.springboot.model.Task;
import com.Todo.App.Todo_List.Application.with.springboot.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;

//    Get all task

    public List<Task> getAllTask (){
        return  taskRepository.findAll();
    }

//    Add  particular task

    public  Task addTask( String name){
        Task task = new Task();
        task.setName(name);
        task.setCompletion(false);
        return  taskRepository.save(task);
    }

//    Delete task by id
    public  void deleteTask(int id){
        taskRepository.deleteById(id);
    }

//    To toggle between task whether completed or not
    public void completeTask(int id) {
        Task task = taskRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid id provided"));
        task.setCompletion(!task.isCompletion());
        taskRepository.save(task);
    }
}
