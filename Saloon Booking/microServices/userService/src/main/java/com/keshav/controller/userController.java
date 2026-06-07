package com.keshav.controller;

import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.keshav.model.user;
import com.keshav.services.userService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class userController {

    private final userService userService;

    @PostMapping
    public ResponseEntity<user> createUser(@RequestBody @Valid user user) {
        user createdUser = userService.createUser(user);
        return new ResponseEntity<>(createdUser,HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<user>> getUsers() {
        List<user> users = userService.getAllUsers();
        return new ResponseEntity<>(users,HttpStatus.OK);
    }

    @GetMapping("/{userId}")
    public ResponseEntity<user> getUserById(@PathVariable("userId") Long id) {
           user user = userService.getUserById(id);
           return new ResponseEntity<>(user,HttpStatus.OK);
    }
    

    @PutMapping("/{id}")
    public ResponseEntity<user> updateUser(@RequestBody user user, @PathVariable("id") Long id) {
        user updateUser = userService.updateUser(id, user);
           return new ResponseEntity<>(updateUser,HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUserById(@PathVariable Long id) {
          userService.deleteUser(id);
          return new ResponseEntity<>("User deleted",HttpStatus.ACCEPTED);
    } 
}
