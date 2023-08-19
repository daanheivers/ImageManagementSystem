package com.example.imsapi.service;

import com.example.imsapi.domain.User;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
    User createUser(User user);
}
