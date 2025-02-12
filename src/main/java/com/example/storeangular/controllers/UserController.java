package com.example.storeangular.controllers;

import com.example.storeangular.entities.User;
import com.example.storeangular.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(path = "/users")
@CrossOrigin(origins = "http://localhost:4200")
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @GetMapping(path = "/all")
    public Iterable<User> getAllUsers(){
        return userRepository.findAll();
    }

    @GetMapping(path = "/findById")
    public Optional<User> getUserById(@RequestParam  Integer userID){
        return userRepository.findById(userID);
    }
}
