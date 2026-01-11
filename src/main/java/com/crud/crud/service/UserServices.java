package com.crud.crud.service;

import com.crud.crud.model.User;
import com.crud.crud.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
//Service class
@Service
public class UserServices {
    @Autowired
    UserRepository userRepository;

    public User createUsers(User user) {
        return userRepository.save(user);
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User getUserByIds(Long id) {
        return userRepository.findById(id).orElseThrow(()-> new RuntimeException("Kuch nahi hai yeha"));
    }

    public User updateUsers(Long id, User user) {
        User existingUser = getUserByIds(id);
        existingUser.setName(user.getName());
        existingUser.setEmail(user.getEmail());
        existingUser.setAddress(user.getAddress());
        return userRepository.save(existingUser);
    }

    public String deleteUsers(Long id) {
         userRepository.deleteById(id);
         return "delete kr diye re baba";
    }
}
