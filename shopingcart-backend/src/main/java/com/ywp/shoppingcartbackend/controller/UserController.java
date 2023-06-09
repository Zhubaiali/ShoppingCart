package com.ywp.shoppingcartbackend.controller;

import com.ywp.shoppingcartbackend.domain.User;
import com.ywp.shoppingcartbackend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity<User> register(@RequestBody User user) {
        User registeredUser = userService.register(user);
        return ResponseEntity.ok(registeredUser);
    }

    @PostMapping("/login")
    public ResponseEntity<User> login(@RequestBody Map<String, String> credentials) {
        String username = credentials.get("username");
        String password = credentials.get("password");
        User loggedInUser = userService.login(username, password);
        return ResponseEntity.ok(loggedInUser);
    }

    @PatchMapping("/{userId}/location")
    public ResponseEntity<User> updateLocation(@PathVariable Integer userId, @RequestParam String location) {
        User updatedUser = userService.updateLocation(userId, location);
        return ResponseEntity.ok(updatedUser);
    }
}