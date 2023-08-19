package com.example.imsapi.service;

import java.util.List;
import com.example.imsapi.domain.Image;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public interface ImageService{
    Image createImage(Image image);
    Image getImageById(Long id);
    List<Image> getAllImages();
    void deleteImageById(Long Id);
}
