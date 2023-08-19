package com.example.imsapi.controller;

import com.example.imsapi.domain.Image;
import com.example.imsapi.domain.User;
import com.example.imsapi.service.ImageService;
import com.example.imsapi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private ImageService imageService;


    @PostMapping("")
    ResponseEntity<User> createUser(@RequestBody User user) {
        try {
            User _user = userService.createUser(user);
            return new ResponseEntity<>(_user, HttpStatus.CREATED);
        }
        catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/{userId}/images")
    ResponseEntity<Image> saveImage(@RequestBody Image image, @PathVariable Long userId) {
        try {
            Image _image = imageService.createImage(image);
            return new ResponseEntity<>(_image, HttpStatus.CREATED);
        }
        catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{userId}/images/{imageId}")
    ResponseEntity<Image> getImageById(@PathVariable Long userId, @PathVariable Long imageId) {
        try {
            Image _image = imageService.getImageById(imageId);
            if (_image.getUser().getId().equals(userId)){
                return new ResponseEntity<>(_image, HttpStatus.CREATED);
            }
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{userId}/images")
    ResponseEntity<List<Image>> getAllImages(@PathVariable Long userId) {
        try {
            List<Image> _images = imageService.getAllImages();
            return new ResponseEntity<>(_images, HttpStatus.CREATED);
        }
        catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{userId}/images/{imageId}")
    ResponseEntity<HttpStatus> deleteImageById(@PathVariable Long userId, @PathVariable Long imageId) {
        try {
            imageService.deleteImageById(imageId);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        catch(IllegalArgumentException exc) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
