package com.example.todo.controller;


import com.example.todo.entity.User;
import com.example.todo.service.UserService;
import org.springframework.web.bind.annotation.*;


@RestController
@CrossOrigin(origins = {"http://localhost:3000"})
public class UserController {

    private UserService userService;
    UserController(UserService userService){
        this.userService = userService;
    }

    @GetMapping("/login")
    private User getCurrentUser(@RequestBody User user){
        System.out.println("Get User By userName and password");
        return userService.getUser(user);
    }

    @GetMapping("/login/{userName}/{password}")
    private boolean findUserByUserName(@PathVariable String userName, @PathVariable String password){
        System.out.println("Get User By UserName and Password");
        return userService.getUserByUserName(userName, password);
    }

    @PostMapping("/createUser")
    private boolean addUser(@RequestBody User user){
        boolean userExists = userService.findByUserName(user.getUserName());
        if(userExists){
            System.out.println("Cant create User");
            return false;
        }
        userService.saveUser(user);

        return true;
    }
}
