package com.example.test.controller;

import com.example.test.model.User;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping(value = "/users")
public interface UserController {

    @GetMapping
    List<User> getUsers();

    @PostMapping
    User createUser(@RequestBody User user);

    @PutMapping("/{id}")
    User updateUser(
            @PathVariable int id,
            @RequestParam String ime,
            @RequestParam String prezime,
            @RequestParam String email,
            @RequestParam String telefonskiBroj);
}
