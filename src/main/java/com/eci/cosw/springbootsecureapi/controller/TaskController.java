package com.eci.cosw.springbootsecureapi.controller;

import com.eci.cosw.springbootsecureapi.model.Task;
import com.eci.cosw.springbootsecureapi.model.User;
import com.eci.cosw.springbootsecureapi.service.UserService;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class TaskController {

    @GetMapping( "/api/tasks" )
    public ResponseEntity<?> getTasks()
    {
        String tasks = "";
        try{
            tasks = Unirest.get("https://xf4g14p999.execute-api.us-east-1.amazonaws.com/dev/tasks").asString().getBody();
        } catch (UnirestException e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(tasks, HttpStatus.ACCEPTED);
    }

    @RequestMapping(value= "/api/task", method = RequestMethod.POST)
    public ResponseEntity<?> addTask(@RequestBody Task task)
    {
        String response = "";
        try{
            response = Unirest.post("https://xf4g14p999.execute-api.us-east-1.amazonaws.com/dev/task").header("Content-Type", "application/json")
                       .body(task.toString()).asString().getBody();
        } catch (UnirestException e){
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(response, HttpStatus.ACCEPTED);
    }

}
