package com.example.swaggerwithspring.service;

import com.example.swaggerwithspring.entities.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {

    List<User>  getAllUsers();
    User addUser(User user);

    User updateUser(User user,String id);

    String deleteUser(String id);
}
