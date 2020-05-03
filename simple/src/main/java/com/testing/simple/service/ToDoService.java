package com.testing.simple.service;

import com.testing.simple.model.ToDo;

import java.util.List;

public interface ToDoService {
    public List<ToDo> getAllToDo();
    public ToDo getToDoById(Integer id);
    public ToDo saveToDo(ToDo todo);
    public void removeToDo(ToDo todo);
}
