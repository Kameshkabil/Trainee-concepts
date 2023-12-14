package com.example.dtoslearning.controller;

import com.example.dtoslearning.dto.UserDto;
import com.example.dtoslearning.model.User;
import com.example.dtoslearning.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class UserController {
    @Autowired
    UserService userService;

    @PostMapping("/createUser")
    public String createNewUserAccount(@RequestBody User user){
        userService.createUserAccount(user);
        return "Account Created Successfully";
    }

    @GetMapping("/allUsers")
    public List<UserDto> getAllUsers(){
        return userService.getAllUsers();
    }
}
