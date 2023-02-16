package com.example.userapp.controller;

import com.example.userapp.model.UserAppModel;
import com.example.userapp.repository.UserAppRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
public class UserAppController 
{

    private UserAppRespository userRespository;

    @Autowired
    public UserAppController(UserAppRespository userRespository) 
    {
        this.userRespository = userRespository;
    }

    @GetMapping("/user/all")
    Iterable<UserAppModel> all() 
    {
        return userRespository.findAll();
    }

    @GetMapping("/user/{id}")
    UserAppModel userById(@PathVariable Long id) 
    {
        return userRespository.findById(id).orElseThrow(() -> new ResponseStatusException(
                HttpStatus.NOT_FOUND));
    }

    @PostMapping("/user/save")
    UserAppModel save(@RequestBody UserAppModel user) 
    {
        return userRespository.save(user);
    }

}