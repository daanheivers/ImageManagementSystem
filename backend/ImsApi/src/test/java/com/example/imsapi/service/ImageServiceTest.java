package com.example.imsapi.service;

import com.example.imsapi.domain.User;
import com.example.imsapi.repository.ImageRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;
import java.util.concurrent.ExecutionException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class ImageServiceTest {

    @Autowired
    private ImageRepository imageRepository;

    @Test
    public void createImageTest() throws ExecutionException, InterruptedException {

    }
}
