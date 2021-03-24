package com.eci.cosw.springbootsecureapi.model;

import org.springframework.core.style.ToStringCreator;

public class Task {
    private int id;
    private String description;
    private User responsible;
    private String status;
    private String dueDate;

    public Task(int id, String description, User responsible, String status, String dueDate){
        this.id = id;
        this.description = description;
        this.responsible = responsible;
        this.status = status;
        this.dueDate = dueDate;
    }

    public Task (){

    }

    public int getId(){
        return this.id;
    }

    public void setId(int id){
        this.id = id;
    }

    public String getDescription(){
        return this.description;
    }

    public void setDescription(String description){
        this.description = description;
    }

    public String getStatus(){
        return this.status;
    }

    public void setStatus(String status){
        this.status = status;
    }

    public String getDueDate(){
        return this.dueDate;
    }

    public void setDueDate(String dueDate){
        this.dueDate = dueDate;
    }

    public User getResponsible(){
        return this.responsible;
    }

    public void setResponsible(User responsible){
        this.responsible = responsible;
    }

    @Override
    public String toString(){
        return "{" + "\"id\":" + this.id + ", \"description\":\"" + this.description +  "\", \"responsible\":{\"email\": \"" + this.responsible.getEmail() + 
        "\", \"name\": \"" + this.responsible.getname() + "\"}, \"status\": \"" + this.status + "\", \"dueDate\": \"" + this.dueDate + "\"}";  
    }

    
}
