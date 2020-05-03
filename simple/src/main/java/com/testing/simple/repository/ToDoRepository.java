package com.testing.simple.repository;

import com.testing.simple.model.ToDo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ToDoRepository extends JpaRepository<ToDo, Integer> {

    @Query("SELECT t FROM ToDo t WHERE t.id = ?1")
    ToDo findFirstById(Integer id);
}
