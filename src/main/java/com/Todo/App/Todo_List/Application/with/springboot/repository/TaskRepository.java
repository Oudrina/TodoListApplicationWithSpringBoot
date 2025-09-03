package com.Todo.App.Todo_List.Application.with.springboot.repository;

import com.Todo.App.Todo_List.Application.with.springboot.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepository extends JpaRepository<Task,Integer> {
}
