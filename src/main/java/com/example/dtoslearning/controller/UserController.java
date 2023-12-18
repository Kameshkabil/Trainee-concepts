package com.example.dtoslearning.controller;

import com.example.dtoslearning.dto.UserDto;
import com.example.dtoslearning.model.User;
import com.example.dtoslearning.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class UserController {
    @Autowired
    UserService userService;


//    @PostMapping("/createUser")
//    public ResponseEntity createNewUserAccount(@RequestBody User user){
//        userService.createUserAccount(user);
//        //return "Account Created Successfully";
//        return new ResponseEntity("Account Created Successfully", HttpStatus.CREATED);
//    }

//    @GetMapping("/allUsers")
//    public List<UserDto> getAllUsers(){
//        return userService.getAllUsers();
//    }

    @PostMapping("/createUser")
    public ResponseEntity createNewUserAccount(@RequestBody User user){
       userService.createNewUser(user);
        //return "Account Created Successfully";
        return new ResponseEntity("Account Created Successfully", HttpStatus.CREATED);
    }

    @GetMapping("/allUsers")
    public List<UserDto> getAllUsers(){
        List<UserDto> listUsers = userService.getAllUsersInformation();
        return listUsers;
    }

    @GetMapping("/user/{id}")
    public User findUserById(@PathVariable("id") Integer id){
        return userService.findById(id);
    }


    @DeleteMapping("/deleteUser/{id}")
    public String deleteUserById(@PathVariable("id") Integer id){
        userService.deleteUserById(id);
        return "Deleted Successfully";
    }

    @GetMapping("/usersCount")
    public String getUserCount(){
        return "Available Users : "+userService.countUsers();
    }
}
