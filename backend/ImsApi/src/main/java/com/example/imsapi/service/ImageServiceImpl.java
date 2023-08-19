package com.example.imsapi.service;

import com.example.imsapi.domain.Image;
import com.example.imsapi.repository.ImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ImageServiceImpl implements ImageService {

    @Autowired
    private ImageRepository imageRepository;

    @Override
    public Image createImage(Image image) {
       return imageRepository.save(image);
    }

    @Override
    public Image getImageById(Long id) {
        return imageRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Image Not Found"));
    }

    @Override
    public List<Image> getAllImages() {
        return imageRepository.findAll();
    }

    @Override
    public void deleteImageById(Long id) {
        this.getImageById(id);
        imageRepository.deleteById(id);
    }
}
