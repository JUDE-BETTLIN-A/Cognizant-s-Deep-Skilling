package com.example.User.Service.Project.controller;

import com.example.User.Service.Project.entity.user;
import com.example.User.Service.Project.reository.userRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class userController {

    @Autowired
    private userRepository userRepository;

    @PostMapping
    public user createUser(@RequestBody user user) {
        return userRepository.save(user);
    }

    @GetMapping("/{id}")
    public user getUser(@PathVariable Long id) {
        return userRepository.findById(id).orElse(null);
    }

    @GetMapping
    public List<user> getAllUsers() {
        return userRepository.findAll();
    }
}
