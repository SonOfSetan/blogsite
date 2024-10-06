package com.thecodinghouse.blogsite.service;

import com.thecodinghouse.blogsite.model.User;
import com.thecodinghouse.blogsite.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User createUser(User user) {
        return userRepository.save(user);  // Save user to database
    }

    public User getUserById(Long id) {
        return userRepository.findById(id).orElse(null);  // Fetch user by ID
    }

}
