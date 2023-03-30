package com.example.swaggerwithspring.service;

import com.example.swaggerwithspring.entities.User;
import com.example.swaggerwithspring.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImplementation implements UserService{

    private final UserRepository userRepository;

    public UserServiceImplementation(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User addUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User updateUser(User user, String id) {

        Optional<User> modifiedUser=userRepository.findById(id);

        if(modifiedUser.isPresent()){
            modifiedUser.get().setUserName(user.getUserName());
            modifiedUser.get().setAge(user.getAge());
            modifiedUser.get().setEmail(user.getEmail());
            return userRepository.save(modifiedUser.get());
        }
        return userRepository.save(user);
    }

    @Override
    public String deleteUser(String id) {
        if(userRepository.findById(id).isPresent()){
            userRepository.deleteById(id);
            return "User Deleted Successfully...";
        }

        return "User Not Present ...";
    }
}
