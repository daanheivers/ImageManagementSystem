package com.example.imsapi.controller;

import com.example.imsapi.config.UserPrincipal;
import com.example.imsapi.domain.Image;
import com.example.imsapi.service.ImageService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRange;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/users/{userId}/images")
public class ImageController {

    @Autowired
    private ImageService imageService;

    @PostMapping("")
    @PreAuthorize("hasRole('USER')")
    ResponseEntity<Image> saveImage(@RequestBody Image image, @PathVariable Long userId) {
        try {
            Image _image = imageService.createImage(image);
            return new ResponseEntity<>(_image, HttpStatus.CREATED);
        }
        catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{imageId}")
    @PreAuthorize("hasRole('USER')")
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

    @GetMapping("")
    @PreAuthorize("hasRole('USER')")
    ResponseEntity<List<Image>> getAllImages(@PathVariable Long userId, HttpServletRequest request) {
        try {
            List<Image> _images = imageService.getAllImages();
            return new ResponseEntity<>(_images, HttpStatus.OK);
        }
        catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{imageId}")
    @PreAuthorize("hasRole('USER')")
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
