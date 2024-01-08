package com.example.dtoslearning.controller;

import com.example.dtoslearning.dto.UserDto;
import com.example.dtoslearning.exportDataToExcelImplementation.UserExcelExporter;
import com.example.dtoslearning.model.User;
import com.example.dtoslearning.service.UserService;
import jakarta.persistence.EntityManager;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class UserController {
    @Autowired
    UserService userService;
    @Autowired
    EntityManager entityManager;


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
    public Map<String, Long> getUserCount(){
        Map map = new HashMap<>();
        map.put("no.of users",userService.countUsers());
        return map;
    }

    @GetMapping("/getUserHistory/{id}")
    public List getUserHistory(@PathVariable("id") long id){
        return userService.getHistory(id);
    }


    @PutMapping("/update/users/{id}")
    public User updateUserRecord(@PathVariable("id") long id,@RequestBody User user){
//        User user1 = entityManager.find(User.class,id);
//        if (user1!=null) {
//            return entityManager.merge(user);
//        }else{
//            throw  new RuntimeException();
//        }
        return userService.updateUser(id,user);
    }

    @GetMapping("/users/export")
    public void exportToExcel(HttpServletResponse response) throws IOException {
        response.setContentType("application/octet-stream");
        String headerKey = "Content-Disposition";
        String headerValue = "attachment; filename=users.xlsx";

        response.setHeader(headerKey, headerValue);

        List<UserDto> userList = userService.getAllUsersInformation();

        UserExcelExporter userExcelExporter = new UserExcelExporter(userList);
        userExcelExporter.export(response);
    }
}
