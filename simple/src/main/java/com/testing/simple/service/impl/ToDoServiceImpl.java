package com.testing.simple.service.impl;

import com.testing.simple.model.ToDo;
import com.testing.simple.repository.ToDoRepository;
import com.testing.simple.service.ToDoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("toDoService")
public class ToDoServiceImpl implements ToDoService {

    @Autowired
    private ToDoRepository toDoRepository;

    @Override
    public List<ToDo> getAllToDo() {
        return toDoRepository.findAll();
    }

    @Override
    public ToDo getToDoById(Integer id) {
        return toDoRepository.findFirstById(id);
    }

    @Override
    public ToDo saveToDo(ToDo todo) {
        return toDoRepository.save(todo);
    }

    @Override
    public void removeToDo(ToDo todo) {
        toDoRepository.delete(todo);
    }
}
