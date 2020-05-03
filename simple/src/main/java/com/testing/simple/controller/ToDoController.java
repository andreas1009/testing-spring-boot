package com.testing.simple.controller;

import com.testing.simple.exception.ToDoException;
import com.testing.simple.model.ToDo;
import com.testing.simple.service.ToDoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/todo")
public class ToDoController {

    private static final Logger logger = LoggerFactory.getLogger(ToDoController.class);

    @Autowired
    private ToDoService toDoService;

    @GetMapping(value="/")
    public ResponseEntity<List<ToDo>> getAllToDo(){
        logger.info("Returning all the do");
        return new ResponseEntity<List<ToDo>>(toDoService.getAllToDo(), HttpStatus.OK);
    }


    @RequestMapping(value = "/find/{id}")
    public ResponseEntity<ToDo> getToDoById(@PathVariable("id") Integer id) throws ToDoException {
        logger.info("Return with id "+ id);
        ToDo todo = toDoService.getToDoById(id);
        if(todo == null || todo.getId() <= 0){
            throw new ToDoException("Does't exist");
        }
        return new ResponseEntity<ToDo>(toDoService.getToDoById(id), HttpStatus.OK);

    }


    @PostMapping(value = "/save")
    public ResponseEntity<ToDo> saveToDo(@RequestBody ToDo toDo) throws ToDoException{
        logger.info("ToDo save : " + toDo);
        return new ResponseEntity<ToDo>(toDoService.saveToDo(toDo), HttpStatus.OK);
    }

    @DeleteMapping(value = "/delete/{id}")
    public String removeToDoById(@PathVariable("id") Integer id) throws ToDoException{
        logger.info("ToDo remove Id : "+ id);
        ToDo toDo = toDoService.getToDoById(id);
        if (toDo == null || toDo.getId() <= 0){
            throw new ToDoException("ToDo doesn't exception");
        }
        toDoService.removeToDo(toDo);
        return "berhasil";
    }


//    public ResponseEntity<ToDo> updateToDo(@RequestBody ToDo toDo) throws ToDoException{
//        logger.info("Update ToDo " + toDo);
//        ToDo toDo1 = toDoService.getToDoById(toDo.getId());
//        if(toDo1 == null || toDo1.getId() <= 0){
//            throw new ToDoException("ToDo doesn't exist");
//        }
//
//        return new ResponseEntity<ToDo>(toDoService.saveToDo())
//    }



}
