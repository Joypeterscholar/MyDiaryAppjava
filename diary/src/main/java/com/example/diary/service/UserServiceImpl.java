package com.example.diary.service;

import com.example.diary.data.model.User;
import com.example.diary.data.repo.UserRepository;
import com.example.diary.dtos.request.LoginRequest;
import com.example.diary.dtos.request.RegisterRequest;
import com.example.diary.dtos.response.UserResponse;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;


@Component
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
@Autowired
    public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public UserResponse registerUser(RegisterRequest registerRequest) {
        User user = new User();
        user.setUsername(registerRequest.getUsername());
        user.setEmail(registerRequest.getEmail());

        String hashedPassword = passwordEncoder.encode(registerRequest.getPassword());
        user.setPassword(hashedPassword);

        user = userRepository.save(user);

        UserResponse userResponse = new UserResponse();
        userResponse.setId(user.getId());
        userResponse.setUsername(user.getUsername());
        userResponse.setEmail(user.getEmail());

        return userResponse;
    }

    @Override
    public UserResponse loginUser(LoginRequest loginRequest) {
            User user = userRepository.findByUsername(loginRequest.getUsername());

            if (user != null && passwordEncoder.matches(loginRequest.getPassword(), user.getPassword())) {
                UserResponse userResponse = new UserResponse();
                userResponse.setId(user.getId());
                userResponse.setUsername(user.getUsername());
                userResponse.setEmail(user.getEmail());

                return userResponse;
            } else {
             throw new RuntimeException("invalid password");
            }
    }
}





