package com.example.imsapi.service;

import com.example.imsapi.domain.User;
import com.example.imsapi.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.concurrent.ExecutionException;

@SpringBootTest
public class UserServiceTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void createUserTest() throws ExecutionException, InterruptedException {
        User user = new User();

        user.setId(1L);


        userRepository.save(user);

    }

}
