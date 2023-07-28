package com.example.diary;

import static org.junit.jupiter.api.Assertions.*;

import com.example.diary.data.model.User;
import com.example.diary.data.repo.DiiaryRepository;
import com.example.diary.data.repo.UserRepository;
import com.example.diary.dtos.request.LoginRequest;
import com.example.diary.dtos.request.RegisterRequest;
import com.example.diary.dtos.response.UserResponse;
import com.example.diary.service.DiiaryServiceImpl;
import com.example.diary.service.UserService;
import com.example.diary.service.UserServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Optional;

@ExtendWith(SpringExtension.class)
@DataJpaTest
public class UserTest {

    private  UserRepository userRepository;
    private UserService userService;
    @Autowired
    public void UserServiceImplTest(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.userService = new UserServiceImpl(userRepository, passwordEncoder);
    }

    @Test
    public void testSaveUser() {
        User user = new User();
        user.setUsername("testUser");
        user.setEmail("test@example.com");
        user.setPassword("testPassword");

        User savedUser = userRepository.save(user);

        assertNotNull(savedUser.getId());
        assertEquals("testUser", savedUser.getUsername());
        assertEquals("test@example.com", savedUser.getEmail());
        assertEquals("testPassword", savedUser.getPassword());
    }
@Test
public void testToRegisterUser(){
    RegisterRequest request = new RegisterRequest();
    request.setUsername("joy");
    request.setEmail("joy123@gmail.com");
    request.setPassword("1234");

    UserResponse response = userService.registerUser(request);

    assertNotNull(response);
    assertEquals("joy", response.getUsername());

}
    @Test
    public void testToLoginUser(){
        RegisterRequest request = new RegisterRequest();
        request.setUsername("joy");
        request.setEmail("joy123@gmail.com");
        request.setPassword("1234");
        userService.registerUser(request);

        LoginRequest req = new LoginRequest();
        req.setUsername("joy");
        req.setPassword("1234");

        UserResponse response =userService.loginUser(req);
        assertNotNull(response);
        assertEquals("joy", response.getUsername());

    }

    @Test
    public void testFindUserByUsername() {
        User user = new User();
//        user.setId(2367L);
        user.setUsername("testUser");
        user.setEmail("test@example.com");
        user.setPassword("testPassword");
        userRepository.save(user);

        Optional<User> foundUser = Optional.ofNullable(userRepository.findByUsername("testUser"));
        assertTrue(foundUser.isPresent());
        assertEquals("test@example.com", foundUser.get().getEmail());
    }

    @Test
    public void testFindUserByEmail() {
        User user = new User();
        user.setUsername("testUser");
        user.setEmail("test@example.com");
        user.setPassword("testPassword");
        userRepository.save(user);

        Optional<User> foundUser = Optional.ofNullable(userRepository.findByEmail("test@example.com"));
        assertTrue(foundUser.isPresent());
        assertEquals("testUser", foundUser.get().getUsername());
    }
}

