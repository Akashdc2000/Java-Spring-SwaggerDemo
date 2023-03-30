package com.example.swaggerwithspring.controller;

import com.example.swaggerwithspring.entities.User;
import com.example.swaggerwithspring.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<User> getAllUser(){
        return userService.getAllUsers();
    }

    @PostMapping
    public User addUser(@RequestBody User user){
        return userService.addUser(user);
    }

    @PatchMapping("/{id}")
    public User updateUser(@RequestBody User user,@PathVariable("id") String id){
        return userService.updateUser(user,id);
    }

    @DeleteMapping("/{id}")
    public  String deleteUser(@PathVariable("id")String id){
        return userService.deleteUser(id);
    }
}
