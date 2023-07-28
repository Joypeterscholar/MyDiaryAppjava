package com.example.diary.service;

import com.example.diary.data.model.User;
import com.example.diary.dtos.request.RegisterRequest;
import com.example.diary.dtos.response.UserResponse;
import com.example.diary.dtos.request.LoginRequest;

public interface UserService {
    UserResponse registerUser(RegisterRequest registerRequest);
    UserResponse loginUser(LoginRequest loginRequest);
}
