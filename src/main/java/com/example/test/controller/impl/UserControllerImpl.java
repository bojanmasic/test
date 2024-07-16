package com.example.test.controller.impl;

import com.example.test.controller.UserController;
import com.example.test.model.User;
import com.example.test.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserControllerImpl implements UserController {

    private final UserService userService;

    public UserControllerImpl(final UserService userService) {
        this.userService = userService;
    }

    @Override
    @GetMapping
    public List<User> getUsers() {
        return userService.getAllUsers();
    }

    @Override
    @PostMapping
    public User createUser(@RequestBody User user) {
        return userService.saveUser(user);
    }

    @Override
    @PutMapping("/{id}")
    public User updateUser(
            @PathVariable int id,
            @RequestParam String ime,
            @RequestParam String prezime,
            @RequestParam String email,
            @RequestParam String telefonskiBroj) {
        return userService.updateUser(id, ime, prezime, email, telefonskiBroj);
    }
}
