package com.example.imsapi.controller;

import com.example.imsapi.config.ImageUtil;
import com.example.imsapi.config.UserPrincipal;
import com.example.imsapi.domain.Image;
import com.example.imsapi.dto.ImageDTO;
import com.example.imsapi.service.ImageService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRange;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/unauthenticated/images")
public class UnauthenticatedController {

    @Autowired
    private ImageService imageService;

    @RequestMapping(path = "", method = RequestMethod.POST, consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
    ResponseEntity<Image> saveImage(@RequestBody ImageDTO image) {
        try {
            Image imageObject = new Image();
            imageObject.setTitle(image.getTitle());
            imageObject.setImage(ImageUtil.compressImage(image.getImage().getBytes()));
            Image _image = imageService.createImage(imageObject);
            return new ResponseEntity<>(_image, HttpStatus.CREATED);
        }
        catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{imageId}")
    ResponseEntity<Image> getImageById(@PathVariable Long imageId) {
        try {
            Image _image = imageService.getImageById(imageId);
            return new ResponseEntity<>(_image, HttpStatus.CREATED);
        }
        catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("")
    ResponseEntity<List<Image>> getAllImages() {
        try {
            List<Image> _images = imageService.getAllImages();
            return new ResponseEntity<>(_images, HttpStatus.OK);
        }
        catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{imageId}")
    ResponseEntity<HttpStatus> deleteImageById(@PathVariable Long imageId) {
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
