package com.example.imsapi.service;

import com.example.imsapi.domain.User;
import com.example.imsapi.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Optional;
import java.util.concurrent.ExecutionException;

@SpringBootTest
public class UserServiceTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void createUserTest() throws ExecutionException, InterruptedException {
        User user = new User();

        user.setUsername("test");
        user.setPassword("test");

        userRepository.save(user);

        Optional<User> foundUser = userRepository.findFirstByUsername(user.getUsername());

        assertTrue(foundUser.isPresent());

        userRepository.delete(foundUser.get());

        assertEquals(user.getUsername(), foundUser.get().getUsername());
        assertEquals(user.getPassword(), foundUser.get().getPassword());

    }

    @Test
    public void deleteUserTest() throws ExecutionException, InterruptedException {
        User user = new User();

        user.setUsername("test");
        user.setPassword("test");

        userRepository.save(user);

        Optional<User> foundUser = userRepository.findFirstByUsername(user.getUsername());

        assertTrue(foundUser.isPresent());

        userRepository.delete(foundUser.get());

        foundUser = userRepository.findFirstByUsername(user.getUsername());

        assertTrue(foundUser.isEmpty());

    }

}
