package eu.delebarre.testspring.restservices.controllers;

import eu.delebarre.testspring.restservices.model.User;
import eu.delebarre.testspring.restservices.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/users")
    public Object getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/users/{id}")
    public User getUserById(@PathVariable UUID id) {
        return userService.getUserById(id);
    }

    @PutMapping("/users")
    public boolean updateUser(@RequestBody User user) {
        return userService.updateUser(user);
    }

    @PostMapping("/user")
    public boolean addUser(@RequestBody String userName) {
        User user = new User(userName);
        return userService.addUser(user);
    }

}
