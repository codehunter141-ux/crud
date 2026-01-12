package com.crud.crud.controller;

import com.crud.crud.model.User;
import com.crud.crud.service.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/api/rest")
public class UserController {
    @Autowired
    UserServices userServices;

    @PostMapping("/create")
    public User createUser(@RequestBody User user){
        return userServices.createUsers(user);
    }

    @GetMapping("/getall")
    public List<User> getAllUser(){
        return userServices.getAllUsers();
    }
    @GetMapping("/getuser/{id}")
    public User getUserbyId(@PathVariable Long id){
        return userServices.getUserByIds(id);
    }
    @PutMapping("/update/{id}")
    public User updateUser(@PathVariable Long id,@RequestBody User user){
        return userServices.updateUsers(id, user);
    }
    @DeleteMapping("/delete/{id}")
    public String deleteUser(@PathVariable Long id){
        return userServices.deleteUsers(id);
    }
}
