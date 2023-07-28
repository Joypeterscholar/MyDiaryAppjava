package com.example.diary.controller;


import com.example.diary.data.model.User;
import com.example.diary.dtos.request.LoginRequest;
import com.example.diary.dtos.request.RegisterRequest;
import com.example.diary.dtos.response.UserResponse;
import com.example.diary.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public ResponseEntity<UserResponse> registerUser(@RequestBody RegisterRequest registerRequest) {
        UserResponse createdUser = userService.registerUser(registerRequest);
        return new ResponseEntity<>(createdUser, HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public ResponseEntity<UserResponse> loginUser(@RequestBody LoginRequest loginRequest) {
        UserResponse userResponse = userService.loginUser(loginRequest);
        if (userResponse != null) {
            return ResponseEntity.ok(userResponse);
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
    }
}

