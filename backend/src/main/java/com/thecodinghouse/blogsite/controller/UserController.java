package com.thecodinghouse.blogsite.controller;

import com.thecodinghouse.blogsite.model.User;
import com.thecodinghouse.blogsite.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/createUser")
    public User createUser(@RequestBody User user) {
        return userService.createUser(user);  // API to create user
    }

    @GetMapping("/findByUserId/")
    public User getUserById(@RequestParam Long id) {
        return userService.getUserById(id);  // API to get user by ID
    }
}
