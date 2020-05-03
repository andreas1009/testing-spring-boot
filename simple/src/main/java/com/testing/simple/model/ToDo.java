package com.testing.simple.model;


import javax.persistence.*;

@Entity
@Table(name = "todo")
public class ToDo {


    @Id
    @GeneratedValue
    @Column(name = "id")
    private Integer id;

    @Column(name = "text")
    private String text;

    @Column(name = "completed")
    private boolean completed;

    public ToDo(){

    }

    public ToDo(Integer id, String text, boolean completed) {
        this.id = id;
        this.text = text;
        this.completed = completed;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }
}
