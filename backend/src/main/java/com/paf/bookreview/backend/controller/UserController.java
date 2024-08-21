package com.paf.bookreview.backend.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.paf.bookreview.backend.exception.UnauthorizedException;
import com.paf.bookreview.backend.model.Role;
import com.paf.bookreview.backend.model.User;
import com.paf.bookreview.backend.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/{id}")
    public Optional<User> getUserById(@PathVariable Long id) {
        return userService.getUserById(id);
    }

    @PostMapping
    public User createUser(@RequestBody User user) {
        // Check if the user is an admin
        if (user.getRole() == Role.ADMIN) {
            return userService.saveUser(user);
        } else {
            throw new UnauthorizedException("Only admins can create users");
        }
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id, @RequestBody User requestingUser) {
        // Check if the requesting user is an admin
        if (requestingUser.getRole() == Role.ADMIN) {
            userService.deleteUser(id);
        } else {
            throw new UnauthorizedException("Only admins can delete users");
        }
    }
}
