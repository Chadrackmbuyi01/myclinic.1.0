package com.fokatech.myclinic10.service;

import com.fokatech.myclinic10.model.User;
import com.fokatech.myclinic10.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

    public User getUserById(Long id){
        Optional<User> user = userRepository.findById(id);
        return user.orElseThrow(() -> new RuntimeException("User not found with id: " + id));
    }

    public User getUserByUsername(String username){
        User user = userRepository.findByUsername(username);

        if (user == null){
            throw new RuntimeException("User not found with username: " + username);
        }
        return user;
    }

    public User createUser(User user){
        if (user.getUsername() == null || user.getPassword() == null){
            throw new IllegalArgumentException("Username and password are required");
        }
        return userRepository.save(user);
    }

    public User updateUser(Long id, User userDetails){
        User user = getUserById(id);
        user.setUsername(userDetails.getUsername());
        user.setPassword(userDetails.getPassword());
        return userRepository.save(user);
    }

    public void deleteUser(Long id){
        User user = getUserById(id);
        userRepository.delete(user);
    }
}
